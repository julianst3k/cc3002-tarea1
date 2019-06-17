package cc3002.tarea1.Energies;
import cc3002.tarea1.Energy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.ISkill;

public class FighterEnergy extends Energy {
    /** A class for the fighter-type energies
     * @author: Julian Solis Torrejon
     *
     */
    /** creates the fighter energy
     *
     */
    public FighterEnergy(){
        super("Energia de Lucha");
    }
    @Override
    public void getSetted(IPokemon pokemon){
        pokemon.getEnergies().setFighterEnergy();
    }
    @Override
    public void getSetted(ISkill skill){
        skill.getCost().setFighterEnergy();
    }
}