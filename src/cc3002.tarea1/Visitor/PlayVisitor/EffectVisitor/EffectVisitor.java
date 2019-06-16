package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;


import cc3002.tarea1.Controller;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Card.PokemonPark;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public abstract class EffectVisitor extends VisitorFather {
    /** Applies an effect that needs to look for parameters
     *
     */
    Controller controller;
    public EffectVisitor(Controller control){
        controller = control;
    }

}
