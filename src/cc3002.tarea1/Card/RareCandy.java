package cc3002.tarea1.Card;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.RareCandyEffect;


public class RareCandy extends InstantObjectCard {
    public RareCandy(){
        super("Rare Candy","Evolute a basic card");
    }
    public void applyEffect(Controller controller){
        EffectVisitor visitor = new RareCandyEffect(controller);
        controller.getInTurnTrainer().accept(visitor);
    }
}
