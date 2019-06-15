package cc3002.tarea1;

import cc3002.tarea1.Effect.InvisibleWallEffect;

import java.util.ArrayList;

public class InvisibleWall extends Skill{
    public InvisibleWall(ArrayList<IEnergia> costo, int absorb){
        super("Invisible Wall", costo,"come dmg", new InvisibleWallEffect(absorb));
    }
    public void setToPokemon(Pokemon poke){
        this.getEffect().setPokemon(poke);
        this.getEffect().setOrigin(this);
    }
}
