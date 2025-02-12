package cc3002.tarea1.Energies;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class PsychEnergy extends Energy {
    /** A class for the psych-type energies
     * @author: Julian Solis Torrejon
     *
     */
    /** creates the psych energy
     *
     */
    public PsychEnergy(){
        super("Energia de Psiquico");
    }
    @Override
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setPsychEnergy();

    }
    @Override
    public void getSetted(ISkill skill){
        skill.getCost().setPsychEnergy();
    }
}