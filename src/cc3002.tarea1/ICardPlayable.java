package cc3002.tarea1;

import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public interface ICardPlayable extends ICard{

    /** Card accept a random visitor
     * @param visitor The visitor
     */
    void accept(VisitorFather visitor);
}
