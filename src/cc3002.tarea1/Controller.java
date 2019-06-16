package cc3002.tarea1;


import cc3002.tarea1.Card.NullStadiumCard;
import cc3002.tarea1.Card.StadiumCard;
import cc3002.tarea1.Card.TrainerCard;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor.ControlVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor.UsableCardVisitor;

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
    public Controller(Entrenador first, Entrenador second){
        energyCardPlayed = 0; wingBuzzPlayed=0; supportCardPlayed = 0;
        inTurn = first; first.subscribeTrainer(this);
        notInTurn = second; second.subscribeTrainer(this);
        currentStadium = new NullStadiumCard(); inTurn.setCurrentStadium(currentStadium); notInTurn.setCurrentStadium(currentStadium);
        turnedStarted = false;
        coin = new Moneda();

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
    public void selectSkill(int index){
        inTurn.selectAttack(index);
    }
    public void useSkill(int index){
        selectSkill(index);
        if(inTurn.getActiva().getSelectedSkill() != null && inTurn.getActiva().getSelectedSkill().isUsable(this)) {
            inTurn.pokemonAttack(notInTurn);
        }
        else{
            System.out.println("Not usable");
        }
    }
    public void update(Observable o, Object arg){
        if(arg instanceof ISkill){
            ((ISkill) arg).applyEffect(this);
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
    public void playCard(int index){ if(isUsable(inTurn.getMano().get(index-1))){inTurn.jugarCarta(index);}}
    public boolean isUsable(ICardPlayable card){
        ControlVisitor control = new UsableCardVisitor(this);
        card.accept(control);
        return control.usable();
    }
    public void setEnergyCardPlayed(){ energyCardPlayed = 1;}
    public void setSupportCardPlayed(){ supportCardPlayed = 1;}
    public int getEnergyCardPlayed(){ return energyCardPlayed;}
    public int getSupportCardPlayed(){ return supportCardPlayed;}
    public void setWingBuzzPlayed(){ wingBuzzPlayed = 1;}
    public Entrenador getNotInTurnTrainer(){ return notInTurn; }
    public Entrenador getInTurnTrainer(){ return inTurn; }
    public void selectCard(int index){ inTurn.setSelectedCard(index);}
    public void selectObjective(int index){ inTurn.setObjective(index);}
    public void manageEffect(TrainerCard card){ card.applyEffect(this);}
}
