package cc3002.tarea1;
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
        this.energies = this.inicializarHashEnergies();
        this.skills = skills;
        this.selectedSkill = null;
        this.name = name;
    }

    public boolean enoughEnergy(int A) {
        if (A > 4 || A == 0) {
            return false;
        }
        HashMap<String, Integer> energia = this.getEnergies();
        HashMap<String, Integer> energiaNecesaria = this.skills.get(A - 1).getCost(); // El costo sera un HashMap :)
        for (HashMap.Entry<String, Integer> entry : energiaNecesaria.entrySet()) {
            String type = entry.getKey();
            if (energia.get(type) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String getEnergiesString() {
        HashMap<String, Integer> energia = this.getEnergies();
        String result = "";
        for (HashMap.Entry<String, Integer> entry : energia.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            result += "la cantidad de energias " + entry.getKey() + " es " + String.valueOf(entry.getValue());
        }
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
        Integer cantidadInicial = energies.get(tipo);
        energies.put(tipo, cantidadInicial + 1);
    }

    public HashMap<String, Integer> inicializarHashEnergies() { //Basicamente creo un hash con campos de lista vacios!
        List<String> TiposPosibles = Arrays.asList("planta", "agua", "fuego", "lucha", "psiquico", "relampago"); // Y los tipos que puede tener la lista :)
        HashMap<String, Integer> energiasHash = new HashMap<String, Integer>();
        for (int i = 0; i < TiposPosibles.size(); i++) {
            energiasHash.put(TiposPosibles.get(i), 0);
        }
        return energiasHash;
    }

    public void getAttacked(ISkill A) {
        this.healthPoints -= A.getDamage();
    }

    public void getAttackedResist(ISkill A) {
        this.healthPoints -= A.getDamage() - 30;
    }

    public void getAttackedVulnerable(ISkill A) {
        this.healthPoints -= A.getDamage() / 2;
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
            this.selectedSkill = this.skills.get(A - 1);
        }
    }

    public ArrayList<ISkill> getSkills() {
        return this.skills;
    }

    public ISkill getSelectedSkill() {
        return this.selectedSkill;
    }

    public int getSelectedSkillDmg() {
        return this.getSelectedSkill().getDamage();
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
    public String getName(){
        return this.name;
    }
}
