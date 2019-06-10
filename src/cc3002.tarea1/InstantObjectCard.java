package cc3002.tarea1;

import cc3002.tarea1.Effect.IEffect;
import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.PlayVisitor.PlayInstantObjectCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public class InstantObjectCard extends ObjectCard {
    public InstantObjectCard(String name, String descrp, PokemonEffect effect){
        super(name,descrp,effect);
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedInstantObjectCard(this);
    }
    public void jugarCarta(Entrenador trainer){
        PlayVisitor visitor = new PlayInstantObjectCard(trainer);
        this.accept(visitor);
        visitor.play();
    }
}
