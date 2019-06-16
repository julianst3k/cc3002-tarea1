package cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;
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
        entrenador.getActualController().manageEffect(toBePlayed);
    }
}
