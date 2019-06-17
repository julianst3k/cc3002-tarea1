package cc3002.tarea1;

import cc3002.tarea1.ICardComposite;
import cc3002.tarea1.ICardPlayable;

import java.util.ArrayList;

public class Premio implements ICardComposite {
    /** The premio set of cards
     * @author Julian Solis Torrejon
     *
     */
    private ArrayList<ICardPlayable> premio;

    /** Initializes the special stack :)
     *
     * @param cartas
     */
    public Premio(ArrayList<ICardPlayable> cartas){
        if(cartas.size()<=6) {
            premio = cartas;
        }
    }
    /** Adds a card to the special stack, if we have 6, we can't add more since the limit is 6
     * @param: card card that is going to be added
     */
    public void addCarta(ICardPlayable card){
        if(premio.size()<6){
            this.premio.add(card);
        }
    }

    @Override
    public String getDescrp() {
        return premio.get(0).getDescrp();
    }
    @Override
    public String getName() {
        return premio.get(0).getName();
    }

    /** Returns the current stack
     *
     * @return: Array of cards
     */
    public ArrayList<ICardPlayable> getStack(){
        return this.premio;
    }
    @Override
    public int getSize(){
        return this.premio.size();
    }
}
