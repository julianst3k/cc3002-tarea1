package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Card.PokemonPark;

public class EffectPlayEnergy extends EffectVisitor {
    Entrenador trainer;
    public EffectPlayEnergy(){
    }
    public void visitedPokemonPark(PokemonPark card){
        trainer.getObjective().setHealthPoints(trainer.getObjective().getHp()+card.getHealthEffect());
    }
    public void visitedEntrenador(Entrenador entrenador){
        trainer = entrenador;
        entrenador.getStadiumCard().accept(this);
    }
    public void doEffect(){

    }

}
