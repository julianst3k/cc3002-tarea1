package cc3002.tarea;

import java.lang.reflect.Array;
import java.util.*;

public abstract class Pokemon implements IPokemon{
    private int id;
    private double healthPoints;
    private HashMap<String, Integer> energies;
    private ArrayList<ISkill> skills;
    private ISkill selectedSkill;
    public Pokemon(int id, double healthPoints, ArrayList<ISkill> skills){
        this.id=id;
        this.healthPoints=healthPoints;
        this.energies=this.inicializarHashEnergies();
        this.skills=skills;
        this.selectedSkill=null;
    }
    public boolean enoughEnergy(int A){
        if(A>4 || A==0){
            return false;
        }
        HashMap<String, Integer> energia = this.getEnergies();
        HashMap<String, Integer> energiaNecesaria = this.skills.get(A-1).costo(); // El costo sera un HashMap :)
        for(HashMap.Entry<String, Integer> entry : energiaNecesaria.entrySet()){
            String type = entry.getKey();
            if(energia.get(type)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public String getEnergiesString(){
        HashMap<String, Integer> energia = this.getEnergies();
        String result = "";
        for(HashMap.Entry<String, Integer> entry: energia.entrySet()){
            if(entry.getValue()==0){
                continue;
            }
            result+="la cantidad de energias "+entry.getKey()+" es "+String.valueOf(entry.getValue());
        }
        return result;
    }
    public double getIndex(){
        return this.id;
    }
    public double getHp(){
        return this.healthPoints;
    }
    public void setEnergy(IEnergia A) {
        String tipo = A.getType(); // No se me ocurrio como hacerlo con double dispatch aja
        Integer cantidadInicial = energies.get(tipo);
        energies.put(tipo, cantidadInicial + 1);
    }
    public HashMap<String,Integer> inicializarHashEnergies(){ //Basicamente creo un hash con campos de lista vacios!
        List<String> TiposPosibles = Arrays.asList("planta", "agua", "fuego", "lucha", "psiquico", "relampago"); // Y los tipos que puede tener la lista :)
        HashMap<String, Integer> energiasHash = new HashMap<String, Integer>;
        for(int i=0; i<TiposPosibles.length; i++){
            energiasHash.put(TiposPosibles.get(i), 0);
        }
    }
    public void getAttacked(ISkill A){
        this.healthPoints-= A.damage();
    }
    public void getAttackedResist(ISkill A){
        this.healthPoints-= A.damage()-30;
    }
    public void getAttackedVulnerable(ISkill A){
        this.healthPoints-= A.damage()/2;
    }
    public abstract String ShowSkills(); // No se el tipo, pero como el pokemon de tipo fuego solo tendra movimientos
    // de tipo fuego (??), entonces la implemento en su clase :)
    public HashMap<String, Integer> getEnergies() {
        return energies;
    }
    public void attackedByFire(FireSkill A){
        getAttacked(A);
    }
    public void attackedByWater(WaterSkill A){
        getAttacked(A);
    }
    public void attackedByLeaf(LeafSkill A){
        getAttacked(A);
    }
    public void attackedByLight(LightSkill A){
        getAttacked(A);
    }
    public void attackedByFighter(FighterSkill A){
        getAttacked(A);
    }
    public void attackedByPsych(PsychSkill A){
        getAttacked(A);
    }
    public void selectAttack(int A){
        if(enoughEnergy(A)) {
            this.selectedSkill = this.skills.get(A - 1);
        }
    }
    public ArrayList<ISkill> getSkills(){
        return this.skills;
    }
    public ISkill getSelectedSkill(){
        return this.selectedSkill;
    }
    public boolean isDed(){
        return this.getHp()<=0;
    }
    public void attack(IPokemon A){
        this.getSelectedSkill().attack(A);
    }
}
