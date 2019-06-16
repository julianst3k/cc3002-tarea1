package cc3002.tarea1.Card;

import cc3002.tarea1.Controller;
import cc3002.tarea1.ICardPlayable;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

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
    /** Apply an effect on demand
     * @param controller the controller who demand the effect
     */
    public void applyEffect(Controller controller){};
    public void accept(VisitorFather visitor){}
}
