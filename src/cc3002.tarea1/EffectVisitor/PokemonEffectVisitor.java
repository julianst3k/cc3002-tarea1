package cc3002.tarea1.EffectVisitor;

import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.IPokemon;

public class PokemonEffectVisitor extends EffectVisitor {
    public IPokemon objective;
    public PokemonEffectVisitor(IPokemon poke){
        objective = poke;
    }
    public void visitedNullPokemonEffect(PokemonEffect effect){
    }
    public void visitedWingBuzz(PokemonEffect effect){

    }
}
