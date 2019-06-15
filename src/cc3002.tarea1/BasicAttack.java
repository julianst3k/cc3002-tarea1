package cc3002.tarea1;

import cc3002.tarea1.Effect.NullPokemonEffect;
import cc3002.tarea1.Effect.PokemonEffect;

import java.util.ArrayList;

public class BasicAttack extends Attack{
    /** Creates an attack without any effect
     *
     */
    public BasicAttack(String name, int dmg, ArrayList<IEnergia> costo, String description){
        super(name, dmg, costo, description, new NullPokemonEffect());
    }
}
