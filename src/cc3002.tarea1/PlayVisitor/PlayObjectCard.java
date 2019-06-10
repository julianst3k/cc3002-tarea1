package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.AttachObjectCard;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.InstantObjectCard;
import cc3002.tarea1.ObjectCard;

public abstract class PlayObjectCard extends PlayVisitor {
    /** Plays an object card. Object cards can be instantaneous or attachable. So this serves as an interface for both options.
     *
     * @author: Julian Solis Torrejon
     */
    protected ObjectCard toBePlayed;

    /** Creates an PlayObjectCard operation.
     *
     * @param trainer The trainer whose object card is from
     */
    public PlayObjectCard(Entrenador trainer){
        super(trainer);
    }
    @Override
    public void visitedInstantObjectCard(InstantObjectCard card){
        toBePlayed = card;
    }
    @Override
    public void visitedAttachObjectCard(AttachObjectCard card){
        toBePlayed = card;
    }

}
