package cc3002.tarea1.Card;

import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

public abstract class TrainerCard implements ICardPlayable {
    /** The cards that extend Trainer Card will have an effect. This effect type will depends on the card. Object Cards has pokemon effects, which will act over a pokemon, Stadium Cards will
     * have a global effect, and support ones too.
     *
     * @return An effect
     */
    private String name;
    private String description;
    public TrainerCard(String nombre, String descrp){
        name = nombre;
        description = descrp;
    }
    @Override
    public String getDescrp(){
        return description;
    }
    @Override
    public String getName(){
        return name;
    }
    /** Accept an effect visitor, while the effect visitor is an extension of the father visitor, which
     * is already set to be accepted in ICardPlayable, the idea is that all the cards that are of the same
     * family are played the same, so they get played by the PlayVisitor as a general way. The different
     * effects have different needs, so the effect visitor manages that differents ways!
     *
     * @param visitor the effect visitor
     */
    public void acceptEffect(EffectVisitor visitor){}
}
