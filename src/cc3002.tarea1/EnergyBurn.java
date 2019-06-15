package cc3002.tarea1;

import cc3002.tarea1.Effect.EnergyBurnEffect;

import java.util.ArrayList;

public class EnergyBurn extends Skill{
    public EnergyBurn(ArrayList<IEnergia> costo){
        super("Energy Burn", costo ,"Cambia tus chakras bb", new EnergyBurnEffect());
    }
}
