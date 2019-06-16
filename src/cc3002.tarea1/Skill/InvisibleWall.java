package cc3002.tarea1.Skill;


import cc3002.tarea1.Controller;
import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Skill;

import java.util.ArrayList;

public class InvisibleWall extends Skill {
    /** Creates an invisible wall
     * @author Julian Solis Torrejon
     */
    private int sucked;
    public InvisibleWall(ArrayList<IEnergia> costo, int absorb){
        super("Invisible Wall", costo,"come dmg");
        sucked = absorb;
    }
    @Override
    public void applyEffect(Controller controller) {
    }
    @Override
    public void applyDefense(int dmg){
        if(dmg<=sucked){
            return;
        }
        else{
            if(this.getPokemon().getEnergies().greaterThan(this.getCost())){
                this.getPokemon().setHealthPoints(dmg-sucked+this.getPokemon().getHp());
            }
            else{
                return;
            }
        }

    }
}
