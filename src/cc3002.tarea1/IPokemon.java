package cc3002.tarea1;
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
    void attackedByPsych(ISkill skill);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByFire(ISkill skill);
    /** Changes the HP of the Pokemon that is being attacked by a Water Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByWater(ISkill skill);
    /** Changes the HP of the Pokemon that is being attacked by a Grass Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByLeaf(ISkill skill);
    /** Changes the HP of the Pokemon that is being attacked by a Light Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByLight(ISkill skill);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param skill a skill
     */
    void attackedByFighter(ISkill skill);

    /** Tell the pokemon to attack another pokemon
     *
     * @param poke the another pokemon
     */
    void attack(IPokemon poke);

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
}
