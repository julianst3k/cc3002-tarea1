package cc3002.tarea1;

import java.util.HashMap;

public interface ISkill {
    /** An interface for the skill
     * @author Julian Solis Torrejon
     */
    /** Get the name of the skill
     *
     * @return A string of the name
     */
    String getName();

    /** Get the damage that the skill deals
     *
     * @return An integer of the damage
     */
    int getDamage();

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
}
