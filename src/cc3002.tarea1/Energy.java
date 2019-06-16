package cc3002.tarea1;

import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayEnergyCard;
import cc3002.tarea1.Visitor.PlayVisitor.PlayVisitor.PlayVisitor;
import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

abstract public class Energy implements IEnergia, ICardPlayable {
    /** A class that implement the IEnergia and ICard methods
     * @author: Julian Solis Torrejon
     *
     */
    private String name;

    public Energy(String a){
        this.name = a;
    }
    @Override
    public String getName() { return this.name; }
    @Override
    public String getDescrp() { return this.name; }
    @Override
    public void accept(VisitorFather visitor){ visitor.visitedEnergyType(this);}
    @Override
    public void jugarCarta(Entrenador player){
        PlayVisitor visitor = new PlayEnergyCard(player);
        this.accept(visitor);
        visitor.play();
    }
    @Override
    abstract public void getSetted(IPokemon pokemon);
    @Override
    abstract public void getSetted(ISkill skill);
}
