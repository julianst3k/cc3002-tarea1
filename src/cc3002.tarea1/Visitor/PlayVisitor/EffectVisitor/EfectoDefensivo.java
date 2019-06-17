package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Skill.InvisibleWall;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class EfectoDefensivo extends VisitorFather {
    private int originalDmg;
    public EfectoDefensivo(int dmg){
        originalDmg = dmg;
    }
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
