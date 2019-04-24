package cc3002.tarea1;
import java.util.ArrayList;
public class WaterPokemon extends Pokemon{
    public WaterPokemon(int id, double healthPoints, ArrayList<ISkill> skills){
        super(id, healthPoints, skills);
    }
    public void attack(Pokemon A){
        A.attackedByWater(this.getSelectedSkill());
    }
    public void attackedByFighter(ISkill A) {
        this.getAttackedResist(A);
    }
    public void attackedByLight(ISkill A){
        this.getAttackedVulnerable(A);
    }
    public void attackedByLeaf(ISkill A){
        this.getAttackedVulnerable(A);
    }
    public String showSkills(){
        String s="";
        for(int i=0; i<this.getSkills().size(); i++){
            s+="El movimiento "+Integer.toString(i)+" es "+this.getSkills().get(i).getName()+", de tipo agua y realiza "+this.getSkills().get(i).getDamage()+"\n";
        }
        return s;
    }
}
