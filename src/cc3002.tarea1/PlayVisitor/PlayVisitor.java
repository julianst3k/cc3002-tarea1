package cc3002.tarea1.PlayVisitor;

import cc3002.tarea1.*;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase2Type;


public abstract class PlayVisitor {
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

    /** Visited a BasicType pokemon. It is used to play basic type cards or to check if the phase 1 is playable
     *
     * @param card The card
     */
    public void visitedBasicType(IBasicType card){};

    /** Visited a Phase1 Pokemon. It is used to play phase 1 type cards or to check if the phase 2 is playable
     *
     * @param card The card
     */
    public void visitedPhase1Type(IPhase1Type card){};

    /** Visited a Phase2 Pokemon. It is used to play phase 2 type cards
     *
     * @param card The card
     */
    public void visitedPhase2Type(IPhase2Type card){};

    /** Visited a trainer. It is used to check the trainer's cards, if it is needed
     *
     * @param entrenador The trainer
     */
    public void visitedEntrenador(Entrenador entrenador){};

    /** Visited an instant object card. It is used to play the instant card
     *
     * @param card The card
     */
    public void visitedInstantObjectCard(InstantObjectCard card){}

    /** Visited an attachable object card
     *
     * @param card The card
     */
    public void visitedAttachObjectCard(AttachObjectCard card){}

    /** This is called after the card is played, so it is the expected action that the card will take after being played.
     *
     */
    public abstract void play();

    /** Visited an stadium card
     *
     * @param card The card
     */
    public void visitedStadiumCard(StadiumCard card){};
}
