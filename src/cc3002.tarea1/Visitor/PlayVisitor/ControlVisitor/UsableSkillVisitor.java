package cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor;

import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Skill.WingBuzz;

public class UsableSkillVisitor extends ControlVisitor{
    boolean status;
    public UsableSkillVisitor(Controller contr){
        super(contr);
    }
    public void visitedSkill(Skill skill){status = true;};
    public void visitedAttack(Attack attack){status = true;};
    public void visitedWingBuzz(WingBuzz wingBuzz){if(control.getWingBuzzPlayed()==1){status = false;}
    else{
        status=true;
    }
    }
    public boolean usable(){
        return status;
    }
}
