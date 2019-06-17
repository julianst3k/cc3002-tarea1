package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

public class PokemonPark extends StadiumCard {
    /** Creates a Pokemon Park
     *
     *
     */
    /** creates the pokemon park card
     *
     */
    public PokemonPark(){
        super("Pokemon Park", "Una vez por turno blabla");
    }

    /** Does an overload over the accept stadium card
     *
     * @param visitor The play energy card visitor
     */
    @Override
    public void acceptEffect(EffectVisitor visitor){
        visitor.visitedPokemonPark(this);
    }


}
