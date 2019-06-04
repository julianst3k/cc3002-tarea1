package cc3002.tarea1;
public interface IEnergia {
    /** An interface for energies
     * @author Julian Solis Torrejon
     */
    /** Set an energy for a pokemon
     *
     * @param pokemon A pokemon
     */
    void getSetted(IPokemon pokemon);
    /** Set an energy for a skill
     *
     * @param skill A skill
     */
    void getSetted(ISkill skill);
}
