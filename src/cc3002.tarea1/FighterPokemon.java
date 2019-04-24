package cc3002.tarea1;
import java.util.ArrayList;
public class FighterPokemon extends Pokemon{
    public FighterPokemon(String name, int id, double healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    public void attack(Pokemon A){
        A.attackedByFighter(this.getSelectedSkill());
    }

    public void attackedByPsych(ISkill A){
        this.getAttackedVulnerable(A);
    }
    public void attackedByLeaf(ISkill A){
        this.getAttackedVulnerable(A);
    }
    public String showSkills(){
        String s="";
        for(int i=0; i<this.getSkills().size(); i++){
            s+="El movimiento "+Integer.toString(i)+" es "+this.getSkills().get(i).getName()+", de tipo lucha y realiza "+this.getSkills().get(i).getDamage()+"\n";
        }
        return s;
    }
}