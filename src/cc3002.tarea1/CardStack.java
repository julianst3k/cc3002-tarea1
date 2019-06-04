package cc3002.tarea1;

import java.util.ArrayList;

public class CardStack implements ICardComposite {
    private ArrayList<ICardPlayable> pila;

    /** Initializes the stack, the stack is normally initialized as a null
     *
     * @param cartas
     */
    public CardStack(){
        pila = new ArrayList<ICardPlayable>();
    }
    /** Adds a card to the stack
     * @param: card card that is going to be added
     */
    public void addCarta(ICardPlayable card){
        this.pila.add(card);
    }

    @Override
    public String getDescrp() {
        return pila.get(0).getDescrp();
    }
    @Override
    public String getName() {
        return pila.get(0).getName();
    }

    /** Returns the current stack
     *
     * @return: Array of cards
     */
    public ArrayList<ICardPlayable> getStack(){
        return this.pila;
    }
    @Override
    public int getSize(){
        return this.pila.size();
    }
}
