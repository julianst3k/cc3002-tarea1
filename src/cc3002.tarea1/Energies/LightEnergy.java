package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class LightEnergy extends Energy {
    /** A class for the electric-type energies
     * @author: Julian Solis Torrejon
     *
     */
    public LightEnergy(){
        super("Energia de Rayo");

    }
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setLightEnergy();
    }
    public void getSetted(ISkill skill){
        skill.getCost().setLightEnergy();
    }
}
