package cc3002.tarea1;
public class Energy implements IEnergia {
    String type;
    public Energy(String a){
        type = a;
    }
    public String getType(){
        return this.type;
    }
}
