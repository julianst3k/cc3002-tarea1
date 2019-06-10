package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.ISkill;
import java.util.ArrayList;

public abstract class AbstractLightPokemon extends Pokemon{
    /** A class for the Electric-type Pokemon
     * @author: Julian Solis Torrejon
     *
     */
    public AbstractLightPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override
    public void attack(IPokemon enemyPok, Attack attack){
        enemyPok.attackedByLight(attack);
    }
    @Override
    public void attackedByFighter(Attack skill){
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
        String result = this.getSkills().get(skillIndex).getName()+", de tipo rayo y realiza "+this.getSkills().get(skillIndex).showAttributes()+"\n";;
        return result;
    }
}