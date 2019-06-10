package cc3002.tarea1.Effect;

import cc3002.tarea1.EffectVisitor.EffectVisitor;
import cc3002.tarea1.EffectVisitor.InstantEffectVisitor;
import cc3002.tarea1.EffectVisitor.PokemonEffectVisitor;
import cc3002.tarea1.IPokemon;

public abstract class InstantEffect extends IEffect {
    public InstantEffect(String name){
        super(name);
    }
    public void applyEffect(){
        EffectVisitor visitor = new InstantEffectVisitor();
        this.accept(visitor);
    }
}
