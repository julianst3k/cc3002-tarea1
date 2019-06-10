package cc3002.tarea1;

import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.PlayVisitor.PlayObjectCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public abstract class ObjectCard extends TrainerCard  {
    private String name;
    private String description;
    private PokemonEffect effect;

    /** Creates a Object Card
     *
     * @param nam Name
     * @param desc Description
     */
    public ObjectCard(String nam, String desc, PokemonEffect newEffect){
        name = name;
        description = description;
        effect = newEffect;
    }
    @Override
    public String getDescrp(){
        return description;
    }
    @Override
    public String getName(){
        return name;
    }
    public PokemonEffect getEffect(){
        return effect;
    }
}
