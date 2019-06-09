package cc3002.tarea1;

public class Controller {
    /** Defines the Controller. The controller defines the limits of some turn, and serves as an interface between the objects and the user
     * @author: Julian Solis Torrejon
     */
    private Entrenador inTurn;
    private Entrenador notInTurn;
    private int EnergyCardsPlayed;
    public Controller(Entrenador first, Entrenador second){
        EnergyCardsPlayed = 0;
        inTurn = first;
        notInTurn = second;
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
}
