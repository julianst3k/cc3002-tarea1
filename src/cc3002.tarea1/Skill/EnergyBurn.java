package cc3002.tarea1.Skill;


import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class EnergyBurn extends Skill {
    /** Energy Burn skill
     * @author Julian Solis Torrejon
     */
    /** creates an energy burn skill
     *
     * @param costo the cost
     */
    public EnergyBurn(ArrayList<IEnergia> costo){
        super("Energy Burn", costo ,"Cambia tus chakras bb");
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedEnergyBurn(this);
    }
}
