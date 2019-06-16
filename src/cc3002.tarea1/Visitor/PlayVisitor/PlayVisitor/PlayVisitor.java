package cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor;

import cc3002.tarea1.*;
import cc3002.tarea1.Card.*;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase2Type;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor.Phase1Available;
import cc3002.tarea1.Visitor.PlayVisitor.ControlVisitor.Phase2Available;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectPlayEnergy;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;
import com.sun.source.tree.InstanceOfTree;


public class PlayVisitor extends VisitorFather {
    /** An abstract class in common for all the playable cards
     *
     * @author: Julian Solis Torrejon
     */
    protected Entrenador entrenador;

    /** The cards are always played by a trainer, so it is convenient to always initialize it with the trainer, instead of giving it by the visitor
     *
     * @param trainer the trainer that plays the card
     */
    public PlayVisitor(Entrenador trainer){
        entrenador = trainer;
    }
    @Override
    public void visitedBasicType(IBasicType basic){
        if(entrenador.getBanca().size()<5){
            entrenador.addToBanca(basic);
            basic.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(basic);
        }
    }
    @Override
    public void visitedPhase1Type(IPhase1Type poke){
        Phase1Available effect = new Phase1Available(entrenador.getActualController(), poke);
        if(effect.usable()) {
            entrenador.pokemonEvolve(poke);
            poke.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(poke);
        }
    }
    @Override
    public void visitedPhase2Type(IPhase2Type poke){
        Phase2Available effect = new Phase2Available(entrenador.getActualController(), poke);
        if(effect.usable()) {
            entrenador.pokemonEvolve(poke);
            poke.subscribePokemon(entrenador.getActualController());
        }
        else{
            entrenador.backToHand(poke);
        }
    }
    @Override
    public void visitedEnergyType(Energy energy){
        EffectVisitor visitor = new EffectPlayEnergy();
        entrenador.accept(visitor);
        energy.getSetted(entrenador.getObjective());
        entrenador.getActualController().setEnergyCardPlayed();
    }
    @Override
    public void visitedInstantObjectCard(InstantObjectCard card ){
        entrenador.getActualController().manageEffect(card);
    }
    @Override
    public void visitedAttachObjectCard(AttachObjectCard card){
        if(entrenador.getObjective().getActualObject()!=null){
            entrenador.getObjective().setObject(card);
        }
        else{
            entrenador.backToHand(card);
        }
    }
    @Override
    public void visitedSupportCard(SupportCard card){
        entrenador.getActualController().manageEffect(card);
        entrenador.getActualController().setSupportCardPlayed();
    }
    @Override
    public void visitedStadiumCard(StadiumCard card){
        entrenador.setStadium(card);
    }
    /** This is called after the card is played, so it is the expected action that the card will take after being played.
     *
     */
    public void play(){};



}
