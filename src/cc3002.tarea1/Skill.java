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
    private EnergyCounter costo;
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
    private EnergyCounter HashCreate(ArrayList<IEnergia> costo){
        this.costo = new EnergyCounter();
        for(int i = 0; i<costo.size(); i++) {
            costo.get(i).getSetted(this);
        }
        return this.costo;
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
    public EnergyCounter getCost(){
        return this.costo;
    }

    /** The attack cost something, we want to know that :)
     *
     * @return String of the energies that the attack cost
     */
    public String getCostString(){
            String result = "";
            for (EnergyType entry : EnergyType.values()) {
                if(costo.getMap().get(entry)>0) {
                    result += String.valueOf(entry) + ": " + String.valueOf(costo.getMap().get(entry)) + ". ";
                }
            }
            return result;
    }
}
