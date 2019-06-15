package cc3002.tarea1.Effect;

import cc3002.tarea1.Controller;
import cc3002.tarea1.EffectVisitor.EffectVisitor;
import cc3002.tarea1.EffectVisitor.PokemonEffectVisitor;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IPokemon;

import java.io.IOException;

public class WingBuzzEffect extends PokemonEffect {
    public WingBuzzEffect(){
        super("Wing Buzz");
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
