package cc3002.tarea1.EffectVisitor;

import cc3002.tarea1.Effect.GlobalEffect;
import cc3002.tarea1.Effect.InstantEffect;
import cc3002.tarea1.Effect.PokemonEffect;

public class EffectVisitor {
    public EffectVisitor(){

    }
    public void visitedNullPokemonEffect(PokemonEffect effect){};
    public void visitedNullGlobalEffect(GlobalEffect effect){};
    public void visitedNullInstantEffect(InstantEffect effect){};
    public void visitedWingBuzz(PokemonEffect effect){};
}
