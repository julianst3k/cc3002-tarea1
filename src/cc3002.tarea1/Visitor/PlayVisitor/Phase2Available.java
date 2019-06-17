package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Controller;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;

public class Phase2Available extends ControlVisitor {
    /** Checks if phase 2 is available
     * @author Julian Solis Torrejon
     */
    IPhase2Type phase;
    boolean status;

    /** Creates a phase 2 available
     *
     * @param controller the controller
     * @param card the card that it is going to get checked
     */
    public Phase2Available(Controller controller, IPhase2Type card){
        super(controller);
        status = false;
        phase = card;
        controller.getInTurnTrainer().getObjective().accept(this);
    }
    @Override
    public void visitedPhase1Type(IPhase1Type type){
        if(phase.getPreEvolutionID()==type.getIndex()) {
            status = true;
        }
    }
    @Override
    public boolean usable(){
        return status;
    }
}
