package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.PlayVisitor.PlayVisitor;
import cc3002.tarea1.PlayVisitor.PlayPhase1;

import java.util.ArrayList;

public class Phase1FighterPokemon extends AbstractFighterPokemon implements IPhase1Type {
    private int preEvolutionID;
    public Phase1FighterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayPhase1(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedPhase1Type(this);
    }
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
