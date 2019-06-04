package cc3002.tarea1;
import java.lang.reflect.Array;
import java.util.*;

public abstract class Pokemon implements IPokemon, ICardPlayable {
    /** Clase abstracta para pokemon
     * @author: Julian Solis Torrejon
     *
     */
    private int id;
    private String name;
    private int healthPoints;
    private EnergyCounter energies;
    private ArrayList<ISkill> skills;
    private ISkill selectedSkill;

    public Pokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills) {
        this.id = id;
        this.healthPoints = healthPoints;
        this.energies = new EnergyCounter();
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
    public boolean enoughEnergy(int index) {
        if (index >= 4) {
            return false;
        }
        return this.getEnergies().greaterThan(this.getSkills().get(index).getCost());
    }

    /** Show the user through a string how many energies the pokemon has
     *
     * @return String that show you energies
     */
    public String getEnergiesString() {
        EnergyCounter energia = this.getEnergies();
        String result = "";
        for (EnergyType entry : EnergyType.values()) {
            if(energia.getMap().get(entry)>0) {
                result += String.valueOf(entry) + ": " + String.valueOf(energia.getMap().get(entry)) + ". ";
            }
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
    public void setEnergy(IEnergia energy) {
        energy.getSetted(this);
    }


    /** The pokemon is attacked by someone who doesnt have any special interactions
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttacked(ISkill skill) {
        this.healthPoints -= skill.getDamage();
    }

    /** The pokemon is attacked by someone who is weak against him
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttackedResist(ISkill skill) {
        this.healthPoints -= skill.getDamage() - 30;
    }

    /** The pokemon is attacked by someone who is strong against him
     *
     * @param A The skill that the other pokemon uses
     */
    public void getAttackedVulnerable(ISkill skill) {
        this.healthPoints -= skill.getDamage() * 2;
    }

    /** Shows the skills of the pokemon
     *
     * @return A string with enumerated skills
     */
    public abstract String showSkills(); // No se el tipo, pero como el pokemon de tipo fuego solo tendra movimientos
    // de tipo fuego (??), entonces la implemento en su clase :)
    @Override
    public EnergyCounter getEnergies() {
        return energies;
    }
    @Override
    public void attackedByFire(ISkill skill) { // getAttacked(Attack) :)
        getAttacked(skill);
    }
    @Override
    public void attackedByWater(ISkill skill) {
        getAttacked(skill);
    }
    @Override

    public void attackedByLeaf(ISkill skill) {
        getAttacked(skill);
    }
    @Override

    public void attackedByLight(ISkill skill) {
        getAttacked(skill);
    }
    @Override


    public void attackedByFighter(ISkill skill) {
        getAttacked(skill);
    }
    @Override


    public void attackedByPsych(ISkill skill) {
        getAttacked(skill);
    }

    /** Select some attack to be the main one
     *
     * @param A Index of the attack that i want to select
     *
     */
    public void selectSkill(int index) {
        if (this.enoughEnergy(index)) {
            this.selectedSkill = this.skills.get(index);
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
    public void deleteAttack(int a){
        if(a<=this.getSkills().size()){
            this.getSkills().remove(a-1);
        }
    }
    /** A pokemon attacks another one
     *
     * @param A A pokemon
     */
    public abstract void attack(Pokemon enemyPoke);

    /** Show an specified skill, based on the index
     *
     * @param A index of the skill
     * @return The string of the skill
     */
    public abstract String showSkill(int index);
    @Override
    public String getDescrp(){
        String s = "";
        s += "Nombre: "+this.getName()+", ID: "+this.getIndex()+", Health Points: "+Math.round(this.getHp())+", Energias: "+this.getEnergiesString()+"\n";
        s += this.showSkills();
        return s;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void jugarCarta(Entrenador myTrainer){
        myTrainer.jugarCartaPokemon(this);
    }
}
