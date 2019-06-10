package cc3002.tarea1.Effect;

import cc3002.tarea1.EffectVisitor.EffectVisitor;
import cc3002.tarea1.EffectVisitor.PokemonEffectVisitor;
import cc3002.tarea1.IPokemon;

public class WingBuzzEffect extends PokemonEffect {
    public WingBuzzEffect(){
        super("Wing Buzz");
    }

    @Override
    public void accept(EffectVisitor visitor) {
        visitor.visitedWingBuzz(this);
    }

    @Override
    public void applyEffect(IPokemon poke) {
        EffectVisitor visitor = new PokemonEffectVisitor(poke);
        this.accept(visitor);
    }
}
