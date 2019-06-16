package cc3002.tarea1.Skill;


import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Attack;

import java.util.ArrayList;

public class HydroPump extends Attack {
    public HydroPump(int dmg, ArrayList<IEnergia> costo) {
        super("Hydro Pump", dmg, costo, "Does the hydropump effect");
    }
    public int getExtradmg(){
        int extra = 10*(this.getPokemon().getEnergies().totalCounter()-this.getCost().totalCounter());
        return extra;
    }
}
