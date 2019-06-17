package cc3002.tarea1.Energies;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class FireEnergy extends Energy {
    /** A class for the fire-type energies
     * @author: Julian Solis Torrejon
     *
     */
    /** creates the fire energy
     *
     */
    public FireEnergy(){
        super("Energia de Fuego");
    }
    @Override
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setFireEnergy();
    }
    @Override
    public void getSetted(ISkill skill){
        skill.getCost().setFireEnergy();
    }
}