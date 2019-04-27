package cc3002.tarea1;

public interface ICard {
    /** An interface for the cards
     * @author Julian Solis Torrejon
     *
     */
    /**  Get the descriptors of the card (The name in the case of the energy, a set of strings that describe
     * the card in the case of pokemon
     *
     * @return A string
     */
    String getDescrp();

    /** Plays a card to get inserted into the trainer's set of cards
     *
     * @param a The trainer
     */
    void jugarCarta(Entrenador a);
}
