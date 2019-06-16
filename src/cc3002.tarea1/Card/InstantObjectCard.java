package cc3002.tarea1.Card;


import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

public class InstantObjectCard extends ObjectCard {
    public InstantObjectCard(String name, String descrp){
        super(name,descrp);
    }
    public void accept(VisitorFather visitor){
        visitor.visitedInstantObjectCard(this);
    }

}
