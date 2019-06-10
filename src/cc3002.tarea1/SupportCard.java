package cc3002.tarea1;

import cc3002.tarea1.Effect.InstantEffect;
import cc3002.tarea1.PlayVisitor.PlaySupportCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public class SupportCard extends TrainerCard {
    private InstantEffect effect;
    public SupportCard(String nombre, String description, InstantEffect newEffect){
        super(nombre, description);
        effect = newEffect;
    }
    public InstantEffect getEffect(){
        return effect;
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedSupportCard(this);
    }
    @Override
    public void jugarCarta(Entrenador entrenador) {
        PlayVisitor visitor = new PlaySupportCard(entrenador);
        this.accept(visitor);
        visitor.play();
    }
}
