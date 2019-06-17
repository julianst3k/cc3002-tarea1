package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Skill.WingBuzz;

public class UsableSkillVisitor extends ControlVisitor{
    /** In this case we are looking for skills that are usable or not
     * @author Julian Solis Torrejon
     */
    boolean status;
    public UsableSkillVisitor(Controller contr){
        super(contr);
        status = true;
    }

    @Override
    public void visitedWingBuzz(WingBuzz wingBuzz){if(control.getWingBuzzPlayed()==1){status = false;}

    }
    @Override
    public boolean usable(){
        return status;
    }
}
