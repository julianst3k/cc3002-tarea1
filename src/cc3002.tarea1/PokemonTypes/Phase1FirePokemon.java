package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;


import java.util.ArrayList;

public class Phase1FirePokemon extends AbstractFirePokemon implements IPhase1Type {
    /** Basic phase 1 fire pokemon
     * @author Julian Solis Torrejon
     */
    private int preEvolutionID;

    public Phase1FirePokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
        preEvolutionID= id;
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
