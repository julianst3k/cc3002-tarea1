package cc3002.tarea1;
import java.util.ArrayList;
import java.util.HashMap;

public interface IPokemon {
    /** An interface for the Pokemon class
     * @author Julian Solis Torrejon
     */
    /** Gives you the ID of the Pokemon
     *
     * @return The number of the ID
     */
    int getIndex();

    /** Get the actual selected skill
     *
     * @return Return the selected skill
     */
    ISkill getSelectedSkill();

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
    HashMap<String, Integer> getEnergies();

    /** Returns the current status of deadness
     *
     * @return <code>true</code> if dead, <code>false</code> if not
     */
    boolean isDed();

    /** Changes the HP of the Pokemon that is being attacked by a Psych Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByPsych(ISkill A);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByFire(ISkill A);
    /** Changes the HP of the Pokemon that is being attacked by a Water Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByWater(ISkill A);
    /** Changes the HP of the Pokemon that is being attacked by a Grass Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByLeaf(ISkill A);
    /** Changes the HP of the Pokemon that is being attacked by a Light Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByLight(ISkill A);
    /** Changes the HP of the Pokemon that is being attacked by a Fire Pokemon with a skill A
     *
     * @param A a skill
     */
    void attackedByFighter(ISkill A);

    /** Tell the pokemon to attack another pokemon
     *
     * @param A the another pokemon
     */
    void attack(Pokemon A);

    /** Put a energy into the hashmap
     *
     * @param A An energy
     */
    void setEnergy(IEnergia A);

    /** Show an skill from the current set
     *
     * @param A the index
     * @return An string
     */
    String showSkill(int A);
}
