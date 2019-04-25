package cc3002.tarea1;
import java.lang.reflect.Array;
import java.util.*;

public abstract class Pokemon implements IPokemon, ICard {
    private int id;
    private String name;
    private double healthPoints;
    private HashMap<String, Integer> energies;
    private ArrayList<ISkill> skills;
    private ISkill selectedSkill;

    public Pokemon(String name, int id, double healthPoints, ArrayList<ISkill> skills) {
        this.id = id;
        this.healthPoints = healthPoints;
        this.energies = new HashMap<String, Integer>();
        this.skills = this.setUp(skills);
        this.selectedSkill = null;
        this.name = name;
    }
    public ArrayList<ISkill> setUp(ArrayList<ISkill> array){
        ArrayList<ISkill> result = new ArrayList<ISkill>();
        for(int i=0; i<4 && i<array.size(); i++){
            result.add(array.get(i));
        }
        return result;
    }
    public boolean enoughEnergy(int A) {
        if (A >= 4) {
            return false;
        }
        HashMap<String, Integer> energia = this.getEnergies();
        HashMap<String, Integer> energiaNecesaria = this.skills.get(A).getCost(); // El costo sera un HashMap :)
        for (HashMap.Entry<String, Integer> entry : energiaNecesaria.entrySet()) {
            String type = entry.getKey();
            if (energia.get(type)==null || energia.get(type) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String getEnergiesString() {
        HashMap<String, Integer> energia = this.getEnergies();
        String result = "";
        for (HashMap.Entry<String, Integer> entry : energia.entrySet()) {
            result += entry.getKey() + ": " + String.valueOf(entry.getValue())+", ";
        }
        result+= ".";
        return result;
    }

    public int getIndex() {
        return this.id;
    }


    public double getHp() {
        return this.healthPoints;
    }

    public void setEnergy(IEnergia A) {
        String tipo = A.getType(); // No se me ocurrio como hacerlo con double dispatch aja
        if(energies.get(tipo)==null){
            energies.put(tipo, 1);
        }
        else {
            Integer cantidadInicial = energies.get(tipo);
            energies.put(tipo, cantidadInicial + 1);
        }
    }

    public void getAttacked(ISkill A) {
        this.healthPoints -= A.getDamage();
    }

    public void getAttackedResist(ISkill A) {
        this.healthPoints -= A.getDamage() - 30;
    }

    public void getAttackedVulnerable(ISkill A) {
        this.healthPoints -= A.getDamage() * 2;
    }

    public abstract String showSkills(); // No se el tipo, pero como el pokemon de tipo fuego solo tendra movimientos

    // de tipo fuego (??), entonces la implemento en su clase :)
    public HashMap<String, Integer> getEnergies() {
        return energies;
    }

    public void attackedByFire(ISkill A) { // getAttacked(Attack) :)
        getAttacked(A);
    }

    public void attackedByWater(ISkill A) {
        getAttacked(A);
    }

    public void attackedByLeaf(ISkill A) {
        getAttacked(A);
    }

    public void attackedByLight(ISkill A) {
        getAttacked(A);
    }

    public void attackedByFighter(ISkill A) {
        getAttacked(A);
    }

    public void attackedByPsych(ISkill A) {
        getAttacked(A);
    }

    public void selectSkill(int A) {
        if (enoughEnergy(A)) {
            this.selectedSkill = this.skills.get(A);
        }
    }

    public ArrayList<ISkill> getSkills() {
        return this.skills;
    }

    public ISkill getSelectedSkill() {
        return this.selectedSkill;
    }
    public int getSelectedSkillIndex(){
        return this.getSkills().indexOf(this.getSelectedSkill());
    }


    public boolean isDed() {
        return this.getHp() <= 0;
    }
    public void addAttack(ISkill a){
        if(this.skills.size()<4){
            this.skills.add(a);
        }
    }
    public abstract void attack(Pokemon A);
    public abstract String showSkill(int A);
    public String getName(){
        return this.name;
    }
}
