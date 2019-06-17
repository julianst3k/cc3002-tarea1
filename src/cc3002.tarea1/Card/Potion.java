package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

public class Potion extends InstantObjectCard {
    private int heal;
    public Potion(int healing){
        super("Potion", "Heals for "+healing);
        heal = healing;
    }

    @Override
    public void acceptEffect(EffectVisitor visitor){
        visitor.visitedPotion(this);
    }

    /** get the heal
     *
     * @return get heal
     */
    public int getHeal(){
        return heal;
    }

}
