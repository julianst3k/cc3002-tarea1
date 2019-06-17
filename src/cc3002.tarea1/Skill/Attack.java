package cc3002.tarea1.Skill;

import cc3002.tarea1.IEnergia;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Visitor.PlayVisitor.EfectoExtraDmg;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public abstract class Attack extends Skill {
    private int damage;
    private int extradmg;
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
    public void accept(VisitorFather visitor){
        visitor.visitedAttack(this);
    }
    public int getExtradmg(){
        EfectoExtraDmg visitor = new EfectoExtraDmg();
        this.accept(visitor);
        return visitor.getValue();
    }

}
