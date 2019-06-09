package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.ISkill;
import java.util.ArrayList;
public abstract class AbstractPsychPokemon extends Pokemon{
    /** A class for the Pysch-type Pokemon
     * @author: Julian Solis Torrejon
     *
     */
    public AbstractPsychPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override

    public void attack(Pokemon enemyPok) {
        if(this.getSelectedSkill()==null){
            return;
        }
        enemyPok.attackedByPsych(this.getSelectedSkill());
    }
    @Override

    public void attackedByFighter(ISkill skill) {
        this.getAttackedResist(skill);
    }
    @Override

    public void attackedByPsych(ISkill skill){
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
        String result = this.getSkills().get(skillIndex).getName()+", de tipo psiquico y realiza "+this.getSkills().get(skillIndex).getDamage()+" de daño. Descripcion: "+this.getSkills().get(skillIndex).getDescripcion()+". Requiere: "+this.getSkills().get(skillIndex).getCostString()+"\n";;
        return result;
    }
}