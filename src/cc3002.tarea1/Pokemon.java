package cc3002.tarea1;

import cc3002.tarea1.Card.AttachObjectCard;
import cc3002.tarea1.Card.ObjectCard;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Visitor.PlayVisitor.EfectoDefensivo;

import java.util.*;

public abstract class Pokemon extends Observable implements IPokemon {
    /** Clase abstracta para pokemon
     * @author: Julian Solis Torrejon
     *
     */
    private int id;
    private String name;
    private int healthPoints;
    private int maxHp;
    private EnergyCounter energies;
    private ArrayList<ISkill> skills;
    private ISkill selectedSkill;
    private ObjectCard associated;

    /** Creates the pokemon
     *
     * @param name its name
     * @param id the id
     * @param healthPoints the hp
     * @param skills the skills
     */
    public Pokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills) {
        this.id = id;
        this.healthPoints = healthPoints; maxHp = this.healthPoints;
        this.energies = new EnergyCounter();
        if(skills!=null) {
            this.skills = this.setUp(skills);
        }
        this.selectedSkill = null;
        this.name = name;
        associated = null;

    }

    /** Limits the amount of skills that can be input and setup effects that needs to do so
     *
     * @param array List of skills that the constructor get
     * @return array List of skills that the pokemon will have
     */
    public ArrayList<ISkill> setUp(ArrayList<ISkill> array){
        ArrayList<ISkill> result = new ArrayList<ISkill>();
        for(int i=0; i<4 && i<array.size(); i++){
            result.add(array.get(i));
            array.get(i).setToPokemon(this);
        }
        return result;
    }
    @Override
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
        return energia.printEnergyCounter();
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
     * @param energy, input energy
     */
    public void setEnergy(IEnergia energy) {
        energy.getSetted(this);
    }


    /** The pokemon is attacked by someone who doesnt have any special interactions
     *
     * @param skill The skill that the other pokemon uses
     */
    public void getAttacked(Attack skill) {
        this.healthPoints -= skill.getDamage();
        this.releasesDefenses(skill.getDamage());
    }

    /** The pokemon is attacked by someone who is weak against him
     *
     * @param skill The skill that the other pokemon uses
     */
    public void getAttackedResist(Attack skill) {
        if(skill.getDamage() - 30 >0 ) {
            this.healthPoints -= skill.getDamage() - 30;
            this.releasesDefenses(skill.getDamage() - 30);
        }
        else{
            return;
        }
    }

    /** The pokemon is attacked by someone who is strong against him
     *
     * @param skill The skill that the other pokemon uses
     */
    public void getAttackedVulnerable(Attack skill) {
        this.healthPoints -= skill.getDamage() * 2;
        this.releasesDefenses(skill.getDamage()*2);
    }

    // No se el tipo, pero como el pokemon de tipo fuego solo tendra movimientos
    // de tipo fuego (??), entonces la implemento en su clase :)
    @Override
    public EnergyCounter getEnergies() {
        return energies;
    }
    @Override
    public void attackedByFire(Attack skill) { // getAttacked(Attack) :)
        getAttacked(skill);
    }
    @Override
    public void attackedByWater(Attack skill) {
        getAttacked(skill);
    }
    @Override

    public void attackedByLeaf(Attack skill) {
        getAttacked(skill);
    }
    @Override

    public void attackedByLight(Attack skill) {
        getAttacked(skill);
    }
    @Override


    public void attackedByFighter(Attack skill) {
        getAttacked(skill);
    }
    @Override


    public void attackedByPsych(Attack skill) {
        getAttacked(skill);
    }

    @Override
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
    @Override
    public int getSelectedSkillIndex(){
        return this.getSkills().indexOf(this.getSelectedSkill());
    }
    @Override
    public boolean isDed() {
        return this.getHp() <= 0;
    }

    /** Modify the attack list out of the constructor
     *
     * @param skill An skill
     */
    public void addAttack(ISkill skill){
        if(this.skills.size()<4){
            this.skills.add(skill);
        }
    }

    /** Deletes an attack from the pokemon
     *
     * @param val index of the card
     */
    public void deleteAttack(int val){
        if(val<=this.getSkills().size()){
            this.getSkills().remove(val-1);
        }
    }
    @Override
    public void useSkill(IPokemon poke){
        if(this.getSelectedSkill()==null || !this.getEnergies().greaterThan(this.getSelectedSkill().getCost())){
            return;
        }
        this.getSelectedSkill().beUsed(this, poke);
        setChanged();
        this.notifyObservers(this.getSelectedSkill());
        clearSelectedSkill();
    }

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
    public void setInitialEnergies(EnergyCounter array){
        this.energies = array;
    }
    @Override
    public void setObject(AttachObjectCard object){
        this.associated = object; object.setPokemon(this);
    }
    @Override
    public ObjectCard getActualObject(){
        return this.associated;
    }
    @Override
    public void subscribePokemon(Controller control){
        this.addObserver(control);
    }

    /** Return the total amount of energies
     *
     * @return The total amount of energies
     */
    public int totalEnergyCounter(){
        return this.getEnergies().totalCounter();
    }
    @Override
    public void setHealthPoints(int health){
        healthPoints = health;
    }
    public void releasesDefenses(int receivedDmg){
        EfectoDefensivo visitor = new EfectoDefensivo(receivedDmg);
        for(int i=0; i<getSkills().size(); i++){
            this.getSkills().get(i).accept(visitor);
        }
    }

    /** Clears the selected skill after using it
     *
     */
    public void clearSelectedSkill(){
        selectedSkill = null;
    }

    @Override
    public int getMaxHp(){
        return maxHp;
    }
}
