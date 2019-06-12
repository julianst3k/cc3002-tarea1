package cc3002.tarea1;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class Controller implements Observer {
    /** Defines the Controller. The controller defines the limits of some turn, and serves as an interface between the objects and the user
     * The controller also manages the user inputs. The user inputs are required for sequential plays, like playing a card to a Pokemon.
     * @author: Julian Solis Torrejon
     */
    private Entrenador inTurn;
    private Entrenador notInTurn;
    private int energyCardsPlayed;
    private int wingBuzzPlayed;
    private StadiumCard currentStadium;
    final private BufferedReader userInput;
    public Controller(Entrenador first, Entrenador second, BufferedReader newBuffer){
        energyCardsPlayed = 0; wingBuzzPlayed=0;
        inTurn = first; first.addObserver(this);
        notInTurn = second; second.addObserver(this);
        currentStadium = new NullStadiumCard(); inTurn.setCurrentGlobalEffect(currentStadium.getEffect()); notInTurn.setCurrentGlobalEffect(currentStadium.getEffect());
        userInput = newBuffer;
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
        energyCardsPlayed = 0; wingBuzzPlayed = 0;
        notInTurn = trainerHolder;
    }
    public void selectSkill(int index){
        inTurn.selectAttack(index);
    }
    public void useSkill(){
        if(inTurn.getActiva().getSelectedSkill() != null && inTurn.getActiva().getSelectedSkill().isUsable(this)) {
            inTurn.pokemonAttack(notInTurn);
        }
        else{
            System.out.println("Not usable");
        }
    }
    public void update(Observable o, Object arg){
        if(arg instanceof StadiumCard){
            this.setStadium((StadiumCard) arg);
        }
        if(arg instanceof WingBuzz){
            inTurn.descartarMano(0);
            notInTurn.descartarMazo();
            wingBuzzPlayed++;
        }
        if(arg instanceof Attack){
            endTurn();
        }
    }

    /** Set the stadium card
     *
     * @param arg stadium card
     */
    public void setStadium(StadiumCard arg){
        currentStadium = arg;
    }
    /** Get the wingbuzz status
     *
     */
    public int getWingBuzzPlayed(){
        return wingBuzzPlayed;
    }
    public String readTheLine() throws IOException{
        String result = userInput.readLine();
        if(result==null){
            throw new IOException("null");
        }
        return result;
    }
}
