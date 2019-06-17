package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Card.Potion;
import cc3002.tarea1.Card.ProfessorJuniper;
import cc3002.tarea1.Card.RareCandy;
import cc3002.tarea1.Controller;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.Skill.EnergyBurn;
import cc3002.tarea1.Skill.HydroPump;
import cc3002.tarea1.Skill.WingBuzz;

public class EfectoOnDemand extends EffectVisitor {
    /** Visitor para efecto on demand
     *
     */
    Controller control;
    public EfectoOnDemand(Controller controller){
        super(controller);
    }
    @Override
    public void visitedWingBuzz(WingBuzz wingBuzz){
        ICardPlayable toPop = controller.getInTurnTrainer().getSelectedCard();
        if(toPop==null){
            return;
        }
        else{
            controller.getInTurnTrainer().descartarMano(controller.getInTurnTrainer().getMano().indexOf(toPop)+1);
            controller.getNotInTurnTrainer().descartarMazo();
            controller.setWingBuzzPlayed();
        }
    }
    @Override
    public void visitedPotion(Potion pot){
        if(controller.getInTurnTrainer().getObjective()!=null) {
            if (controller.getInTurnTrainer().getObjective().getHp() + pot.getHeal()*10 < controller.getInTurnTrainer().getObjective().getMaxHp())
                controller.getInTurnTrainer().getObjective().setHealthPoints(controller.getInTurnTrainer().getObjective().getHp() + pot.getHeal()*10);
            else {
                controller.getInTurnTrainer().getObjective().setHealthPoints(controller.getInTurnTrainer().getObjective().getMaxHp());
            }
        }
    }
    @Override
    public void visitedProfessorJuniper(ProfessorJuniper juniper){
        while (controller.getInTurnTrainer().getMano().size() > 0){
            controller.getInTurnTrainer().descartarMano(1);
        }
        for(int i=0; i<7; i++) {
            controller.getInTurnTrainer().sacarCarta();
        }
    }
    @Override
    public void visitedRareCandy(RareCandy candy){
        EffectVisitor visitor = new RareCandyEffect(controller);
    }
    @Override
    public void visitedEnergyBurn(EnergyBurn burn){
        controller.getInTurnTrainer().getActiva().getEnergyBurnt();
    }

}
