package cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;

public class PlayBasic extends PlayVisitor {
    IPokemon cardToBePlayed;
    /**  Play a basic pokemon :)
     * @author: Julian Solis Torrejon
     */

    /** Creates an operation to play a basic pokemon
     *
     * @param trainer A trainer
     */
    public PlayBasic(Entrenador trainer){
        super(trainer);
        cardToBePlayed = null;
    }
    @Override
    public void visitedBasicType(IBasicType card){
        if(cardToBePlayed==null){
            cardToBePlayed=card;
        }
    }
    @Override
    public void visitedEntrenador(Entrenador entrenador){
        this.entrenador = entrenador;
    }
    @Override
    public void play(){
        if(entrenador.getBanca().size()<5){
            entrenador.addToBanca(cardToBePlayed);
            cardToBePlayed.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(cardToBePlayed);
        }
    }

}
