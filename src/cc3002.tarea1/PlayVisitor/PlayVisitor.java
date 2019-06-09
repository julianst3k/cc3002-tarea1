package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PokemonTypes.*;

public abstract class PlayVisitor {
    Entrenador entrenador;
    public PlayVisitor(Entrenador trainer){
        entrenador = trainer;
    }
    public void visitedBasicType(IBasicType card){};
    public void visitedPhase1Type(IPhase1Type card){};
    public void visitedPhase2Type(IPhase2Type card){};
    public void visitedEntrenador(Entrenador entrenador){};
    public abstract void play();
}
