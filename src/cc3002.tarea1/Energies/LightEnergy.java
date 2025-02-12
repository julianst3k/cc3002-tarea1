package cc3002.tarea1.Energies;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class LightEnergy extends Energy {
    /** A class for the electric-type energies
     * @author: Julian Solis Torrejon
     *
     */
    /** creates the light energy
     *
     */
    public LightEnergy(){
        super("Energia de Rayo");

    }
    @Override
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setLightEnergy();
    }
    @Override
    public void getSetted(ISkill skill){
        skill.getCost().setLightEnergy();
    }
}
