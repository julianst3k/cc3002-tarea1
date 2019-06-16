package cc3002.tarea1.Card;

import cc3002.tarea1.Card.SupportCard;
import cc3002.tarea1.Controller;

public class ProfessorJuniper extends SupportCard {
    public ProfessorJuniper(){
        super("Professor Juniper", "Descarta tu mano y saca 7 del mazo");
    }
    public void applyEffect(Controller controller) {
        while (controller.getInTurnTrainer().getMano().size() > 0){
            controller.getInTurnTrainer().descartarMano(1);
        }
        for(int i=0; i<7; i++) {
            controller.getInTurnTrainer().sacarCarta();
        }
    }
}
