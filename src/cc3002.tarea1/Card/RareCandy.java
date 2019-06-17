package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;


public class RareCandy extends InstantObjectCard {
    public RareCandy(){
        super("Rare Candy","Evolute a basic card");
    }
    @Override
    public void acceptEffect(EffectVisitor visitor){
        visitor.visitedRareCandy(this);
    }
}
