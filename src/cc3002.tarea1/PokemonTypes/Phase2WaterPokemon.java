package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Phase2WaterPokemon extends AbstractWaterPokemon implements IPhase2Type{
    private int preEvolutionID;

    public Phase2WaterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }

    public void accept(VisitorFather visitor){
        visitor.visitedPhase2Type(this);
    }
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
