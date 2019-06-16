package cc3002.tarea1.Skill;



import cc3002.tarea1.Controller;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Skill;

import java.util.ArrayList;

public class WingBuzz extends Skill {
    public WingBuzz(ArrayList<IEnergia> costo){
        super("Wing Buzz", costo, "Una vez por turno, si  ́este Pokemon es el activo, puedes descartar una carta de tu mano. Si lo haces, descarta la carta superior del mazo de tu oponente");
    }
    @Override
    public void applyEffect(Controller controller) {
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
}
