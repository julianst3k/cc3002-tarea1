package cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;

import cc3002.tarea1.Entrenador;

public class PlayAttachObjectCard extends PlayObjectCard {
    /** Play an object card that gets attached to the trainer's selected pokemon. If the trainer's selected pokemon already has one attached card, then the card don't get attached to it.
     *
     *  @author: Julian Solis Torrejon
     */
    /** Creates an operation to attach object cards
     *
     * @param trainer The trainer
     */
    public PlayAttachObjectCard(Entrenador trainer){
        super(trainer);
    }
    @Override
    public void play(){
        if(entrenador.getObjective().getActualObject()!=null){
            entrenador.getObjective().setObject(toBePlayed);
        }
        else{
            entrenador.backToHand(toBePlayed);
        }
    }
}
