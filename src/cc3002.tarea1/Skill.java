package cc3002.tarea1;
import java.util.ArrayList;
import java.util.HashMap;

public class Skill implements ISkill { // Es una skill generica ! Dado que el tipo lo da el pokemon :)
    private String name;
    private int damage;
    private HashMap<String, Integer> costo;
    public Skill(String name, int damage, ArrayList<IEnergia> costo){
        this.name = name;
        this.damage = damage;
        this.costo = HashCreate(costo);
    }
    public HashMap<String, Integer> HashCreate(ArrayList<IEnergia> costo){
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for(int i = 0; i<costo.size(); i++){
            String tipo = costo.get(i).getType();
            if(hash.get(tipo)==null){
                hash.put(tipo, 1);
            }
            else{
                int initial = hash.get(tipo);
                hash.put(tipo, initial + 1);
            }
        }
        return hash;
    }
    public int getDamage(){
        return this.damage;
    }
    public String getName(){
        return this.name;
    }
    public HashMap<String, Integer> getCost(){
        return this.costo;
    }
}
