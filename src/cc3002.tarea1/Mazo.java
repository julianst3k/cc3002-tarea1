package cc3002.tarea1;

import cc3002.tarea1.ICardComposite;
import cc3002.tarea1.ICardPlayable;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo implements ICardComposite {
    /**
     * Creates a deck, which has some sort of rules
     *
     * @author Julian Solis Torrejon
     */
    private ArrayList<ICardPlayable> mazo;

    /**
     * Creates a deck
     *
     * @param cartas the cards
     */
    public Mazo(ArrayList<ICardPlayable> cartas) {
        if (cartas.size() < 60) {
            mazo = cartas;
        }
    }

    /**
     * Checks if it is full
     *
     * @return true if it is full
     */
    public boolean isFull() {
        return this.mazo.size() >= 60;
    }

    @Override
    public void addCarta(ICardPlayable card) {
        if (!this.isFull()) {
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

    public ArrayList<ICardPlayable> getMazo() {
        return this.mazo;
    }

    @Override
    public int getSize() {
        return this.mazo.size();
    }

    /**
     * Pops a card from the deck, so it could be possibly played by the trainer
     *
     * @return The card
     */
    public ICardPlayable sacarCarta() {
        ICardPlayable card = mazo.get(0);
        mazo.remove(0);
        return card;
    }

    /**
     * Returns the name of a card of certain index, this cant be accessed by the trainer
     *
     * @param index index
     * @return cards
     */
    public String cardOfCertainIndex(int index) {
        return mazo.get(index).getName();
    }

    /**
     * shuffleMazo does a shuffle of the deck if needed, it is not currently used though
     */
    public void shuffleMazo() {
        Collections.shuffle(mazo);
    }
    /**
     * Pops n card from the deck, so it could be possibly played by the trainer
     * @param amount number of cards popped
     * @return The card
     */
    public void popNCards(int amount) {
        for(int i=0; i<amount; i++){
            if(getSize()>1)
                mazo.remove(0);
        }
    }
}
