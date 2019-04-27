package cc3002.tarea1.PokemonTypes;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.ISkill;
import java.util.ArrayList;
public class PsychPokemon extends Pokemon{
    /** A class for the Pysch-type Pokemon
     * @author: Julian Solis Torrejon
     *
     */
    public PsychPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
    @Override

    public void attack(Pokemon A){
        A.attackedByPsych(this.getSelectedSkill());
    }
    @Override

    public void attackedByFighter(ISkill A) {
        this.getAttackedResist(A);
    }
    @Override

    public void attackedByPsych(ISkill A){
        this.getAttackedVulnerable(A);
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

    public String showSkill(int A){
        String result = this.getSkills().get(A).getName()+", de tipo psiquico y realiza "+this.getSkills().get(A).getDamage()+" de daño. Descripcion: "+this.getSkills().get(A).getDescripcion()+". Requiere: "+this.getSkills().get(A).getCostString()+"\n";;
        return result;
    }
}