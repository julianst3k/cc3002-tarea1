package cc3002.tarea1;
public class Energy implements IEnergia, ICard {
    private String type;
    private String name;
    public Energy(String a){
        this.type = a;
        this.name = a;
    }
    public String getType(){
        return this.type;
    }
    public String getName(){
        return this.name;
    }
}
