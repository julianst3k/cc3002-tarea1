package cc3002.tarea1;
import java.util.ArrayList;
public class Entrenador {
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<ICard> Mano;
    public Entrenador(Pokemon a){ // Defino el inicio del juego con un pokemon activo :)
        Activa = a;
        Banca = new ArrayList<Pokemon>();
        Mano = new ArrayList<ICard>();
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
    public String cardInfo(ICard A){
        return A.getDescrp();
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
    public void sacarCarta(ICard A){
        this.Mano.add(A);
    }
    public void activeUseEnergy(Energy A){
        this.Activa.setEnergy(A);
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
    public void jugarCarta(int A){
        if(A>0 && A<=this.Mano.size()) {
            ICard Card = this.Mano.get(A - 1);
            this.Mano.remove(A - 1);
            Card.jugarCarta(this);
        }
    }
    public String cardInfoMano(int i){
        if(this.getMano().size()>=i){
            return this.cardInfo(this.getMano().get(i-1));
        }
        else{
            return "";
        }
    }
    public void jugarCartaPokemon(Pokemon A){
        if(this.cantidadBanca()<5){
            this.Banca.add(A);
        }
        else{
            this.Mano.add(A);
        }
    }
    public void jugarCartaEnergia(Energy A){
        this.activeUseEnergy(A);
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
    public ArrayList<ICard> getMano(){
        return this.Mano;
    }
    public String showMano(){
        String result = "";
        for(int i=0; i<this.getMano().size(); i++){
            result += Integer.toString(i+1)+". "+this.getMano().get(i).getDescrp()+".\n";
        }
        return result;
    }
    public void pokemonAttack(Pokemon A){ // seria por default el pokemon del enemigo?
        if(this.Activa.getSelectedSkill()!=null){
            this.Activa.attack(A);
        }
    }
    public int cantidadMano(){
        return this.getMano().size();
    }
}
