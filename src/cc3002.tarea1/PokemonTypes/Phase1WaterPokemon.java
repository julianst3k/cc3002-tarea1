package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Phase1WaterPokemon extends AbstractWaterPokemon implements IPhase1Type{
    /** Basic phase 1 water pokemon
     * @author Julian Solis Torrejon
     */
    private int preEvolutionID;

    public Phase1WaterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedPhase1Type(this);
    }
    @Override
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
