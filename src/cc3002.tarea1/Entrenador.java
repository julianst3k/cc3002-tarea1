package cc3002.tarea1;
import java.util.ArrayList;
public class Entrenador implements IEntrenador {
    /** Defines the trainer. The trainer is allowed to see his cards and do actions with it.
     * @author: Julian Solis Torrejon
     */
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<ICardPlayable> Mano;
    private Mazo mazo;
    private CardStack pila;
    private Premio premio;
    private IPokemon objective;
    public Entrenador(Pokemon pokemonActivo, Mazo newMazo, Premio newPremio){ // Defino el inicio del juego con un pokemon activo :)
        Activa = pokemonActivo;
        objective = Activa;
        Banca = new ArrayList<Pokemon>();
        Mano = new ArrayList<ICardPlayable>();
        pila = new CardStack();
        premio = newPremio;
        if(newMazo.getSize()==60) {
            mazo = newMazo;
        }
        else {
            System.out.println("No hay suficientes cartas para iniciar");
            throw new AssertionError();
        }
    }

    @Override
    public void activePokemonSwap(){
        if(this.cantidadBanca()==0){
            return;
        }
        else if(!this.getActiva().isDed()){
            Pokemon AuxActive=this.getActiva();
            this.Activa=this.Banca.get(0);
            this.Banca.remove(0);
            this.Banca.add(AuxActive);
        }
        else {
            this.Activa = this.Banca.get(0);
            this.Banca.remove(0);
        }
    }

    @Override
    public void deadActive(){
        if(this.getActiva().isDed()){
            pila.addCarta(this.getActiva());
            this.activePokemonSwap();
        }
    }

    @Override
    public String cardInfo(ICardPlayable card){
        return card.getDescrp();
    }

    /** Show the info of the skills of the active pokemon
     *
     * @return A string with the skills of the active pokemon
     */
    public String activeSkillsInfo(){
         return "Los ataques del Pokemon son: "+this.Activa.showSkills();
    }

    /** Show the info of the selected skill
     *
     * @return A string with the skills of the active selected pokemon
     */
    public String activeSelectedSkill() {
        if (this.getActiva().getSelectedSkill() != null) {
            return "El ataque selecto es: " + this.getActiva().showSkill(this.getActiva().getSelectedSkillIndex());
        }
        else{
            return "No hay ataque selecto";
        }
    }

    @Override
    public void selectAttack(int indexAttack){ // Me imagino que el ataque es una clase
        this.Activa.selectSkill(indexAttack-1);
    }

    @Override
    public void sacarCarta(ICardPlayable newCard){
        this.Mano.add(newCard);
    }

    /** Set an energy in the pokemon
     *
     * @param energyCard An energy
     */
    public void activeUseEnergy(Energy energyCard){
        this.objective.setEnergy(energyCard);
    }

    @Override
    public Pokemon getActiva(){
        return this.Activa;
    }

    /** Set the objective for the energy card, this will be played by the controller
     *
     * @param card the card that will be played
     */
    public void cardObjective(IPokemon card){
        if(this.getBanca().contains(card) || this.getActiva()==card){
            this.objective = card;
        }
    }
    /** Gets the info of a card that is on the 5-Pokemon's list
     *
     * @param index The index + 1 of the pokemon
     * @return A string of information
     */
    public String cardInfoBanca(int index){
        String result = "";
        if(index<=this.cantidadBanca()){
             result += index+". "+cardInfo(this.getBanca().get(index-1));
        }
        return result;
    }
    /** Print in the console the active pokemon info
     *
     */
    public void activeInfo(){
       System.out.println(cardInfo(this.Activa));
    }
    /** Print in the console the cards that are not being played yet
     *
     */
    public void manoInfo(){
        System.out.println(this.showMano());
    }
    /** Print in the console the reserve pokemon info
     *
     */
    public void bancaInfo(){
        for(int i=1; i<=this.getBanca().size(); i++) {
            System.out.println(cardInfoBanca(i));
        }
    }
    @Override
    public void jugarCarta(int cardIndex){
        if(cardIndex>0 && cardIndex<=this.Mano.size()) {
            ICardPlayable Card = this.Mano.get(cardIndex - 1);
            this.Mano.remove(cardIndex - 1);
            Card.jugarCarta(this);
        }
    }

    /** Get the info of some card in the set of cards
     *
     * @param index Index + 1 of the card
     * @return A string with the information
     */
    public String cardInfoMano(int index){
        if(this.getMano().size()>=index){
            return this.cardInfo(this.getMano().get(index-1));
        }
        else{
            return "";
        }
    }

    /** Plays a pokemon card. This is thrown by the playCard() when the argument is a Pokemon card
     *
     * @param poke A pokemon card
     */
    public void jugarCartaPokemon(Pokemon poke){
        if(this.cantidadBanca()<5){
            this.Banca.add(poke);
            this.deadActive();
        }
        else{
            this.Mano.add(poke);
        }
    }

    /** Same as above, but with the energy card
     *
     * @param cardE A energy card
     */
    public void jugarCartaEnergia(Energy cardE){
        this.activeUseEnergy(cardE);
    }

    @Override
    public ArrayList<Pokemon> getBanca(){
        return this.Banca;
    }

    /** Get the size of the played pokemon's that are not active. This exists so we can evade null access
     *
     * @return The size
     */
    public int cantidadBanca(){
        return this.Banca.size();
    }

    @Override
    public ArrayList<ICardPlayable> getMano(){
        return this.Mano;
    }

    /** Get the info about the cards that are not played yet
     *
     * @return A string of info
     */
    public String showMano(){
        String result = "";
        for(int i=0; i<this.getMano().size(); i++){
            result += Integer.toString(i+1)+". "+this.getMano().get(i).getDescrp()+".\n";
        }
        return result;
    }

    @Override
    public void pokemonAttack(Entrenador enemyTrainer){ // seria por default el pokemon del enemigo?
        if(this.Activa.getSelectedSkill()!=null && enemyTrainer.getActiva()!=null){
            this.Activa.attack(this.enemyActive(enemyTrainer));
            enemyTrainer.getAttacked();
        }
    }
    @Override
    public void getAttacked(){
        this.deadActive();
    }
    @Override
    public String showEnemyField(Entrenador enemyTrainer){
        String s="";
        s+="Activo: "+enemyTrainer.cardInfo(this.enemyActive(enemyTrainer))+"Banca: \n";
        for(int i=1; i<=enemyTrainer.getBanca().size(); i++){
            s+=enemyTrainer.cardInfoBanca(i);
        }
        return s;

    }
    @Override
    public ArrayList<Pokemon> enemyBanca(Entrenador enemyTrainer){
        return enemyTrainer.getBanca();
    }
    @Override
    public Pokemon enemyActive(Entrenador enemyTrainer){
        return enemyTrainer.getActiva();
    }

    /** Print into the console the enemy field
     *
     * @param enemyTrainer The trainer
     */
    public void showEnemyFieldInfo(Entrenador enemyTrainer){
        System.out.println(this.showEnemyField(enemyTrainer));
    }
    /** Shows how many cards the trainer has that are not being played yet
     *
     * @return The amount of cards
     */
    public int cantidadMano(){
        return this.getMano().size();
    }
    @Override
    public String showEntireField(Entrenador enemyTrainer){
        String result = "Tu campo: "+"\n";
        result+=enemyTrainer.showEnemyField(this);
        result+="Campo enemigo: "+"\n";
        result+=this.showEnemyField(enemyTrainer);
        return result;
    }

    /** Print in the console the entire field info
     *
     * @param enemyTrainer Enemy
     */
    public void showEntireFieldInfo(Entrenador enemyTrainer){
        System.out.println(this.showEntireField(enemyTrainer));
    }
}
