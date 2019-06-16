package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayPhase2;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Phase2LightPokemon extends AbstractLightPokemon implements IPhase2Type {
    private int preEvolutionID;

    public Phase2LightPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayPhase2(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(VisitorFather visitor){
        visitor.visitedPhase2Type(this);
    }
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
