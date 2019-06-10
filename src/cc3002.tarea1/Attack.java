package cc3002.tarea1;

import cc3002.tarea1.Effect.InstantEffect;
import cc3002.tarea1.Effect.PokemonEffect;

import java.util.ArrayList;

public class Attack extends Skill {
    private int damage;
    public Attack(String name, int dmg, ArrayList<IEnergia> costo, String description, PokemonEffect eff){
        super(name, costo, description, eff);
        damage = dmg;
    }
    /** Get the damage that the skill deals
     *
     * @return An integer of the damage
     */
    public int getDamage(){
        return this.damage;
    };
    @Override
    public void beUsed(Pokemon user, IPokemon poke){
        user.attack(poke, this);
        this.getEffect().applyEffect(poke);
    }
    @Override
    public String showAttributes(){
        return this.getDamage()+" de daño. Descripcion: "+this.getDescripcion()+". Requiere: "+this.getCostString();
    }
}
