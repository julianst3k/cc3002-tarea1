package cc3002.tarea1;
public class Energy implements IEnergia, ICard {
    private String type;
    public Energy(String a){
        this.type = a;
    }
    public String getType(){
        return this.type;
    }
    public String getDescrp() { return this.type; }
    public void jugarCarta(Entrenador a){
        a.jugarCartaEnergia(this);
    }
}
