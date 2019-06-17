package cc3002.tarea1.Visitor.PlayVisitor;


import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Skill.WingBuzz;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public abstract class ControlVisitor extends VisitorFather {
    /** Creates a visitor that is related to the controller and how the game is managed
     * @author Julian Solis Torrejon
     */
    protected Controller control;
    public ControlVisitor(Controller newController){
        control = newController;
    }

    /** This controller is made to create an usability parameter.
     *
     * @return the usability
     */
    public abstract boolean usable();
}
