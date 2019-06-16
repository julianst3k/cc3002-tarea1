package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Card.PokemonPark;

public class EffectPlayEnergy extends EffectVisitor {
    Entrenador trainer;
    public EffectPlayEnergy(){
    }
    @Override
    public void visitedPokemonPark(PokemonPark card){
        if(trainer.getObjective().getMaxHp()-trainer.getObjective().getHp()>10) {
            trainer.getObjective().setHealthPoints(trainer.getObjective().getHp() + 10);
        }
        else{
            trainer.getObjective().setHealthPoints(trainer.getObjective().getMaxHp());

        }
    }
    @Override
    public void visitedEntrenador(Entrenador entrenador){
        trainer = entrenador;
        entrenador.getStadiumCard().accept(this);
    }

}
