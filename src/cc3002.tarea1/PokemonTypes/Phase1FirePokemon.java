package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.PlayVisitor.PlayVisitor;
import cc3002.tarea1.PlayVisitor.PlayPhase1;


import java.util.ArrayList;

public class Phase1FirePokemon extends AbstractFirePokemon implements IPhase1Type {
    public Phase1FirePokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayPhase1(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedPhase1Type(this);
    }


}
