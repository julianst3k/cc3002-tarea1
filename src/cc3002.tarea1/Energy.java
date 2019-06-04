package cc3002.tarea1;
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
    public void jugarCarta(Entrenador player){
        player.jugarCartaEnergia(this);
    }
    @Override
    abstract public void getSetted(IPokemon pokemon);
    @Override
    abstract public void getSetted(ISkill skill);
}
