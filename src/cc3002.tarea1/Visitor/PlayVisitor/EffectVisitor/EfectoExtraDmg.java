package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill.HydroPump;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class EfectoExtraDmg extends VisitorFather {
    private int value;
    public void EfectoExtraDmg(){
        value = 0;
    }
    @Override
    public void visitedHydroPump(HydroPump pump){
        int extra = 10*(pump.getPokemon().getEnergies().totalCounter()-pump.getCost().totalCounter());
        if(extra>pump.getMaxdmg()){
            value = pump.getMaxdmg();
            return;
        }
        value = extra;
    }
    /** Returns the extra dmg
     * @return extra value
     */
    public int getValue(){
        return value;
    }
}
