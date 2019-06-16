package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class LeafEnergy extends Energy {
    /** A class for the grass-type energies
     * @author: Julian Solis Torrejon
     *
     */
    public LeafEnergy(){
        super("Energia de Planta");
    }
    @Override
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setLeafEnergy();
    }
    @Override
    public void getSetted(ISkill skill){
        skill.getCost().setLeafEnergy();
    }
}