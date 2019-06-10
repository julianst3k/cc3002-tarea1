package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.StadiumCard;

public class PlayStadiumCard extends PlayVisitor {
    /** Creates an operation that play an stadium card
     * @author: Julián Solís Torrejón
     */
    StadiumCard toBePlayed;
    public PlayStadiumCard(Entrenador trainer){
        super(trainer);
    }
    @Override
    public void visitedStadiumCard(StadiumCard card){
        toBePlayed = card;
    }
    public void play(){
        entrenador.setStadium(toBePlayed);
    }
}
