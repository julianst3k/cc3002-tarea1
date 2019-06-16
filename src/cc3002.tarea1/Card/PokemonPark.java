package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor.EffectVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class PokemonPark extends StadiumCard {
    private int healing;
    public PokemonPark(int heal){
        super("Pokemon Park", "Una vez por turno blabla");
        healing = heal;
    }

    /** Does an overload over the accept stadium card
     *
     * @param visitor The play energy card visitor
     */
    public void accept(VisitorFather visitor){
        visitor.visitedPokemonPark(this);

    }

    /** Return the health effect
     *
     * @return Healing amount
     */
    public int getHealthEffect(){
        return healing;
    }

}
