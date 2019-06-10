package cc3002.tarea1;

import cc3002.tarea1.Effect.IEffect;

public abstract class TrainerCard implements ICardPlayable {
    /** The cards that extend Trainer Card will have an effect. This effect type will depends on the card. Object Cards has pokemon effects, which will act over a pokemon, Stadium Cards will
     * have a global effect, and support ones too.
     *
     * @return An effect
     */

    public abstract IEffect getEffect();
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
}
