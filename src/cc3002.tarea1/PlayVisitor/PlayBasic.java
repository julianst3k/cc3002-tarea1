package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.PokemonTypes.IBasicType;

public class PlayBasic extends PlayVisitor {
    ICardPlayable cardToBePlayed;
    public PlayBasic(Entrenador trainer){
        super(trainer);
        cardToBePlayed = null;
    }
    public void visitedBasicType(IBasicType card){
        if(cardToBePlayed==null){
            cardToBePlayed=card;
        }
    }
    public void visitedEntrenador(Entrenador entrenador){
        this.entrenador = entrenador;
    }
    public void play(){

    }

}
