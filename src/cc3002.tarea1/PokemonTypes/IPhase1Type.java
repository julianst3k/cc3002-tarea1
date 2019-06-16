package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.IPokemon;

public interface IPhase1Type extends IPokemon {
    /** Provides the ID of the pre evolution
     *
     * @return The ID
     */
    int getPreEvolutionID();
}
