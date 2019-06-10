package cc3002.tarea1;
import cc3002.tarea1.ControlVisitor.ControlVisitor;
import cc3002.tarea1.ControlVisitor.UsableSkillVisitor;
import cc3002.tarea1.Effect.PokemonEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Skill implements ISkill {
    /**Clase para skills genericas. Basicamente se invoca para ser llamadas por los pokemon, los cuales le dan el
    * tipo
    * @author Julian Solis Torrejon
    */

    private String name;
    private String description;
    private EnergyCounter costo;
    private PokemonEffect effect;

    public Skill(String name, ArrayList<IEnergia> costo, String description, PokemonEffect eff){
        this.name = name;
        this.costo = HashCreate(costo);
        this.description = description;
        effect = eff;
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
    @Override
    public void beUsed(Pokemon user, IPokemon poke){
        this.effect.applyEffect(poke);
    }
    public PokemonEffect getEffect(){
        return effect;
    }
    public String showAttributes(){
        return "Descripcion: "+this.getDescripcion()+". Requiere: "+this.getCostString();
    }
    public void accept(ControlVisitor visitor){
        visitor.visitedSkill(this);
    }
    public boolean isUsable(Controller contr){
        ControlVisitor visitor = new UsableSkillVisitor(contr);
        this.accept(visitor);
        return visitor.usable();
    }
}
