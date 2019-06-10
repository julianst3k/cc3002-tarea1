package cc3002.tarea1;

import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.PlayVisitor.PlayObjectCard;
import cc3002.tarea1.PlayVisitor.PlayVisitor;

public abstract class ObjectCard extends TrainerCard  {

    private PokemonEffect effect;

    /** Creates a Object Card
     *
     * @param nam Name
     * @param desc Description
     */
    public ObjectCard(String nam, String desc, PokemonEffect newEffect){
        super(nam, desc);
        effect = newEffect;
    }

    public PokemonEffect getEffect(){
        return effect;
    }
}
