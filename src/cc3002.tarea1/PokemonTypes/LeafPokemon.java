package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.ISkill;

import java.util.ArrayList;

public class LeafPokemon extends Pokemon{
    public LeafPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
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
            s+=Integer.toString(i+1)+". "+showSkill(i);
        }
        return s;
    }
    public String showSkill(int A){
        String result = this.getSkills().get(A).getName()+", de tipo hierba y realiza "+this.getSkills().get(A).getDamage()+" de daño. Descripcion: "+this.getSkills().get(A).getDescripcion()+". Requiere: "+this.getSkills().get(A).getCostString()+"\n";
        return result;
    }
}
