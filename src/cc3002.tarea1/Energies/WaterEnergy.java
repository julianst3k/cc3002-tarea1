package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class WaterEnergy extends Energy {
    /** A class for the Water-type energies
     * @author: Julian Solis Torrejon
     *
     */
    public WaterEnergy(){
        super("Energia de Agua");
    }
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setWaterEnergy();
    }
    public void getSetted(ISkill skill){
        skill.getCost().setWaterEnergy();
    }
}