package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Skill.InvisibleWall;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class EfectoDefensivo extends VisitorFather {
    /** Reduce dmgs or return dmgs
     * @author Julian Solis Torrejon
     *
     */
    private int originalDmg;

    /** Creates the defense
     *
     * @param dmg the dmg to be deffended to
     */
    public EfectoDefensivo(int dmg){
        originalDmg = dmg;
    }
    @Override
    public void visitedInvisibleWall(InvisibleWall wall){
        if(originalDmg<=wall.getSucked()){
            return;
        }
        else{
            if(wall.getPokemon().getEnergies().greaterThan(wall.getCost())){
                wall.getPokemon().setHealthPoints(originalDmg-wall.getSucked()+wall.getPokemon().getHp());
                originalDmg = originalDmg - wall.getSucked();
            }
            else{
                return;
            }
        }
    }
}
