package cc3002.tarea1;

import cc3002.tarea1.Visitor.PlayVisitor.VisitorFather;

abstract public class Energy implements IEnergia, ICardPlayable {
    /** A class that implement the IEnergia and ICard methods
     * @author: Julian Solis Torrejon
     *
     */
    private String name;

    /** Creates an energy card
     *
     * @param name The name of the card
     */
    public Energy(String name){
        this.name = name;
    }
    @Override
    public String getName() { return this.name; }
    @Override
    public String getDescrp() { return this.name; }
    @Override
    public void accept(VisitorFather visitor){ visitor.visitedEnergyType(this);}

    @Override
    abstract public void getSetted(IPokemon pokemon);
    @Override
    abstract public void getSetted(ISkill skill);
}
