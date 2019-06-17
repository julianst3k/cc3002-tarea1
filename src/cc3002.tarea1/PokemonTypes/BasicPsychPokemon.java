package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class BasicPsychPokemon extends AbstractPsychPokemon implements IBasicType {
    /** Basic psych pokemon
     * @author Julian Solis Torrejon
     */
    /** basic pokemon psych
     *
     * @param name nombre
     * @param id the index
     * @param healthPoints the hp
     * @param skills the skills
     */
    public BasicPsychPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }

    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedBasicType(this);
    }

}
