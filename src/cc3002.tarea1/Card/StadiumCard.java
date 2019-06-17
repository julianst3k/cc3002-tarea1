package cc3002.tarea1.Card;


import cc3002.tarea1.Controller;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public abstract class StadiumCard extends TrainerCard{
    /** Creates an stadium card, that it is common for implemented cards
     * @author Julian Solis Torrejon
     */
    public StadiumCard(String nombre, String descrp){
        super(nombre, descrp);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedStadiumCard(this);
    }

    /** When the controller sets this stadium cards, and if the stadium card have a passive effect, this card will set its passive effect
     *
     * @param controller the controller
     */
    public void applyEffectPassive(Controller controller){}

    /** When the controller sets another stadium card, the effect will get overwritten by the other. So the current affected cards are going to have its effects reversed.
     * This would be useful for cards that activates permanently (i.e. Training Center). This effect wont be implemented, but could be implemented with this
     *
     * @param controller the controller
     */
    public void dettachEffectPassive(Controller controller){}
}
