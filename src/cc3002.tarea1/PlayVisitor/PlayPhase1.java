package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayPhase1 extends PlayVisitor {
    IPhase1Type cardToBePlayed;
    ArrayList<IPokemon> cardToBeEvolved;
    /** Creates a operation to play cards of phase 1
     * @author: Julian Solis Torrejon
     */
    /** Creates the operation
     *
     * @param trainer Trainer of the card
     */
    public PlayPhase1(Entrenador trainer){
        super(trainer);
        cardToBePlayed = null;
        cardToBeEvolved = new ArrayList<>();
    }
    @Override
    public void visitedBasicType(IBasicType basic){
        if(cardToBePlayed.getPreEvolutionID()==basic.getIndex()) {
            cardToBeEvolved.add(basic);
        }
    }
    @Override
    public void visitedPhase1Type(IPhase1Type phase){
        if(cardToBePlayed==null){
            cardToBePlayed=phase;
        }
    }
    @Override
    public void visitedEntrenador(Entrenador trainer){
        trainer.getObjective().accept(this);

    }
    @Override
    public void play(){
        if(cardToBeEvolved.size()>0) {
            entrenador.pokemonEvolve(cardToBePlayed);
            cardToBePlayed.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(cardToBePlayed);
        }
    }
}
