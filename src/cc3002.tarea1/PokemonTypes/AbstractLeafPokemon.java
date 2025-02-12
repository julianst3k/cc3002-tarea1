package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.*;
import cc3002.tarea1.Skill.Attack;

import java.util.ArrayList;


public abstract class AbstractLeafPokemon extends Pokemon{
    /** A class for the Grass-type Pokemon
     * @author: Julian Solis Torrejon
     *
     */
    /** abstract pokemon grass
     *
     * @param name nombre
     * @param id the index
     * @param healthPoints the hp
     * @param skills the skills
     */
    public AbstractLeafPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override
    public void attack(IPokemon enemyPok, Attack attack) {

        if(getEnergies().greaterThan(attack.getCost())){
            enemyPok.attackedByLeaf(attack);
        }
    }
    @Override
    public void attackedByWater(Attack skill) {
        this.getAttackedResist(skill);
    }
    @Override
    public void attackedByFire(Attack skill){
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
        String result = this.getSkills().get(skillIndex).getName()+", de tipo hierba y realiza "+this.getSkills().get(skillIndex).showAttributes()+"\n";
        return result;
    }
    @Override
    public void getEnergyBurnt(){
        int total = totalEnergyCounter();
        EnergyCounter newCounter = new EnergyCounter();
        newCounter.setLeafEnergy(total);
        this.setInitialEnergies(newCounter);
    }
}
