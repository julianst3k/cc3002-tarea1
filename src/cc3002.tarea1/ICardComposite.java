package cc3002.tarea1;

public interface ICardComposite extends ICard  {

    /** Plays a card to get inserted into the trainer's set of cards
     *
     * @param card The trainer
     */
    void addCarta(ICardPlayable card);

    /** Return the getSize
     *
     * @return get size
     */
    int getSize();
}
