package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PlayVisitor.*;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.ISkill;
import java.util.ArrayList;

public class BasicFighterPokemon extends AbstractFighterPokemon implements IBasicType {
    public BasicFighterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayBasic(myTrainer);
        this.accept(visitor);
        visitor.play();
    }
    @Override
    public void accept(PlayVisitor visitor){
      visitor.visitedBasicType(this);
    }

}
