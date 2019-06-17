package cc3002.tarea1.Skill;
import cc3002.tarea1.*;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.UsableSkillVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class Skill implements ISkill {
    /**Clase para skills genericas. Basicamente se invoca para ser llamadas por los pokemon, los cuales le dan el
    * tipo
    * @author Julian Solis Torrejon
    */

    private String name;
    private String description;
    private EnergyCounter costo;
    private Pokemon pokemon;

    /** creates the skill
     *
     * @param name the name
     * @param costo the cost
     * @param description the description
     */
    public Skill(String name, ArrayList<IEnergia> costo, String description){
        this.name = name;
        this.HashCreate(costo);
        this.description = description;
    }

    /**
     * Genera un HashMap con las energias para las comparaciones
     * @param costo Lista de energias
     * @return HashMap
     */
    private void HashCreate(ArrayList<IEnergia> costo){
        this.costo = new EnergyCounter();
        for(int i = 0; i<costo.size(); i++) {
            costo.get(i).getSetted(this);
        }
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
        return costo.printEnergyCounter();

    }
    @Override
    public void beUsed(Pokemon user, IPokemon poke){
    }
    public String showAttributes(){
        return "Descripcion: "+this.getDescripcion()+". Requiere: "+this.getCostString();
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedSkill(this);
    }
    @Override
    public boolean isUsable(Controller contr){
        ControlVisitor visitor = new UsableSkillVisitor(contr);
        this.accept(visitor);
        return visitor.usable();
    }
    @Override
    public void setToPokemon(Pokemon poke){pokemon = poke;}

    /** Returns the pokemon
     *
     * @return The pokemon which this is skill is setted to
     */
    public Pokemon getPokemon(){
        return pokemon;
    }
}
