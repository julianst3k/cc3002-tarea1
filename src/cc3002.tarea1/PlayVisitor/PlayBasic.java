package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;

public class PlayBasic extends PlayVisitor {
    IPokemon cardToBePlayed;
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
        if(entrenador.getBanca().size()<5){
            entrenador.addToBanca(cardToBePlayed);
        }
        else{
            entrenador.backToHand(cardToBePlayed);
        }
    }

}
