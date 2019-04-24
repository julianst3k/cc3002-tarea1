package cc3002.tarea1;

import java.util.ArrayList;

public class LeafPokemon extends Pokemon{
    public LeafPokemon(int id, double healthPoints, ArrayList<ISkill> skills){
        super(id, healthPoints, skills);
    }
    public void attack(Pokemon A){
        A.attackedByLeaf(this.getSelectedSkill());
    }
    public void attackedByWater(ISkill A) {
        this.getAttackedResist(A);
    }
    public void attackedByFire(ISkill A){
        this.getAttackedVulnerable(A);
    }
    public String showSkills(){
        String s="";
        for(int i=0; i<this.getSkills().size(); i++){
            s+="El movimiento "+Integer.toString(i)+" es "+this.getSkills().get(i).getName()+", de tipo hierba y realiza "+this.getSkills().get(i).getDamage()+"\n";
        }
        return s;
    }
}
