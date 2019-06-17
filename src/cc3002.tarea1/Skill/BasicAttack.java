package cc3002.tarea1.Skill;



import cc3002.tarea1.IEnergia;
import cc3002.tarea1.Skill.Attack;

import java.util.ArrayList;

public class BasicAttack extends Attack {
    /** Creates an attack without any effect
     *
     */
    /** Creates a basic attack
     *
     * @param name the name
     * @param dmg the dmg
     * @param costo the cost
     * @param description the description
     */
    public BasicAttack(String name, int dmg, ArrayList<IEnergia> costo, String description){
        super(name, dmg, costo, description);
    }
}
