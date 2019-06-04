package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class FireEnergy extends Energy {
    /** A class for the fire-type energies
     * @author: Julian Solis Torrejon
     *
     */
    public FireEnergy(){
        super("Energia de Fuego");
    }
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setFireEnergy();
    }
    public void getSetted(ISkill skill){
        skill.getCost().setFireEnergy();
    }
}