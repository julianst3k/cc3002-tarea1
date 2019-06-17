package cc3002.tarea1.Skill;

import cc3002.tarea1.IEnergia;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Visitor.PlayVisitor.EfectoExtraDmg;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public abstract class Attack extends Skill {
    /** Creates an attack skill
     * @author Julian Solis Torrejon
     */

    private int damage;
    private int extradmg;

    /** creates an attack
     *
     * @param name the name
     * @param dmg the dmg
     * @param costo the cost
     * @param description the description
     */
    public Attack(String name, int dmg, ArrayList<IEnergia> costo, String description){
        super(name, costo, description);
        damage = dmg;
        extradmg = 0;
    }
    /** Get the damage that the skill deals
     *
     * @return An integer of the damage
     */
    public int getDamage(){
        return this.damage+this.getExtradmg();
    };
    @Override
    public void beUsed(Pokemon user, IPokemon poke){
        user.attack(poke, this);
    }
    @Override
    public String showAttributes(){
        return this.getDamage()+" de daño. Descripcion: "+this.getDescripcion()+". Requiere: "+this.getCostString();
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedAttack(this);
    }

    /** Does extra damage
     *
     * @return the extra dmg
     */
    public int getExtradmg(){
        EfectoExtraDmg visitor = new EfectoExtraDmg();
        this.accept(visitor);
        return visitor.getValue();
    }

}
