package cc3002.tarea1.Card;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayAttachObjectCard;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class AttachObjectCard extends ObjectCard {

    public AttachObjectCard(String name, String descrp){
        super(name,descrp);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedAttachObjectCard(this);
    }
    public void jugarCarta(Entrenador trainer){
        PlayVisitor visitor = new PlayAttachObjectCard(trainer);
        this.accept(visitor);
        visitor.play();
    }
}
