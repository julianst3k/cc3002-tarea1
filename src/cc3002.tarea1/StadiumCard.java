package cc3002.tarea1;

import cc3002.tarea1.Effect.GlobalEffect;
import cc3002.tarea1.Effect.IEffect;
import cc3002.tarea1.PlayVisitor.PlayInstantObjectCard;
import cc3002.tarea1.PlayVisitor.PlayStadiumCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public class StadiumCard extends TrainerCard{

    private GlobalEffect effect;
    public StadiumCard(String nombre, String descrp, GlobalEffect newEffect){
        super(nombre, descrp);
        effect =  newEffect;
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedStadiumCard(this);
    }
    public void jugarCarta(Entrenador trainer){
        PlayVisitor visitor = new PlayStadiumCard(trainer);
        this.accept(visitor);
        visitor.play();
    }
    public GlobalEffect getEffect(){
        return effect;
    }
}
