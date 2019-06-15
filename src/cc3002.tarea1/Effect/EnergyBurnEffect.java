package cc3002.tarea1.Effect;

import cc3002.tarea1.Controller;
import cc3002.tarea1.EnergyBurn;

public class EnergyBurnEffect extends PokemonEffect{
    public EnergyBurnEffect(){
        super("Energy Burn Effect");
    }
    public void applyEffect(Controller controller){
        controller.getInTurnTrainer().getActiva().getEnergyBurnt();
    }
}
