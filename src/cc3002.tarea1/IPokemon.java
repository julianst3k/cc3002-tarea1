package cc3002.tarea1;
import cc3002.tarea1.Effect.IEffect;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

import java.util.ArrayList;
import java.util.HashMap;

public interface IPokemon extends ICardPlayable {
    /** An interface for the Pokemon class
     * @author Julian Solis Torrejon
     */
    /** Gives you the ID of the Pokemon
     *
     * @return The number of the ID
     */
    int getIndex();
    /** Shows the skills of the pokemon
     *
     * @return A string with enumerated skills
     */
    String showSkills();

    /** Get the actual selected skill
     *
     * @return Return the selected skill
     */
    ISkill getSelectedSkill();
    /** Select some attack to be the main one
     *
     * @param index Index of the attack that i want to select
     *
     */
    void selectSkill(int index);
    /** Throws a list of the skills that the pokemon currently has
     *
     * @return get the skill
     */
    ArrayList<ISkill> getSkills();

    /** Provides the current health points of the card
     *
     * @return The HP number
     */
    int getHp();

    /** Get the hashMap of energies
     *
     * @return a HashMap
     */
    EnergyCounter getEnergies();

    /** Returns the current status of deadness
     *
     * @return <code>true</code> if dead, <code>false</code> if not
     */
    boolean isDed();

    /** Changes the HP of the Pokemon that is being attacked by a Psych Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByPsych(Attack skill);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByFire(Attack skill);
    /** Changes the HP of the Pokemon that is being attacked by a Water Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByWater(Attack skill);
    /** Changes the HP of the Pokemon that is being attacked by a Grass Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByLeaf(Attack skill);
    /** Changes the HP of the Pokemon that is being attacked by a Light Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByLight(Attack skill);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByFighter(Attack skill);

    /** Tell the pokemon to attack another pokemon
     *
     * @param poke the another pokemon
     * @param attack Attack which will be used. This parameter was set since now pokemon can have no attack abilities :)
     */
    void attack(IPokemon poke, Attack attack);

    /** Put a energy into the hashmap
     *
     * @param energies An energy
     */
    void setEnergy(IEnergia energies);

    /** Show an specified skill, based on the index
     *
     * @param index index of the skill
     * @return The string of the skill
     */
    String showSkill(int index);
    /** Give us a way to get a description of the main skill
     *
     * @return Index of the selected skill
     */
    int getSelectedSkillIndex();
    /** Verify that the energy that the pokemon have is enough to let it select some attack
     *
     * @param index Index of attack
     * @return <code>true</code> if it can, <code>false</code> if it cant
     */
    boolean enoughEnergy(int index);
    /** Set a set of energies on the pokemon
     *
     * @param array The set of energies
     */
    void setInitialEnergies(EnergyCounter array);
    void accept(PlayVisitor visitor);

    /** Set an object card to the Pokemon, if it has one already then it gets unequipped
     *
     * @param card object card
     */
    void setObject(ObjectCard card);
    /** Return the object card
     *
     */
    ObjectCard getActualObject();

    /** Use an ability, which could be an ability or an attack
     *
     * @param pokemon
     */
    void useSkill(IPokemon pokemon);

    /** Subscribe to a pokemon
     *
     * @param control The controller
     */
    void subscribePokemon(Controller control);
    /** Since setChanged() is protected, the effect is released by the skill and the Pokemon set the change
     * @param effect The effect that is being released
     */
    void releaseEffect(IEffect effect);
    /** Applies the energy burnt effect based on the pokemon type
     *
     */
    void getEnergyBurnt();

    /** Set the health points of a pokemon to a certain integer
     *
     * @param health health points that will be setted
     */
     void setHealthPoints(int health);
}
