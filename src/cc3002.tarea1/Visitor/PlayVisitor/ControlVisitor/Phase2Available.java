package cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;

import cc3002.tarea1.Controller;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;

public class Phase2Available extends ControlVisitor {
    IPhase2Type phase;
    boolean status;
    public Phase2Available(Controller controller, IPhase2Type card){
        super(controller);
        status = false;
        phase = card;
        controller.getInTurnTrainer().getObjective().accept(this);
    }
    public void visitedPhase1Type(IPhase1Type type){
        if(phase.getPreEvolutionID()==type.getIndex()) {
            status = true;
        }
    }

    public boolean usable(){
        return status;
    }
}
