package cc3002.tarea1.Effect;

import cc3002.tarea1.EffectVisitor.EffectVisitor;

public class NullInstantEfect extends InstantEffect {
    public NullInstantEfect(){
        super("Do nothing");
    }
    public void accept(EffectVisitor visitor){
        visitor.visitedNullInstantEffect(this);
    }
}
