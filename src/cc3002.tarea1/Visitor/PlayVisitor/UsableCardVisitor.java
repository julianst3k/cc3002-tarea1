package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Card.AttachObjectCard;
import cc3002.tarea1.Card.InstantObjectCard;
import cc3002.tarea1.Card.SupportCard;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Energy;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;


public class UsableCardVisitor extends ControlVisitor {
    /** In this case, the parameter we are looking for is the usability of a card based on the
     * game status
     * @author Julian Solis Torrejon
     */
    boolean status;

    public UsableCardVisitor(Controller controller){
        super(controller);
        status = true;
    }
    public void visitedSupportCard(SupportCard supportCard){
        status = (control.getSupportCardPlayed()==0);
    }
    @Override
    public void visitedEnergyType(Energy supportCard){
        status =  (control.getEnergyCardPlayed()==0 && control.getInTurnTrainer().getObjective()!=null);
    }
    @Override
    public void visitedPhase1Type(IPhase1Type card){
        ControlVisitor visitor = new Phase1Available(control, card);
        status = visitor.usable();
    }
    @Override
    public void visitedPhase2Type(IPhase2Type card){
        ControlVisitor visitor = new Phase2Available(control, card);
        status = visitor.usable();
    }
    @Override
    public void visitedInstantObjectCard(InstantObjectCard card){
        status = (control.getInTurnTrainer().getObjective()!=null);
    }
    @Override
    public void visitedAttachObjectCard(AttachObjectCard card){
        status = (control.getInTurnTrainer().getObjective()!=null);
    }
    @Override
    public boolean usable(){
        return status;
    }
}

