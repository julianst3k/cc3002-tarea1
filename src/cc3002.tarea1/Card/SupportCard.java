package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class SupportCard extends TrainerCard {
    public SupportCard(String nombre, String description){
        super(nombre, description);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedSupportCard(this);
    }

}
