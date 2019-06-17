package cc3002.tarea1.Visitor.PlayVisitor;


import cc3002.tarea1.Controller;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;

public class Phase1Available extends ControlVisitor{
    IPhase1Type phase;
    boolean status;
    public Phase1Available(Controller controller, IPhase1Type card){
        super(controller);
        status = false;
        phase = card;
        controller.getInTurnTrainer().getObjective().accept(this);

    }
    public void visitedBasicType(IBasicType type){
        if(phase.getPreEvolutionID()==type.getIndex()) {
            status = true;
        }
    }

    public boolean usable(){
        return status;
    }
}
