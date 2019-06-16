package cc3002.tarea1;


import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public interface ISkill {
    /** An interface for the skill
     * @author Julian Solis Torrejon
     */
    /** Get the name of the skill
     *
     * @return A string of the name
     */
    String getName();



    /** Get the hashMap of the energy cards that the skill costs
     *
     * @return A hashMap of String, Integer
     */
    EnergyCounter getCost();

    /** Get the description of the skill
     *
     * @return A description of the skill
     */
    String getDescripcion();

    /** Get the cost, that is being showed by the getCost(), but in a string manner
     *
     * @return An String.
     */
    String getCostString();

    /** Get used by the user pokemon
     *
     * @param user User Pokemon
     * @param objective Objective Pokemon
     */
    void beUsed(Pokemon user, IPokemon objective);

    /** Show attributes
     *
     * @return An string with attributes
     */
    String showAttributes();

    /** Gives you the status of a skill, if it is usable, then we can play the skill
     *
     * @param control Controller that will gives us the status
     * @return True if it usable, False if it is not.
     */
    boolean isUsable(Controller control);

    /** Lets the skill to fill some special effects if it is needed
     *
     * @param poke The pokemon which the skill is set to
     */
    void setToPokemon(Pokemon poke);
    /** Apply an effect on demand
     * @param controller the controller who demand the effect
     */
    void applyEffect(Controller controller);
    /** Apply defensive effect on demand
     * @param dmg The dmg received
     */
    void applyDefense(int dmg);
    /** Use effect visitor if needed
     *
     */
    void accept(VisitorFather visitor);
}
