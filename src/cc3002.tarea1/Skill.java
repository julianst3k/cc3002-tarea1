package cc3002.tarea1;
import java.util.ArrayList;
import java.util.HashMap;

public class Skill implements ISkill {
    /**Clase para skills genericas. Basicamente se invoca para ser llamadas por los pokemon, los cuales le dan el
    * tipo
    * @author Julian Solis Torrejon
    */

    private String name;
    private int damage;
    private String description;
    private HashMap<String, Integer> costo;
    public Skill(String name, int damage, ArrayList<IEnergia> costo, String description){
        this.name = name;
        this.damage = damage;
        this.costo = HashCreate(costo);
        this.description = description;
    }

    /**
     * Genera un HashMap con las energias para las comparaciones
     * @param costo Lista de energias
     * @return HashMap
     */
    private HashMap<String, Integer> HashCreate(ArrayList<IEnergia> costo){
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
    @Override
    public int getDamage(){
        return this.damage;
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public String getDescripcion(){ return this.description; }
    @Override
    public HashMap<String, Integer> getCost(){
        return this.costo;
    }

    /** The attack cost something, we want to know that :)
     *
     * @return String of the energies that the attack cost
     */
    public String getCostString(){
        String result = "";
        for (HashMap.Entry<String, Integer> entry : this.getCost().entrySet()) {
            result += entry.getKey()+": "+entry.getValue()+". ";
        }
        return result;
    }
}
