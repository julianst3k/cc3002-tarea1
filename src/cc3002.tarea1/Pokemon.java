package cc3002.tarea1;
import java.lang.reflect.Array;
import java.util.*;

public abstract class Pokemon implements IPokemon, ICard {
    /** Clase abstracta para pokemon
     * @author: Julian Solis Torrejon
     *
     */
    private int id;
    private String name;
    private int healthPoints;
    private HashMap<String, Integer> energies;
    private ArrayList<ISkill> skills;
    private ISkill selectedSkill;

    public Pokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills) {
        this.id = id;
        this.healthPoints = healthPoints;
        this.energies = new HashMap<String, Integer>();
        this.skills = this.setUp(skills);
        this.selectedSkill = null;
        this.name = name;
    }

    /** Limits the amount of skills that can be input
     *
     * @param array List of skills that the constructor get
     * @return array List of skills that the pokemon will have
     */
    public ArrayList<ISkill> setUp(ArrayList<ISkill> array){
        ArrayList<ISkill> result = new ArrayList<ISkill>();
        for(int i=0; i<4 && i<array.size(); i++){
            result.add(array.get(i));
        }
        return result;
    }
    /** Verify that the energy that the pokemon have is enough to let it select some attack
     *
     * @param A Index of attack
     * @return <code>true</code> if it can, <code>false</code> if it cant
     */
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

    /** Show the user through a string how many energies the pokemon has
     *
     * @return String that show you energies
     */
    public String getEnergiesString() {
        HashMap<String, Integer> energia = this.getEnergies();
        String result = "";
        for (HashMap.Entry<String, Integer> entry : energia.entrySet()) {
            result += entry.getKey() + ": " + String.valueOf(entry.getValue())+". ";
        }
        return result;
    }
    @Override
    public int getIndex() {
        return this.id;
    }
    @Override
    public int getHp() {
        return this.healthPoints;
    }

    /** The input energy is indexed to the hashMap
     *
     * @param A, input energy
     */
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

    /** The pokemon is attacked by someone who doesnt have any special interactions
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttacked(ISkill A) {
        this.healthPoints -= A.getDamage();
    }

    /** The pokemon is attacked by someone who is weak against him
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttackedResist(ISkill A) {
        this.healthPoints -= A.getDamage() - 30;
    }

    /** The pokemon is attacked by someone who is strong against him
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttackedVulnerable(ISkill A) {
        this.healthPoints -= A.getDamage() * 2;
    }
    public abstract String showSkills(); // No se el tipo, pero como el pokemon de tipo fuego solo tendra movimientos
    // de tipo fuego (??), entonces la implemento en su clase :)
    @Override
    public HashMap<String, Integer> getEnergies() {
        return energies;
    }
    @Override
    public void attackedByFire(ISkill A) { // getAttacked(Attack) :)
        getAttacked(A);
    }
    @Override
    public void attackedByWater(ISkill A) {
        getAttacked(A);
    }
    @Override

    public void attackedByLeaf(ISkill A) {
        getAttacked(A);
    }
    @Override

    public void attackedByLight(ISkill A) {
        getAttacked(A);
    }
    @Override


    public void attackedByFighter(ISkill A) {
        getAttacked(A);
    }
    @Override


    public void attackedByPsych(ISkill A) {
        getAttacked(A);
    }

    /** Select some attack to be the main one
     *
     * @param A Index of the attack that i want to select
     *
     */
    public void selectSkill(int A) {
        if (enoughEnergy(A)) {
            this.selectedSkill = this.skills.get(A);
        }
    }

    @Override
    public ArrayList<ISkill> getSkills() {
        return this.skills;
    }
    @Override
    public ISkill getSelectedSkill() {
        return this.selectedSkill;
    }

    /** Give us a way to get a description of the main skill
     *
     * @return Index of the selected skill
     */
    public int getSelectedSkillIndex(){
        return this.getSkills().indexOf(this.getSelectedSkill());
    }
    @Override
    public boolean isDed() {
        return this.getHp() <= 0;
    }

    /** Modify the attack list out of the constructor
     *
     * @param a A generic skill
     */
    public void addAttack(ISkill a){
        if(this.skills.size()<4){
            this.skills.add(a);
        }
    }
    public abstract void attack(Pokemon A);
    public abstract String showSkill(int A);
    public String getDescrp(){
        String s = "";
        s += "Nombre: "+this.getName()+", ID: "+this.getIndex()+", Health Points: "+Math.round(this.getHp())+", Energias: "+this.getEnergiesString()+"\n";
        s += this.showSkills();
        return s;
    }
    public String getName(){
        return this.name;
    }
    public void jugarCarta(Entrenador a){
        a.jugarCartaPokemon(this);
    }
}
