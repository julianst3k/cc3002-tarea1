package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.PlayVisitor.PlayBasic;
import cc3002.tarea1.PlayVisitor.PlayPhase1;
import cc3002.tarea1.PlayVisitor.PlayPhase2;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

import java.util.ArrayList;

public class Phase2FighterPokemon extends AbstractFighterPokemon implements IPhase2Type {
    private int preEvolutionID;

    public Phase2FighterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayPhase2(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(PlayVisitor visitor){
        visitor.visitedPhase2Type(this);
    }
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
