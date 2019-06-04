package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class PsychEnergy extends Energy {
    /** A class for the psych-type energies
     * @author: Julian Solis Torrejon
     *
     */
    public PsychEnergy(){
        super("Energia de Psiquico");
    }
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setPsychEnergy();

    }
    public void getSetted(ISkill skill){
        skill.getCost().setPsychEnergy();
    }
}