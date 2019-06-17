package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Controller;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;

public class RareCandyEffect extends EffectVisitor {
    /** Rare Candy Effect
     * @author Julian Solis Torrejon
     *
     */
    private IPokemon selectedCard;
    private Entrenador entrenador;

    /** Creates a rare candy effect
     *
     * @param controller the controller
     */
    public RareCandyEffect(Controller controller){
        super(controller);
        entrenador = controller.getInTurnTrainer();
        entrenador.accept(this);
    }
    @Override
    public void visitedPhase1Type(IPhase1Type poke){
        if(selectedCard!=null && poke.getPreEvolutionID()==selectedCard.getIndex()) {
            entrenador.pokemonEvolve(poke);
        }
    }
    @Override
    public void visitedPhase2Type(IPhase2Type poke){
        if(selectedCard!=null && poke.getPreEvolutionID()==selectedCard.getIndex()) {
            entrenador.pokemonEvolve(poke);
        }
    }
    @Override
    public void visitedEntrenador(Entrenador trainer){
        entrenador = trainer;
        trainer.getObjective().accept(this);
        if(trainer.getSelectedCard()!=null) {
            trainer.getSelectedCard().accept(this);
        }
    }
    public void visitedBasicType(IBasicType type){
        selectedCard = type;
    }
}
