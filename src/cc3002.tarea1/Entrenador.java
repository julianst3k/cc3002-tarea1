package cc3002.tarea1;
import java.util.ArrayList;
public class Entrenador {
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<IEnergia> Energias;
    public Entrenador(Pokemon a){ // Defino el inicio del juego con un pokemon activo :)
        Activa = a;
        Banca = new ArrayList<Pokemon>();
        Energias = new ArrayList<IEnergia>();
    }
    public void activePokemonSwap(){
        if(this.cantidadBanca()==0){
            return;
        }
        else if(!this.getActiva().isDed()){
            Pokemon AuxActive=this.getActiva();
            this.Activa=this.Banca.get(0);
            this.Banca.remove(0);
            this.Banca.add(AuxActive);
        }
        else {
            this.Activa = this.Banca.get(0);
            this.Banca.remove(0);
        }
    }
    public void deadActive(){
        if(this.getActiva().isDed()){
            this.activePokemonSwap();
        }
    }
    public String cardInfo(Pokemon A){
        return "El pokemon es "+A.getName()+", su id es "+A.getIndex()+", Health Points = "+Math.round(A.getHp())+", y sus energias son: "+A.getEnergiesString();
    }
    public String activeSkillsInfo(){
         return "Los ataques del Pokemon son: "+this.Activa.showSkills();
    }
    public String activeSelectedSkill() {
        if (this.getActiva().getSelectedSkill() != null) {
            return "El ataque selecto es: " + this.getActiva().showSkill(this.getActiva().getSelectedSkillIndex());
        }
        else{
            return "No hay ataque selecto";
        }
    }
    public void selectAttack(int A){ // Me imagino que el ataque es una clase
        this.Activa.selectSkill(A-1);
    }
    public void sacarCarta(IEnergia a){ // Para testear con cartas de energia y pokemon, sin depender del azar
        this.Energias.add(a);
    }
    public void sacarCarta(Pokemon b){
        if(this.cantidadBanca()<5){
            this.Banca.add(b);
        }
    }
    public void activeUseEnergy(int A){
        IEnergia forUse=this.getEnergias().get(A-1);
        this.Energias.remove(A-1);
        this.Activa.setEnergy(forUse);
    }
    public Pokemon getActiva(){
        return this.Activa;
    }
    public String cardInfoBanca(int i){
        String result = "";
        if(i<=this.cantidadBanca()){
             result += i+". "+cardInfo(this.getBanca().get(i-1));
        }
        return result;
    }
    //public void activeInfo(){
      //   System.out.println(cardInfo(this.Activa));
    //}

    public String energyString(int A){
        String s = this.getEnergias().get(A-1).getName();
        return s;
    }
    // public void energyInfo()
    // { public void bancaInfo(){
    //        for(int i=1; i<=this.cantidadBanca(); i++) {
    //            System.out.println(cardInfoBanca(i));
    //        }
    //    }
     //   for(int i=1; i<=this.Energias.size(); i++){
     //       System.out.println(this.energyString(i));
     //   }
    // }
    public ArrayList<Pokemon> getBanca(){
        return this.Banca;
    }
    public int cantidadBanca(){
        return this.Banca.size();
    }
    public int cantidadEnergias(){
        return this.Energias.size();
    }
    public ArrayList<IEnergia> getEnergias() {
        return this.Energias;}
    public void pokemonAttack(Pokemon A){ // seria por default el pokemon del enemigo?
        if(this.Activa.getSelectedSkill()!=null){
            this.Activa.attack(A);
        }
    }
}
