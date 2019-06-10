package cc3002.tarea1.Effect;

import cc3002.tarea1.EffectVisitor.EffectVisitor;

public abstract class IEffect {
    private String name;

    /** Creates an effect with a name
     *
     * @param nombre Name of the effect
     */
    public IEffect(String nombre){
        name = nombre;
    }

    /** Applies an effect, which depends on which effect it is
     *
     */
    public void applyEffect(){};
    public abstract void accept(EffectVisitor visitor);
}
