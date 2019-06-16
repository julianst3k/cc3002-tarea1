package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;


import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Card.PokemonPark;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public abstract class EffectVisitor extends VisitorFather {
    public EffectVisitor(){
    }
    public void visitedEntrenador(Entrenador trainer){}
    public void visitedPokemonPark(PokemonPark card){}
    public abstract void doEffect();
}
