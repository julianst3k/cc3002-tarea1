package cc3002.tarea1;


import cc3002.tarea1.Card.NullStadiumCard;
import cc3002.tarea1.Card.StadiumCard;
import cc3002.tarea1.Card.TrainerCard;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.UsableCardVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.EfectoOnDemand;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import java.util.Observable;
import java.util.Observer;


public class Controller implements Observer {
    /** Defines the Controller. The controller defines the limits of some turn, and serves as an interface between the objects and the user
     * The controller also manages the user inputs. The user inputs are required for sequential plays, like playing a card to a Pokemon.
     * @author: Julian Solis Torrejon
     */
    private Entrenador inTurn;
    private Entrenador notInTurn;
    private int energyCardPlayed;
    private int wingBuzzPlayed;
    private int supportCardPlayed;
    private StadiumCard currentStadium;
    public boolean turnedStarted;
    public Moneda coin;
    public boolean status;

    /** Creates a controller
     *
     * @param first the trainer that starts a turn
     * @param second the trainer that go after him
     */
    public Controller(Entrenador first, Entrenador second){
        energyCardPlayed = 0; wingBuzzPlayed=0; supportCardPlayed = 0;
        inTurn = first; first.subscribeTrainer(this);
        notInTurn = second; second.subscribeTrainer(this);
        currentStadium = new NullStadiumCard(); inTurn.setCurrentStadium(currentStadium); notInTurn.setCurrentStadium(currentStadium);
        turnedStarted = false;
        coin = new Moneda();
        status = true;

    }

    /** Start the turn, if the turn is not
     *
     */
    public void startTurn(){
        if(!turnedStarted)
            inTurn.sacarCarta();
    }


    /** End a turn, so the trainers role's reversed and the parameters are reset :)
     *
     */
    public void endTurn(){
        Entrenador trainerHolder = inTurn;
        inTurn = notInTurn;
        energyCardPlayed = 0; wingBuzzPlayed = 0; supportCardPlayed = 0;
        notInTurn = trainerHolder; turnedStarted = false;
        this.startTurn();
    }

    /** Select an skill
     *
     * @param index index of the card
     */
    public void selectSkill(int index){
        inTurn.selectAttack(index);
    }

    /** Use an skill of certain index
     *
     * @param index index of the card
     */
    public void useSkill(int index){
        selectSkill(index);
        if(inTurn.getActiva().getSelectedSkill() != null && inTurn.getActiva().getSelectedSkill().isUsable(this)) {
            inTurn.pokemonAttack(notInTurn);
        }
        else{
            System.out.println("Not usable");
        }
    }

    /** Update the status of the skills, since they are not accessible at all times
     *
     * @param o The observable, normally the pokemon
     * @param arg The argument, which is the attack.
     */
    public void update(Observable o, Object arg){
        if(arg instanceof ISkill){
            EffectVisitor visitor = new EfectoOnDemand(this);
            ((ISkill) arg).accept(visitor);
        }
        if(arg instanceof Attack){
            endTurn();
        }
    }

    /** Set the stadium card, implements the new passive effect and eliminates the one before
     *
     * @param arg stadium card
     */
    public void setStadium(StadiumCard arg){
        currentStadium.dettachEffectPassive(this);
        currentStadium = arg; inTurn.setCurrentStadium(currentStadium); notInTurn.setCurrentStadium(currentStadium);
        currentStadium.applyEffectPassive(this);
    }
    /** Get the wingbuzz status
     *
     */
    public int getWingBuzzPlayed(){
        return wingBuzzPlayed;
    }

    /** Play a card of certain index if it is usable
     *
     * @param index index
     */
    public void playCard(int index){ if(isUsable(inTurn.getMano().get(index-1))){inTurn.jugarCarta(index);}}

    /** See if the card is usable based on the current status
     *
     * @param card Card that is being judged
     * @return True if playable
     */
    public boolean isUsable(ICardPlayable card){
        ControlVisitor control = new UsableCardVisitor(this);
        card.accept(control);
        return control.usable();
    }

    /** A energy card was played
     *
     */
    public void setEnergyCardPlayed(){ energyCardPlayed = 1;}

    /** A support card was played
     *
     */
    public void setSupportCardPlayed(){ supportCardPlayed = 1;}

    /** A getter to see if the energy card was played
     *
     * @return 1 if played
     */
    public int getEnergyCardPlayed(){ return energyCardPlayed;}

    /** A getter to see if a support card was played
     *
     * @return 1 if played
     */
    public int getSupportCardPlayed(){ return supportCardPlayed;}

    /** A setter to notify that a Wing Buzz was played
     *
     */
    public void setWingBuzzPlayed(){ wingBuzzPlayed = 1;}

    /** get the not in turn trainer, which is the one affected as enemy
     *
     * @return not in turn trainer
     */
    public Entrenador getNotInTurnTrainer(){ return notInTurn; }

    /** get the in turn trainer, which is the one who acts
     *
     * @return in turn trainer
     */
    public Entrenador getInTurnTrainer(){ return inTurn; }

    /** Select a card, which is sometimes needed for some actions
     *
     * @param index index of the card selected
     */
    public void selectCard(int index){ inTurn.setSelectedCard(index);}

    /** Select an objective pokemon, which is sometimes needed for some actions
     *
     * @param index index of the card, if it is the active is 0,
     */
    public void selectObjective(int index){ inTurn.setObjective(index);}

    /** The card that does an effect call this method when played so the controller gives its information
     * to them
     *
     * @param card The card played
     */
    public void manageEffect(TrainerCard card){  EffectVisitor visitor = new EfectoOnDemand(this);
        card.acceptEffect(visitor);}

    /** Set the game status, if it is false, then the game can't be played (?
     *
     * @param val 0 if not playable
     */
    public void gameStatus(int val){
        if(val == 0){
            status = false;
        }
    }

    /** Gets the status of the game, for simplicity this is not asked when playing (Since every action
     * needs the status to be true)
     *
     * @return the status
     */
    public boolean getStatus(){
        return status;
    }

    /** show the current playable cards of the in turn trainer
     *
     * @return in turn
     */
    public String showMano(){ return inTurn.showMano();}
    /** show the current field
     *
     * @return not in turn
     */
    public String showField(){ return inTurn.showEntireField(notInTurn);}
    /** plays from the sidelines
     *
     * @param index index of the pokemon in the sidelines;
     */
    public void playFromBanca(int index){
        inTurn.activePokemonSwapWithIndex(index);
    }
}
