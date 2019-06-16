package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayPhase1;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Phase1FighterPokemon extends AbstractFighterPokemon implements IPhase1Type {
    private int preEvolutionID;
    public Phase1FighterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills, int preid){
        super(name, id, healthPoints, skills);
        preEvolutionID= preid;
    }
    public void jugarCarta(Entrenador myTrainer){
        PlayVisitor visitor = new PlayPhase1(myTrainer);
        this.accept(visitor); myTrainer.accept(visitor);
        visitor.play();
    }
    public void accept(VisitorFather visitor){
        visitor.visitedPhase1Type(this);
    }
    public int getPreEvolutionID(){
        return preEvolutionID;
    }
}
