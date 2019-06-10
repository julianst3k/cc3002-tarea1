package cc3002.tarea1.Effect;

import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon;

public abstract class PokemonEffect extends IEffect {
    public PokemonEffect(String name){
        super(name);
    }
    public abstract void applyEffect(IPokemon poke);
}
