package cc3002.tarea1.Effect;

import cc3002.tarea1.*;

public abstract class PokemonEffect extends IEffect {
    protected Pokemon pokemon;
    protected ISkill origin;

    public PokemonEffect(String name){
        super(name); pokemon = null; origin = null;
    }
    public void setPokemon(Pokemon poke){
        pokemon = poke;
    }

    /** Sets the origin of the effect, in this case the origin is a skill since it is a PokemonEffect
     *
     * @param skill The skill that originates the effect
     */
    public void setOrigin(ISkill skill){
        origin = skill;
    }
    public abstract void applyEffect(Controller controller);

    /** Some cards acts as a defensive skill or object
     *
     * @param dmg The dmg 
     */
    public void applyDefense(int dmg){}
}
