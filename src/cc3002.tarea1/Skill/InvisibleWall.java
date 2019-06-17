package cc3002.tarea1.Skill;


import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

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
    public void accept(VisitorFather visitor){
        visitor.visitedInvisibleWall(this);
    }

    /** Returns the sucked dmg
     *
     * @return the sucked dmg
     */
    public int getSucked(){
        return sucked;
    }
}
