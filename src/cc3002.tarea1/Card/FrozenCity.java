package cc3002.tarea1.Card;

import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class FrozenCity extends StadiumCard {
    /** Creates an stadium card called Frozen City
     * @author Julian Solis Torrejon
     */
    int cont;
    public FrozenCity(int contador){
        super("Frozen City", "Quita hasta "+contador+" contadores de daño");
        cont = contador;
    }

    @Override
    public void accept(VisitorFather visitor) {
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
