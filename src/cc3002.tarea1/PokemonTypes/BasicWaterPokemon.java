package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayBasic;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class BasicWaterPokemon extends AbstractWaterPokemon implements IBasicType{
    public BasicWaterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayBasic(myTrainer);
        this.accept(visitor);
        visitor.play();
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedBasicType(this);
    }

}
