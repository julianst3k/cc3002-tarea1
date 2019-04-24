package cc3002.tarea1;
import java.util.ArrayList;
public class FirePokemon extends Pokemon{
    public FirePokemon(String name, int id, double healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    public void attack(Pokemon A){
        A.attackedByFire(this.getSelectedSkill());
    }
    public void attackedByWater(ISkill A) {
        this.getAttackedVulnerable(A);
    }
    public String showSkills(){
        String s="";
        for(int i=0; i<this.getSkills().size(); i++){
            s+="El movimiento "+Integer.toString(i)+" es "+this.getSkills().get(i).getName()+", de tipo fuego y realiza "+this.getSkills().get(i).getDamage()+"\n";
        }
        return s;
    }
}
