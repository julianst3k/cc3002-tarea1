package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.*;

import java.util.ArrayList;

public abstract class AbstractFirePokemon extends Pokemon{
    /** A class for the Fire-type Pokemon
     * @author: Julian Solis Torrejon
     *
     */
    public AbstractFirePokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override
    public void attack(IPokemon enemyPok, Attack attack){
        if(getEnergies().greaterThan(attack.getCost())) {
            enemyPok.attackedByFire(attack);
        }
    }
    @Override
    public void attackedByWater(Attack skill) {
        this.getAttackedVulnerable(skill);
    }
    @Override
    public String showSkills(){
        String s="";
        for(int i=0; i<this.getSkills().size(); i++){
            s+=Integer.toString(i+1)+". "+showSkill(i);
        }
        return s;
    }
    @Override
    public String showSkill(int skillIndex){
        String result = this.getSkills().get(skillIndex).getName()+", de tipo fuego y realiza "+this.getSkills().get(skillIndex).showAttributes()+"\n";
        return result;
    }
    @Override
    public void getEnergyBurnt(){
        int total = totalEnergyCounter();
        EnergyCounter newCounter = new EnergyCounter();
        newCounter.setFireEnergy(total);
        this.setInitialEnergies(newCounter);
    }
}
