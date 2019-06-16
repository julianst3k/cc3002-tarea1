package cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

import cc3002.tarea1.Card.FrozenCity;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Card.PokemonPark;


public class EffectPlayEnergy extends EffectVisitor {
    /** Effects that are related to playing energy
     * @author The energy
     */
    Entrenador trainer;
    public EffectPlayEnergy(Controller controller){
        super(controller);
        trainer = controller.getInTurnTrainer();
        trainer.getStadiumCard().accept(this);
    }
    @Override
    public void visitedPokemonPark(PokemonPark card){
        if(trainer.getObjective().getMaxHp()-trainer.getObjective().getHp()>10) {
            trainer.getObjective().setHealthPoints(trainer.getObjective().getHp() + 10);
        }
        else{
            trainer.getObjective().setHealthPoints(trainer.getObjective().getMaxHp());

        }
    }
    @Override
    public void visitedFrozenCity(FrozenCity card){
        if(trainer.getObjective().getHp()<10*card.getCont()){
            trainer.getObjective().setHealthPoints(0);
            trainer.purgePokemon(trainer.pokemonPlace(trainer.getObjective()));
        }
        else{
            trainer.getObjective().setHealthPoints(trainer.getObjective().getHp()-10*card.getCont());
        }
    }


}
