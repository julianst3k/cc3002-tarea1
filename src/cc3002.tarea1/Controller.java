package cc3002.tarea1;


import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    /** Defines the Controller. The controller defines the limits of some turn, and serves as an interface between the objects and the user
     * @author: Julian Solis Torrejon
     */
    private Entrenador inTurn;
    private Entrenador notInTurn;
    private int EnergyCardsPlayed;
    private StadiumCard currentStadium;
    public Controller(Entrenador first, Entrenador second){
        EnergyCardsPlayed = 0;
        inTurn = first; first.addObserver(this);
        notInTurn = second; second.addObserver(this);
        currentStadium = new NullStadiumCard(); inTurn.setCurrentGlobalEffect(currentStadium.getEffect()); notInTurn.setCurrentGlobalEffect(currentStadium.getEffect());
    }

    /** Ask a certain card that if it is playable
     *
     * @param card The card that gets asked
     * @return a boolean
     */
    public boolean canBePlayed(ICardPlayable card){
        return true;
    }

    /** End a turn, so the trainers role's reversed and the parameters are reset :)
     *
     */
    public void endTurn(){
        Entrenador trainerHolder = inTurn;
        notInTurn = inTurn;
        EnergyCardsPlayed = 0;
        notInTurn = trainerHolder;
    }
    public void update(Observable o, Object arg){
        if(arg instanceof StadiumCard){
            this.setStadium((StadiumCard) arg);
        }
    }

    /** Set the stadium card
     *
     * @param arg stadium card
     */
    public void setStadium(StadiumCard arg){
        currentStadium = arg;
    }
}
