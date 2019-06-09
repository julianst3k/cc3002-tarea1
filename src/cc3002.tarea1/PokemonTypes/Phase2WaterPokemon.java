package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.PlayVisitor.PlayBasic;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

import java.util.ArrayList;

public class Phase2WaterPokemon extends AbstractWaterPokemon implements IPhase2Type{
    public Phase2WaterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayBasic(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedPhase2Type(this);
    }

}
