package cc3002.tarea1;

import cc3002.tarea1.Card.NullStadiumCard;
import cc3002.tarea1.Card.StadiumCard;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;
import java.util.Observable;

public class Entrenador extends Observable implements IEntrenador {
    /**
     * Defines the trainer. The trainer is allowed to see his cards and do actions with it.
     *
     * @author: Julian Solis Torrejon
     */
    private IPokemon Activa;
    private ArrayList<IPokemon> Banca;
    private ArrayList<ICardPlayable> Mano;
    private Mazo mazo;
    private CardStack pila;
    private Premio premio;
    private IPokemon objective;
    private StadiumCard stadiumCard;
    private Controller actualController;
    private ICardPlayable selectedCard;

    /** Creates a trainer
     *
     * @param pokemonActivo The active pokemon
     * @param newMazo the deck
     * @param newPremio the award cards
     */
    public Entrenador(IPokemon pokemonActivo, Mazo newMazo, Premio newPremio) { // Defino el inicio del juego con un pokemon activo :)
        Activa = pokemonActivo;
        objective = null;
        Banca = new ArrayList<IPokemon>();
        Mano = new ArrayList<ICardPlayable>();
        pila = new CardStack();
        premio = newPremio;
        if (newMazo.getSize() == 60) {
            mazo = newMazo;
        } else {
            System.out.println("No hay suficientes cartas para iniciar");
            throw new AssertionError();
        }
        stadiumCard = new NullStadiumCard();
        actualController = new Controller(this, this); // Controlador provisorio
        selectedCard = null;
    }

    @Override
    public void activePokemonSwap() {
        if(this.Activa != null) {
            activePokemonSwapWithIndex(1);
        }
        else {
            this.Activa = this.Banca.get(0);
            this.Banca.remove(0);
        }
    }

    /** Swap a pokemon from the sideline with the active pokemon
     *
     * @param index index+1 of the pokemon
     */
    public void activePokemonSwapWithIndex(int index){
        if(this.getBanca().size()<index){
            return;
        }
        else{
            IPokemon AuxActive = this.getActiva();
            this.Activa = this.Banca.get(index-1);
            this.Banca.remove(index-1);
            this.Banca.add(index-1, AuxActive);
        }
    }

    @Override
    public void deadActive() {
        if (this.getActiva().isDed()) {
            addToPila(this.getActiva());
            this.Activa = null;
            this.activePokemonSwap();
        }
    }

    @Override
    public String cardInfo(ICardPlayable card) {
        return card.getDescrp();
    }

    /**
     * Show the info of the skills of the active pokemon
     *
     * @return A string with the skills of the active pokemon
     */
    public String activeSkillsInfo() {
        return "Los ataques del Pokemon son: " + this.Activa.showSkills();
    }

    /**
     * Show the info of the selected skill
     *
     * @return A string with the skills of the active selected pokemon
     */
    public String activeSelectedSkill() {
        if (this.getActiva().getSelectedSkill() != null) {
            return "El ataque selecto es: " + this.getActiva().showSkill(this.getActiva().getSelectedSkillIndex());
        } else {
            return "No hay ataque selecto";
        }
    }

    @Override
    public void selectAttack(int indexAttack) { // Me imagino que el ataque es una clase
        this.Activa.selectSkill(indexAttack - 1);
    }

    @Override
    public void sacarCarta() {
        if(mazo.getSize()>0){
            this.Mano.add(this.mazo.sacarCarta());
        }
    }


    @Override
    public IPokemon getActiva() {
        return this.Activa;
    }

    /**
     * Set the objective for the energy card, this will be played by the controller
     *
     * @param index the index of the card that will be set to be played, if index = 0, then the card to be played is the active one.
     *              This is mainly to play energy cards into pokemon ones. So, the program should ask the trainer which card he wants to set the energy to
     */
    public void setObjective(int index) {
        if (index == 0) {
            this.objective = this.getActiva();
        } else {
            this.objective = this.getBanca().get(index - 1);
        }
    }

    /**
     * Gets the info of a card that is on the 5-Pokemon's list
     *
     * @param index The index + 1 of the pokemon
     * @return A string of information
     */
    public String cardInfoBanca(int index) {
        String result = "";
        if (index <= this.cantidadBanca()) {
            result += index + ". " + cardInfo(this.getBanca().get(index - 1));
        }
        return result;
    }

    /**
     * Print in the console the active pokemon info
     */
    public void activeInfo() {
        System.out.println(cardInfo(this.Activa));
    }

    /**
     * Print in the console the cards that are not being played yet
     */
    public void manoInfo() {
        System.out.println(this.showMano());
    }

    /**
     * Print in the console the reserve pokemon info
     */
    public void bancaInfo() {
        for (int i = 1; i <= this.getBanca().size(); i++) {
            System.out.println(cardInfoBanca(i));
        }
    }

    @Override
    public void jugarCarta(int cardIndex) {
        if (cardIndex > 0 && cardIndex <= this.Mano.size()) {
            ICardPlayable carta = sacarCartaMano(cardIndex);
            PlayVisitor visitor = new PlayVisitor(this);
            carta.accept(visitor);
        }
    }
    @Override
    public ICardPlayable sacarCartaMano(int cardIndex){
        if (cardIndex > 0 && cardIndex <= this.Mano.size()) {
            ICardPlayable Card = this.Mano.get(cardIndex - 1);
            this.Mano.remove(cardIndex - 1);
            return Card;
        }
        return null;
    }

    /**
     * Get the info of some card in the set of cards
     *
     * @param index Index + 1 of the card
     * @return A string with the information
     */
    public String cardInfoMano(int index) {
        if (this.getMano().size() >= index) {
            return this.cardInfo(this.getMano().get(index - 1));
        } else {
            return "";
        }
    }

    /**
     * Set a pokemon to the sidelines
     *
     * @param poke A pokemon card
     */
    public void addToBanca(IPokemon poke) {
        if (this.cantidadBanca() < 5) {
            this.Banca.add(poke);
            this.deadActive();
        } else {
            this.Mano.add(poke);
        }
    }

    /**
     * Sometimes the card cant be played, but we already did so, so we add the card back to the hand
     *
     * @param card Add a card to the hand that hasnt been played
     */
    public void backToHand(ICardPlayable card) {
        this.Mano.add(card);
    }

    @Override
    public ArrayList<IPokemon> getBanca() {
        return this.Banca;
    }

    /**
     * Get the size of the played pokemon's that are not active. This exists so we can evade null access
     *
     * @return The size
     */
    public int cantidadBanca() {
        return this.Banca.size();
    }

    @Override
    public ArrayList<ICardPlayable> getMano() {
        return this.Mano;
    }

    /**
     * Get the info about the cards that are not played yet
     *
     * @return A string of info
     */
    public String showMano() {
        String result = "";
        for (int i = 0; i < this.getMano().size(); i++) {
            result += Integer.toString(i + 1) + ". " + this.getMano().get(i).getDescrp() + ".\n";
        }
        return result;
    }

    @Override
    public void pokemonAttack(Entrenador enemyTrainer) { // seria por default el pokemon del enemigo?
        if (enemyTrainer.getActiva() != null) {
            this.Activa.useSkill(this.enemyActive(enemyTrainer));
            enemyTrainer.getAttacked();
        }
    }

    @Override
    public void getAttacked() {
        this.deadActive();
    }

    @Override
    public String showEnemyField(Entrenador enemyTrainer) {
        String s = "";
        s += "Activo: " + enemyTrainer.cardInfo(this.enemyActive(enemyTrainer)) + "Banca: \n";
        for (int i = 1; i <= enemyTrainer.getBanca().size(); i++) {
            s += enemyTrainer.cardInfoBanca(i);
        }
        return s;

    }

    @Override
    public ArrayList<IPokemon> enemyBanca(Entrenador enemyTrainer) {
        return enemyTrainer.getBanca();
    }

    @Override
    public IPokemon enemyActive(Entrenador enemyTrainer) {
        return enemyTrainer.getActiva();
    }

    /**
     * Print into the console the enemy field
     *
     * @param enemyTrainer The trainer
     */
    public void showEnemyFieldInfo(Entrenador enemyTrainer) {
        System.out.println(this.showEnemyField(enemyTrainer));
    }

    /**
     * Shows how many cards the trainer has that are not being played yet
     *
     * @return The amount of cards
     */
    public int cantidadMano() {
        return this.getMano().size();
    }

    @Override
    public String showEntireField(Entrenador enemyTrainer) {
        String result = "Tu campo: " + "\n";
        result += enemyTrainer.showEnemyField(this);
        result += "Campo enemigo: " + "\n";
        result += this.showEnemyField(enemyTrainer);
        return result;
    }

    /**
     * Print in the console the entire field info
     *
     * @param enemyTrainer Enemy
     */
    public void showEntireFieldInfo(Entrenador enemyTrainer) {
        System.out.println(this.showEntireField(enemyTrainer));
    }

    @Override
    public void accept(VisitorFather visitor) {
        visitor.visitedEntrenador(this);
    }

    @Override
    public void pokemonEvolve(IPokemon after) {
        after.setInitialEnergies(this.getObjective().getEnergies());

        if (this.getObjective() == this.Activa) {
            this.Activa = after;
        } else {
            int place = pokemonPlace(this.getObjective());
            this.Banca.remove(place - 1);
            this.Banca.add( place - 1, after);
        }
        addToPila(this.getObjective());
        this.objective = null;
    }

    @Override
    public int pokemonPlace(IPokemon poke) {
        if (this.getActiva() == poke) {
            return 0;
        } else {
            return this.getBanca().indexOf(poke) + 1;
        }
    }

    /**
     * Provides a functionality to get the current deck
     *
     * @return the current deck
     */
    public Mazo getMazo() {
        return mazo;
    }

    /**
     * Return the actual objective pokemon
     *
     * @return Actual objective pokemon
     */
    public IPokemon getObjective() {
        return this.objective;
    }

    @Override
    public void setStadium(StadiumCard card) {
        this.actualController.setStadium(card);
    }

    /**
     * Set the stadium card that it is affecting the trainer
     *
     * @param card the effect :)
     */
    public void setCurrentStadium(StadiumCard card) {
        stadiumCard = card;
    }

    /** A new controller subscribe to the trainer, and the pokemon do too! That means that the old controller shouldnt affect the trainer anymore. It is implied that the new controller
     * starts a new game. So subscribing a pokemon that is not the active one would be redundant
     * @param control The new controller
     */

    public void subscribeTrainer(Controller control) {
        deleteObserver(actualController);
        this.addObserver(control);
        actualController = control;
        this.getActiva().subscribePokemon(control);
    }

    /**
     * Retorna el control suscrito al entrenador actualmente
     *
     * @return The controller
     */
    public Controller getActualController() {
        return actualController;
    }
    /** Discard a card from the deck
     *
     */
    public void descartarMazo(){
        if(mazo.getSize()>0) {
            addToPila(mazo.sacarCarta());
        }
    }
    /** Discard a card from the playable cards
     *
     */
    public void descartarMano(int cardIndex){
        addToPila(sacarCartaMano(cardIndex));
    }
    /** Select the card that will be played, if necessary
     *
     */
    public void setSelectedCard(int cardIndex){
        if(cardIndex<=Mano.size()) {
            selectedCard = this.Mano.get(cardIndex - 1);
        }
    }

    /** Return the selected card
     * @return The selected card
     */
    public ICardPlayable getSelectedCard(){return selectedCard;}

    /** Return the card stack
     *
     * @return the stack
     */
    public CardStack getPila(){return pila;}

    /** Returns
     *
     * @return
     */
    public StadiumCard getStadiumCard(){return stadiumCard;}
    /** Purge a card from the sidelines or the active
     * @param  index
     */
    public void purgePokemon(int index){
        if(index==0){
            if(getBanca().size()>0) {
                deadActive();
            }
            else{
                actualController.gameStatus(0);
            }
        }
        else{
            addToPila(this.Banca.get(index-1));
            this.Banca.remove(index-1);
        }
    }
    /** Add a card to the stack
     * @param  card the card
     */
    public void addToPila(ICardPlayable card){
        pila.addCarta(card);
    }
}
