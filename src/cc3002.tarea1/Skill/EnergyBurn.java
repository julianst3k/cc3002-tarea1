package cc3002.tarea1.Skill;


import cc3002.tarea1.Controller;
import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Skill;

import java.util.ArrayList;

public class EnergyBurn extends Skill {
    public EnergyBurn(ArrayList<IEnergia> costo){
        super("Energy Burn", costo ,"Cambia tus chakras bb");
    }
    public void applyEffect(Controller controller){
        controller.getInTurnTrainer().getActiva().getEnergyBurnt();
    }
}
