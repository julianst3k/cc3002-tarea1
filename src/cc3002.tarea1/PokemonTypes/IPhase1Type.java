package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public interface IPhase1Type extends ICardPlayable {
    public void accept(PlayVisitor visitor);
}
