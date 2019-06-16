package cc3002.tarea1.Card;

import cc3002.tarea1.ICardComposite;
import cc3002.tarea1.ICardPlayable;

import java.util.ArrayList;

public class Mazo implements ICardComposite {
    private ArrayList<ICardPlayable> mazo;
    public Mazo(ArrayList<ICardPlayable> cartas){
        if(cartas.size()<60){
            mazo = cartas;
        }
    }
    public boolean isFull(){
        return this.mazo.size()>=60;
    }
    @Override
    public void addCarta(ICardPlayable card){
        if(!this.isFull()){
            this.mazo.add(card);
        }
    }

    @Override
    public String getDescrp() {
        return mazo.get(0).getDescrp();
    }
    @Override
    public String getName() {
        return mazo.get(0).getName();
    }
    public ArrayList<ICardPlayable> getMazo(){
        return this.mazo;
    }
    @Override
    public int getSize(){
        return this.mazo.size();
    }

    /** Pops a card from the deck, so it could be possibly played by the trainer
     *
     * @return The card
     */
    public ICardPlayable sacarCarta(){ ICardPlayable card = mazo.get(0);
    mazo.remove(0);
    return card;}
    public String cardOfCertainIndex(int index){
        return mazo.get(index).getName();
    }
}
