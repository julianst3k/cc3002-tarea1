package cc3002.tarea1.Skill;


import cc3002.tarea1.Controller;
import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class EnergyBurn extends Skill {
    /** Energy Burn skill
     * @author Julian Solis Torrejon
     */
    public EnergyBurn(ArrayList<IEnergia> costo){
        super("Energy Burn", costo ,"Cambia tus chakras bb");
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedEnergyBurn(this);
    }
}
