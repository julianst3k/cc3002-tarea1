package cc3002.tarea1.Card;

import cc3002.tarea1.Visitor.PlayVisitor.EffectVisitor;

public class ProfessorJuniper extends SupportCard {
    /** Creates a professor juniper card
     * @author Julian Solis Torrejon
     */
    public ProfessorJuniper(){
        super("Professor Juniper", "Descarta tu mano y saca 7 del mazo");
    }

    @Override
    public void acceptEffect(EffectVisitor visitor) {
        visitor.visitedProfessorJuniper(this);
    }
}
