package cc3002.tarea1.Effect;

import cc3002.tarea1.EffectVisitor.EffectVisitor;
import cc3002.tarea1.EffectVisitor.PokemonEffectVisitor;
import cc3002.tarea1.IPokemon;

public class NullGlobalEffect extends GlobalEffect{
    public NullGlobalEffect(){
        super("No Effect");
    }
    public void accept(EffectVisitor visitor){
        visitor.visitedNullGlobalEffect(this);
    }
    public void applyEffect(IPokemon poke){
        EffectVisitor visitor = new PokemonEffectVisitor(poke);
        this.accept(visitor);
    }
}
