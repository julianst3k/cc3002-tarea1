package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;

public class PlayPhase1 extends PlayVisitor {
    IPokemon cardToBePlayed;
    IPokemon cardToBeEvolved;
    public PlayPhase1(Entrenador trainer){
        super(trainer);
        cardToBePlayed = null;
        cardToBeEvolved = null;
    }
    public void visitedBasicType(IBasicType basic){
        if(cardToBePlayed.getIndex()==basic.getIndex()) {
            cardToBeEvolved = basic;
        }
    }
    public void visitedPhase1Type(IPhase1Type phase){
        if(cardToBePlayed==null){
            cardToBePlayed=phase;
        }
    }
    public void visitedEntrenador(Entrenador trainer){
        trainer.getActiva().accept(this);
        for(int i=0; i<trainer.getBanca().size(); i++){
            trainer.getBanca().get(i).accept(this);
        }

    }
    public void play(){
        if(cardToBeEvolved!=null) {
            entrenador.pokemonEvolve(entrenador.pokemonPlace(cardToBeEvolved), cardToBePlayed);
        }
        else{
            entrenador.backToHand(cardToBePlayed);
        }
    }
}
