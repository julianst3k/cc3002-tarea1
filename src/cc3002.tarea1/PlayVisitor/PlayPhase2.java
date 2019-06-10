package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;


public class PlayPhase2 extends PlayVisitor {
    IPokemon cardToBePlayed;
    IPokemon cardToBeEvolved;
    /** Creates a operation to play cards of phase 2
     * @author: Julian Solis Torrejon
     */
    /** Creates the operation
     *
     * @param trainer Trainer of the card
     */
    public PlayPhase2(Entrenador trainer){
        super(trainer);
        cardToBePlayed = null;
        cardToBeEvolved = null;
    }
    @Override
    public void visitedPhase1Type(IPhase1Type basic){
        if(cardToBePlayed.getIndex()==basic.getIndex()) {
            cardToBeEvolved = basic;
        }
    }
    @Override
    public void visitedPhase2Type(IPhase2Type phase){
        if(cardToBePlayed==null){
            cardToBePlayed=phase;
        }
    }
    @Override
    public void visitedEntrenador(Entrenador trainer){
        trainer.getActiva().accept(this);
        for(int i=0; i<trainer.getBanca().size(); i++){
            trainer.getBanca().get(i).accept(this);
        }

    }
    @Override
    public void play(){
        if(cardToBeEvolved!=null) {
            entrenador.pokemonEvolve(entrenador.pokemonPlace(cardToBeEvolved), cardToBePlayed);
            cardToBePlayed.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(cardToBePlayed);
        }
    }
}
