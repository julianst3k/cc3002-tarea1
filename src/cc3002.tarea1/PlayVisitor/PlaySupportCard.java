package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.StadiumCard;
import cc3002.tarea1.SupportCard;

public class PlaySupportCard extends PlayVisitor{
    /** Creates an operation that play a support card
     * @author: Julián Solís Torrejón
     */
    SupportCard toBePlayed;
    public PlaySupportCard(Entrenador trainer){
        super(trainer);
    }
    @Override
    public void visitedSupportCard(SupportCard card){
        toBePlayed = card;
    }
    @Override
    public void play(){
        toBePlayed.getEffect().applyEffect();
    }
}
