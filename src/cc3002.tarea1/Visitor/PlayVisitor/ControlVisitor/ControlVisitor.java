package cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;


import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Skill.WingBuzz;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public abstract class ControlVisitor extends VisitorFather {
    protected Controller control;
    public ControlVisitor(Controller newController){
        control = newController;
    }
    public void visitedSkill(Skill skill){};
    public void visitedAttack(Attack attack){};
    public void visitedWingBuzz(WingBuzz wingBuzz){};
    public abstract boolean usable();
}
