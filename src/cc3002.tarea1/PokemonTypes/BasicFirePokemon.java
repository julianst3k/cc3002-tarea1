package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class BasicFirePokemon extends AbstractFirePokemon implements IBasicType {
    /** Basic fire pokemon
     * @author Julian Solis Torrejon
     */
    public BasicFirePokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }

    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedBasicType(this);
    }

}
