package cc3002.tarea1.Effect;


import cc3002.tarea1.*;

import java.util.Observable;
import java.util.Observer;


public class InvisibleWallEffect extends PokemonEffect {
    private int damage;
    public InvisibleWallEffect(int defense){
        super("Invisible Wall");
        damage = defense;
    }

    @Override
    public void applyEffect(Controller controller) {
    }
    @Override
    public void applyDefense(int dmg){
        if(dmg<=damage){
            return;
        }
        else{
            if(pokemon.getEnergies().greaterThan(origin.getCost())){
                pokemon.setHealthPoints(damage-dmg+pokemon.getHp());
            }
            else{
                return;
            }
        }

    }
}
