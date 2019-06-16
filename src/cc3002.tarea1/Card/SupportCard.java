package cc3002.tarea1.Card;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlaySupportCard;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class SupportCard extends TrainerCard {
    public SupportCard(String nombre, String description){
        super(nombre, description);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedSupportCard(this);
    }
    @Override
    public void jugarCarta(Entrenador entrenador) {
        PlayVisitor visitor = new PlaySupportCard(entrenador);
        this.accept(visitor);
        visitor.play();
    }
}
