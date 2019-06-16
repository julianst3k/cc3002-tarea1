package cc3002.tarea1.Card;

import cc3002.tarea1.Controller;

public class Potion extends InstantObjectCard {
    private int heal;
    public Potion(int healing){
        super("Potion", "Heals for "+healing);
        heal = healing;
    }
    public void applyEffect(Controller controller){
        if(controller.getInTurnTrainer().getObjective()!=null) {
            if (controller.getInTurnTrainer().getObjective().getHp() + this.heal < controller.getInTurnTrainer().getObjective().getMaxHp())
                controller.getInTurnTrainer().getObjective().setHealthPoints(controller.getInTurnTrainer().getObjective().getHp() + this.heal);
            else {
                controller.getInTurnTrainer().getObjective().setHealthPoints(controller.getInTurnTrainer().getObjective().getMaxHp());
            }
        }
    }

}
