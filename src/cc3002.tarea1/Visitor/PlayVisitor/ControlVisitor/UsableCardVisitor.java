package cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;

import cc3002.tarea1.Card.SupportCard;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Energy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;


public class UsableCardVisitor extends ControlVisitor {
    boolean status;
    public UsableCardVisitor(Controller controller){
        super(controller);
        status = true;
    }
    public void visitedSupportCard(SupportCard supportCard){
        status = (control.getSupportCardPlayed()==0);
    }
    public void visitedEnergyType(Energy supportCard){
        status =  (control.getEnergyCardPlayed()==0);
    }
    public void visitedPhase1Type(IPhase1Type card){
        ControlVisitor visitor = new Phase1Available(control, card);
        status = visitor.usable();
    }
    public void visitedPhase2Type(IPhase2Type card){
        ControlVisitor visitor = new Phase2Available(control, card);
        status = visitor.usable();
    }
    public boolean usable(){
        return status;
    }
}

