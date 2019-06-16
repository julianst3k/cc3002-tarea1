package cc3002.tarea1.Visitor.PlayVisitor;

import cc3002.tarea1.Card.*;
import cc3002.tarea1.Energy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PokemonTypes.IBasicType;
import cc3002.tarea1.PokemonTypes.IPhase1Type;
import cc3002.tarea1.PokemonTypes.IPhase2Type;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Skill.Skill;
import cc3002.tarea1.Skill.WingBuzz;

public abstract class VisitorFather {
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
    public void visitedInstantObjectCard(InstantObjectCard card){};

    /** Visited an attachable object card
     *
     * @param card The card
     */
    public void visitedAttachObjectCard(AttachObjectCard card){};


    /** Visited an stadium card
     *
     * @param card The card
     */
    public void visitedStadiumCard(StadiumCard card){};

    /** Visited a support card
     *
     * @param card The card
     */
    public void visitedSupportCard(SupportCard card){};
    /** Visited energy card
     * @param card The card
     */
    public void visitedEnergyType(Energy card){};


    /** Visited an skill
     *
     * @param skill the skill
     */
    public void visitedSkill(Skill skill){};

    /** Visited an attack
     *
     * @param attack the attack
     */
    public void visitedAttack(Attack attack){};
    /** Visited a pokemon park
     *
     */
    public void visitedPokemonPark(PokemonPark park){}

    /** Visited a WingBuzz skill
     *
     * @param wingBuzz the wingbuzz
     */
    public void visitedWingBuzz(WingBuzz wingBuzz){};

}
