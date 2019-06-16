package cc3002.tarea1.Card;

import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class AttachObjectCard extends ObjectCard {
    Pokemon pokemon;

    public AttachObjectCard(String name, String descrp){
        super(name,descrp);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedAttachObjectCard(this);
    }
    public void applyConstantEffect(Pokemon poke){}
    public void setPokemon(Pokemon poke){
        pokemon = poke;
    }
    public Pokemon getPokemon(){
        return pokemon;
    }

}
