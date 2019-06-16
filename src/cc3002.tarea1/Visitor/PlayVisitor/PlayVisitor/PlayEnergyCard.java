package cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;

import cc3002.tarea1.*;
import cc3002.tarea1.Card.NullStadiumCard;
import cc3002.tarea1.Card.StadiumCard;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectPlayEnergy;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;

public class PlayEnergyCard extends PlayVisitor{
    Energy toBePlayed;
    StadiumCard card;
    public PlayEnergyCard(Entrenador entrenador){
        super(entrenador);
        card = new NullStadiumCard();
        entrenador.accept(this);
    }
    @Override
    public void visitedEnergyType(Energy energy){
        toBePlayed = energy;
    }
    @Override
    public void play(){
        EffectVisitor visitor = new EffectPlayEnergy();
        entrenador.accept(visitor);
        toBePlayed.getSetted(entrenador.getObjective());
        entrenador.getActualController().setEnergyCardPlayed();

    }

}
