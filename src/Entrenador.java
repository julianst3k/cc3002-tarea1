package cc3002.tarea;
import java.util.ArrayList;
import java.util.Random;
public class Entrenador {
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<Energia> Energias
    public Entrenador(){
        Activa=new Pokemon(); // No se si se pueda hacer esto, pq no se como se supone q se sacan inicialmente las cartas??
        Banca=new ArrayList<Pokemon>();
        Energias=new ArrayList<Energia>();
    }
    public Entrenador(Pokemon a){
        Activa = a;
        Banca = new ArrayList<Pokemon>();
        Energias = new ArrayList<Energia>();
    }
    public Entrenador(ArrayList<Pokemon> Initials){ // Por si es necesario, no cacho
        assertNotNull(Initials);
        Activa=Initials.get(0);
        Initials.remove(0)
        Banca=Initials;
        Energias=new ArrayLIst<Energia>();
    }
    public void activePokemonSwap(){
        if(this.Activa!=null){
            Pokemon AuxActive=0
            this.Activa=this.Banca.get(0);
            this.Banca.remove(0);
            this.Banca.add(AuxActive);
        }
        else {
            this.Activa = this.Banca.get(0);
            this.Banca.remove(0);
        }
    }
    public String cardInfo(Pokemon A){
        return "El pokemon es "+A.getIndex()+", Health Points = "+A.getHp()+", y sus energías son: "+A.getEnergies();

    }
    public String activeSkillsInfo(){
         return "Los ataques del Pokemon son "+this.Activa.showSkills();
    }

    public Skill selectAttack(int A){ // Me imagino que el ataque es una clase
        return this.Activa.Skills(A);
    }

    public void sacarCarta(Energia a){ // Para testear con cartas de energia y pokemon, sin depender del azar
        this.Energias.add(a);
    }
    public void sacarCarta(Pokemon b){
        if(this.cantidadBanca!=5){
            this.Banca.add(b);
        }
    }
    public void activeUseEnergy(int A){
        Energy forUse=this.Energias.get(A);
        this.Energias.remove(A);
        this.Activa.setEnergy(forUse);
    }
    public Pokemon getActiva(){
        return this.Activa;
    }
    public String cardInfoBanca(int i){
        if(i-1<=this.cantidadBanca()){
            return cardInfo(this.Banca.get(i-1));
        }
    }
    public void activeInfo(){
        System.out.println(cardInfo(this.Activa));
        System.out.println(this.activeSkillsInfo());
    }
    public void bancaInfo(){
        for(int i=0; i<this.cantidadBanca(); i++) {
            System.out.println(cardInfo(this.get(i)));
        }
    }
    public int cantidadBanca(){
        return this.Banca.size();
    }
    public ArrayList<Pokemon> Banca(){
        return this.Banca;
    }
    public int cantidadEnergias(){
        return this.Energias.size();
    }
}
