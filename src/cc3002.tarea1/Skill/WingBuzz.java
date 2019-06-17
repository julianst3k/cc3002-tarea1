package cc3002.tarea1.Skill;



import cc3002.tarea1.Controller;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

import java.util.ArrayList;

public class WingBuzz extends Skill {
    /** Creates a wing buzz
     * @author Julian Solis Torrejon
     */
    /** Creates the wingbuzz
     *
     * @param costo the cost
     */
    public WingBuzz(ArrayList<IEnergia> costo){
        super("Wing Buzz", costo, "Una vez por turno, si  ́este Pokemon es el activo, puedes descartar una carta de tu mano. Si lo haces, descarta la carta superior del mazo de tu oponente");
    }

    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedWingBuzz(this);
    }
}
