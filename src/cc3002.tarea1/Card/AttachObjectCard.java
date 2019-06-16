package cc3002.tarea1.Card;

import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class AttachObjectCard extends ObjectCard {
    /** Creates an object card that instead of getting consumed, get put into a pokemon
     * @author Julian Solis Torrejon
     */
    Pokemon pokemon;

    public AttachObjectCard(String name, String descrp){
        super(name,descrp);
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedAttachObjectCard(this);
    }

    /** An object card tends to apply effects that are constant into the objective pokemon.
     * This is not currently used since no attached object card were created
     *
     * @param poke Pokemon
     */
    public void applyConstantEffect(Pokemon poke){}

    /** Set a Pokemon to the card, to gather information
     *
     * @param poke The pokemon
     */
    public void setPokemon(Pokemon poke){
        pokemon = poke;
    }

    /** Get the setted pokemon
     *
     * @return the pokemon
     */
    public Pokemon getPokemon(){
        return pokemon;
    }

}
