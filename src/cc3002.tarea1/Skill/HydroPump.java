package cc3002.tarea1.Skill;


import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class HydroPump extends Attack {
    /** Creates an hydropump
     * @author Julian Solis Torrejon
     */
    int maxdmg;
    public HydroPump(int dmg, ArrayList<IEnergia> costo, int max) {
        super("Hydro Pump", dmg, costo, "Does the hydropump effect");
        maxdmg = max;
    }

    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedHydroPump(this);
    }
    public int getMaxdmg(){
        return maxdmg;
    }
}
