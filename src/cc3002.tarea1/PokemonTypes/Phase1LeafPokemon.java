package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;


public class Phase1LeafPokemon extends  AbstractLeafPokemon implements IPhase1Type {
    /** Basic phase 1 leaf pokemon
     * @author Julian Solis Torrejon
     */
    private int preEvolutionID;
    /** Fase 1 pokemon grass
     *
     * @param name nombre
     * @param id the index
     * @param healthPoints the hp
     * @param skills the skills
     */
    public Phase1LeafPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
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
