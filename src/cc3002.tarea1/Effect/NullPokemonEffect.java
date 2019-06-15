package cc3002.tarea1.Effect;

import cc3002.tarea1.Controller;
import cc3002.tarea1.EffectVisitor.EffectVisitor;
import cc3002.tarea1.EffectVisitor.PokemonEffectVisitor;
import cc3002.tarea1.IPokemon;

public class NullPokemonEffect extends PokemonEffect {
    public NullPokemonEffect(){
        super("No Effect");
    }
    public void applyEffect(Controller controller){}
}
