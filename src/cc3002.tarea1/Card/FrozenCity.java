package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

public class FrozenCity extends StadiumCard {
    /** Creates an stadium card called Frozen City
     * @author Julian Solis Torrejon
     */
    int cont;

    /** Creates a frozen city
     *
     * @param contador defines counter
     */
    public FrozenCity(int contador){
        super("Frozen City", "Quita hasta "+contador+" contadores de daño");
        cont = contador;
    }

    @Override
    public void acceptEffect(EffectVisitor visitor) {
        visitor.visitedFrozenCity(this);
    }

    /** Gets the current counter
     *
     * @return the counter
     */
    public int getCont(){
        return cont;
    }
}
