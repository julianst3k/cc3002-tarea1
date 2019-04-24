package cc3002.tarea1;
import java.util.ArrayList;
public class Entrenador {
    private Pokemon Activa;
    private ArrayList<Pokemon> Banca;
    private ArrayList<IEnergia> Energias;
    public Entrenador(){
        Activa=new Pokemon(); // No se si se pueda hacer esto, pq no se como se supone q se sacan inicialmente las cartas??
        Banca=new ArrayList<Pokemon>();
        Energias=new ArrayList<IEnergia>();
    }
    public Entrenador(Pokemon a){
        Activa = a;
        Banca = new ArrayList<Pokemon>();
        Energias = new ArrayList<IEnergia>();
    }
    public Entrenador(ArrayList<Pokemon> Initials){ // Por si es necesario, no cacho
        assertNotNull(Initials);
        Activa=Initials.get(0);
        Initials.remove(0);
        Banca=Initials;
        Energias=new ArrayLIst<IEnergia>();
    }
    public void activePokemonSwap(){
        if(this.Activa!=null){
            Pokemon AuxActive=this.getActiva();
            this.Activa=this.Banca.get(0);
            this.Banca.remove(0);
            this.Banca.add(AuxActive);
        }
        else {
            if(this.cantidadBanca()==0){
                return;
            }
            this.Activa = this.Banca.get(0);
            this.Banca.remove(0);
        }
    }

    public String cardInfo(Pokemon A){
        return "El pokemon es "+A.getIndex()+", Health Points = "+A.getHp()+", y sus energías son: "+A.getEnergiesString();

    }
    public String activeSkillsInfo(){
         return "Los ataques del Pokemon son "+this.Activa.showSkills();
    }

    public void selectAttack(int A){ // Me imagino que el ataque es una clase
        this.Activa.selectSkill(A);
    }

    public void sacarCarta(IEnergia a){ // Para testear con cartas de energia y pokemon, sin depender del azar
        this.Energias.add(a);
    }
    public void sacarCarta(Pokemon b){
        if(this.cantidadBanca()!=5){
            this.Banca.add(b);
        }
    }
    public void activeUseEnergy(int A){
        IEnergia forUse=this.getEnergias().get(A);
        this.Energias.remove(A);
        this.Activa.setEnergy(forUse);
    }
    public Pokemon getActiva(){
        return this.Activa;
    }
    public String cardInfoBanca(int i){
        if(i-1<=this.cantidadBanca()){
            return cardInfo(this.getBanca().get(i-1));
        }
    }
    public void activeInfo(){
        System.out.println(cardInfo(this.Activa));
        System.out.println(this.activeSkillsInfo());
    }
    public void bancaInfo(){
        for(int i=0; i<this.cantidadBanca(); i++) {
            System.out.println(cardInfo(this.getBanca.get(i)));
        }
    }
    public ArrayList<Pokemon> getBanca(){
        return this.Banca;
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
    public ArrayList<IEnergia> getEnergias() { return this.Energias;}
    public void pokemonAttack(IPokemon A){ // seria por default el pokemon del enemigo?
        if(this.Activa.getSelectedSkill()!=null){
            this.Activa.attack(A);
        }
    }
}
