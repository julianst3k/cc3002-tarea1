package cc3002.tarea1.Visitor.PlayVisitor;


import cc3002.tarea1.Controller;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;

public class Phase1Available extends ControlVisitor{
    /** Checks if phase 1 is available
     * @author Julian Solis Torrejon
     */
    IPhase1Type phase;
    boolean status;

    /** Creates the phase 1 available
     *
     * @param controller the controller
     * @param card the card that it is going to get checked
     */
    public Phase1Available(Controller controller, IPhase1Type card){
        super(controller);
        status = false;
        phase = card;
        controller.getInTurnTrainer().getObjective().accept(this);

    }
    @Override
    public void visitedBasicType(IBasicType type){
        if(phase.getPreEvolutionID()==type.getIndex()) {
            status = true;
        }
    }
    @Override
    public boolean usable(){
        return status;
    }
}
