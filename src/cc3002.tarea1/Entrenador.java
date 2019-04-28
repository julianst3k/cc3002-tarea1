package cc3002.tarea1;
import java.util.ArrayList;
public class Entrenador implements IEntrenador {
    /** Defines the trainer. The trainer is allowed to see his cards and do actions with it.
     * @author: Julian Solis Torrejon
     */
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<ICard> Mano;
    public Entrenador(Pokemon a){ // Defino el inicio del juego con un pokemon activo :)
        Activa = a;
        Banca = new ArrayList<Pokemon>();
        Mano = new ArrayList<ICard>();
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
            this.activePokemonSwap();
        }
    }

    @Override
    public String cardInfo(ICard A){
        return A.getDescrp();
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
    public void selectAttack(int A){ // Me imagino que el ataque es una clase
        this.Activa.selectSkill(A-1);
    }

    @Override
    public void sacarCarta(ICard A){
        this.Mano.add(A);
    }

    /** Set an energy in the pokemon
     *
     * @param A An energy
     */
    public void activeUseEnergy(Energy A){
        this.Activa.setEnergy(A);
    }

    @Override
    public Pokemon getActiva(){
        return this.Activa;
    }

    /** Gets the info of a card that is on the 5-Pokemon's list
     *
     * @param i The index + 1 of the pokemon
     * @return A string of information
     */
    public String cardInfoBanca(int i){
        String result = "";
        if(i<=this.cantidadBanca()){
             result += i+". "+cardInfo(this.getBanca().get(i-1));
        }
        return result;
    }
    public void activeInfo(){
       System.out.println(cardInfo(this.Activa));
    }
    public void manoInfo(){
        System.out.println(this.showMano());
    }
    public void bancaInfo(){
        for(int i=1; i<=this.getBanca().size(); i++) {
            System.out.println(cardInfoBanca(i));
        }
    }
    @Override
    public void jugarCarta(int A){
        if(A>0 && A<=this.Mano.size()) {
            ICard Card = this.Mano.get(A - 1);
            this.Mano.remove(A - 1);
            Card.jugarCarta(this);
        }
    }

    /** Get the info of some card in the set of cards
     *
     * @param i Index + 1 of the card
     * @return A string with the information
     */
    public String cardInfoMano(int i){
        if(this.getMano().size()>=i){
            return this.cardInfo(this.getMano().get(i-1));
        }
        else{
            return "";
        }
    }

    /** Plays a pokemon card. This is thrown by the playCard() when the argument is a Pokemon card
     *
     * @param A A pokemon card
     */
    public void jugarCartaPokemon(Pokemon A){
        if(this.cantidadBanca()<5){
            this.Banca.add(A);
            this.deadActive();
        }
        else{
            this.Mano.add(A);
        }
    }

    /** Same as above, but with the energy card
     *
     * @param A A energy card
     */
    public void jugarCartaEnergia(Energy A){
        this.activeUseEnergy(A);
    }

    // public void energyInfo()
    // { public void bancaInfo(){
    //        for(int i=1; i<=this.cantidadBanca(); i++) {
    //            System.out.println(cardInfoBanca(i));
    //        }
    //    }
     //   for(int i=1; i<=this.Energias.size(); i++){
     //       System.out.println(this.energyString(i));
     //   }
    // }

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
    public ArrayList<ICard> getMano(){
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
    public void pokemonAttack(Entrenador A){ // seria por default el pokemon del enemigo?
        if(this.Activa.getSelectedSkill()!=null && A.getActiva()!=null){
            this.Activa.attack(A.getActiva());
            A.getAttacked();
        }
    }
    @Override
    public void getAttacked(){
        this.deadActive();
    }
    @Override
    public String showEnemyField(Entrenador A){
        String s="";
        s+="Activo: "+A.cardInfo(A.getActiva())+"Banca: \n";
        for(int i=1; i<=A.getBanca().size(); i++){
            s+=A.cardInfoBanca(i);
        }
        return s;

    }
    public void showEnemyFieldInfo(Entrenador A){
        System.out.println(this.showEnemyField(A));
    }
    /** Shows how many cards the trainer has that are not being played yet
     *
     * @return The amount of cards
     */
    public int cantidadMano(){
        return this.getMano().size();
    }
}
