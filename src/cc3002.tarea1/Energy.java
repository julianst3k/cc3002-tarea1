package cc3002.tarea1;
abstract public class Energy implements IEnergia, ICard {
    /** A class that implement the IEnergia and ICard methods
     * @author: Julian Solis Torrejon
     *
     */
    private String type;
    public Energy(String a){
        this.type = a;
    }
    @Override
    public String getType(){
        return this.type;
    }
    @Override
    public String getDescrp() { return this.type; }
    @Override
    public void jugarCarta(Entrenador a){
        a.jugarCartaEnergia(this);
    }
}
