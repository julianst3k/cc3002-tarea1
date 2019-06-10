package cc3002.tarea1.ControlVisitor;


import cc3002.tarea1.Attack;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill;
import cc3002.tarea1.WingBuzz;

public abstract class ControlVisitor {
    Controller control;
    public ControlVisitor(Controller newController){
        control = newController;
    }
    public void visitedSkill(Skill skill){};
    public void visitedAttack(Attack attack){};
    public void visitedWingBuzz(WingBuzz wingBuzz){};
    public abstract boolean usable();
}
