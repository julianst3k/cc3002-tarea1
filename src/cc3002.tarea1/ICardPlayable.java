package cc3002.tarea1;

import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public interface ICardPlayable extends ICard{
    /** Plays a card to get inserted into the trainer's set of cards
     *
     * @param trainer The trainer
     */
    void jugarCarta(Entrenador trainer);
    /** Card accept a random visitor
     * @param visitor The visitor
     */
    void accept(VisitorFather visitor);
}
