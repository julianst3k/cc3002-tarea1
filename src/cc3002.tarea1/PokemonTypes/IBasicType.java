package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public interface IBasicType extends IPokemon {
    void accept(PlayVisitor visitor);
}
