package cc3002.tarea1.Card;


import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayInstantObjectCard;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class InstantObjectCard extends ObjectCard {
    public InstantObjectCard(String name, String descrp){
        super(name,descrp);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedInstantObjectCard(this);
    }
    public void jugarCarta(Entrenador trainer){
        PlayVisitor visitor = new PlayInstantObjectCard(trainer);
        this.accept(visitor);
        visitor.play();
    }
}
