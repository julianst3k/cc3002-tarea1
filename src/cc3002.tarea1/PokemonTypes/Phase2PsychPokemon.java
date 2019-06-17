package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Phase2PsychPokemon extends AbstractPsychPokemon implements IPhase2Type {
    /** Basic phase 2 psych pokemon
     * @author Julian Solis Torrejon
     */
    private int preEvolutionID;
    /** Fase 2 pokemon psychic
     *
     * @param name nombre
     * @param id the index
     * @param healthPoints the hp
     * @param skills the skills
     */
    public Phase2PsychPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
        preEvolutionID= id;
    }
    @Override

    public void accept(VisitorFather visitor){
        visitor.visitedPhase2Type(this);
    }
    @Override
    public int getPreEvolutionID(){
        return preEvolutionID;
    }

}
