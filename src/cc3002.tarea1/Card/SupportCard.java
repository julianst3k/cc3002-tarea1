package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class SupportCard extends TrainerCard {
    /** Creates a support card, in this case the support card would be null
     * @author Julian Solis Torrejon
     */
    /** creates the support card
     *
     * @param nombre name
     * @param description description
     */
    public SupportCard(String nombre, String description){
        super(nombre, description);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedSupportCard(this);
    }

}
