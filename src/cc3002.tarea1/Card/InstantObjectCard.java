package cc3002.tarea1.Card;


import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class InstantObjectCard extends ObjectCard {
    /** Creates an Instant Object Card, this gets consumed
     * @author Julian Solis Torrejon
     */
    public InstantObjectCard(String name, String descrp){
        super(name,descrp);
    }
    @Override
    public void accept(VisitorFather visitor){
        visitor.visitedInstantObjectCard(this);
    }

}
