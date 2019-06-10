package cc3002.tarea1.PlayVisitor;
import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.Entrenador;

public class PlayInstantObjectCard extends PlayObjectCard{
    /** Creates an operation to play instantaneous object cards
     *
     * @author: Julian Solis Torrejon
     /* Creates the object
     * @param trainer the trainer of the card
     */
    public PlayInstantObjectCard(Entrenador trainer){
        super(trainer);
    }
    @Override
    public void play(){
        toBePlayed.getEffect().applyEffect(entrenador.getObjective());
    }
}
