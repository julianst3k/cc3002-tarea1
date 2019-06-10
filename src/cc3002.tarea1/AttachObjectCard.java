package cc3002.tarea1;

import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.PlayVisitor.PlayAttachObjectCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public class AttachObjectCard extends  ObjectCard{

    public AttachObjectCard(String name, String descrp, PokemonEffect effect){
        super(name,descrp,effect);
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedAttachObjectCard(this);
    }
    public void jugarCarta(Entrenador trainer){
        PlayVisitor visitor = new PlayAttachObjectCard(trainer);
        this.accept(visitor);
        visitor.play();
    }
}
