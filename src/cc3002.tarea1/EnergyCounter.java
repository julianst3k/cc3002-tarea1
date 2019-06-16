package cc3002.tarea1;

import java.util.EnumMap;
import java.util.Map;

public class EnergyCounter {
    /** A composite of energies
     * @author Julian Solis Torrejon, but stolen from ucursos
     *
     */
    private Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);
    public EnergyCounter(){
     for(EnergyType type: EnergyType.values()){
         energies.put(type,0);
     }
    }

    /** Returns the energy map
     *
     * @return the map
     */
    public Map<EnergyType, Integer> getMap(){
        return this.energies;
    }

    /** Set 1 fighter energy
     *
     */
    public void setFighterEnergy(){
        energies.put(EnergyType.FIGHTER, 1+this.getFighterEnergy());

    }

    /** Set an amount of fighter energies, used for Energy Burn
     *
     * @param amount amount of energies
     */
    public void setFighterEnergy(int amount){
        energies.put(EnergyType.FIGHTER, amount+this.getFighterEnergy());

    }

    /** Set 1 fire energy
     *
     */
    public void setFireEnergy(){
        energies.put(EnergyType.FIRE, 1+this.getFireEnergy());

    }
    /** Set an amount fire energy
     * @param amount
     */
    public void setFireEnergy(int amount){
        energies.put(EnergyType.FIRE, amount+this.getFireEnergy());

    }

    /** Set one leaf energy
     *
     */
    public void setLeafEnergy(){
        energies.put(EnergyType.LEAF, 1+this.getLeafEnergy());
    }

    /** Set an amount of leaf energy
     *
     * @param amount amount of energies
     */
    public void setLeafEnergy(int amount){
        energies.put(EnergyType.LEAF, amount+this.getLeafEnergy());
    }

    /** Set 1 light energy
     */
    public void setLightEnergy(){
        energies.put(EnergyType.LIGHT, 1+this.getLightEnergy());

    }

    /** Set an amount of light energies
     *
     * @param amount the quantity
     */
    public void setLightEnergy(int amount){
        energies.put(EnergyType.LIGHT, amount+this.getLightEnergy());

    }

    /** Set 1 psych energy
     *
     */
    public void setPsychEnergy(){
        energies.put(EnergyType.PSYCH, 1+this.getPsychEnergy());

    }

    /** Set an amount of psych
     *
     * @param amount the quantity
     */
    public void setPsychEnergy(int amount){
        energies.put(EnergyType.PSYCH, amount+this.getPsychEnergy());

    }

    /** Set 1 water energy
     *
     */
    public void setWaterEnergy(){
        energies.put(EnergyType.WATER, 1+this.getWaterEnergy());

    }

    /** Set an amount of energy
     *
     * @param amount amount
     */
    public void setWaterEnergy(int amount){
        energies.put(EnergyType.WATER, amount+this.getWaterEnergy());

    }

    /** Get the amount of fighter energy
     *
     * @return the amount
     */
    public int getFighterEnergy(){
        return energies.get(EnergyType.FIGHTER);

    }

    /** Get the amount of fire energy
     *
     * @return the amount
     */
    public int getFireEnergy(){
        return energies.get(EnergyType.FIRE);

    }

    /** Get the amount of leaf energy
     *
     * @return the amount
     */
    public int getLeafEnergy(){
        return energies.get(EnergyType.LEAF);


    }

    /** Get the amount of light energy
     *
     * @return the amount
     */
    public int getLightEnergy(){
        return energies.get(EnergyType.LIGHT);


    }

    /** Get the amount of psych energy
     *
     * @return the amount
     */
    public int getPsychEnergy(){
        return energies.get(EnergyType.PSYCH);


    }

    /** Get the amount of water energy
     *
     * @return the amount
     */
    public int getWaterEnergy(){
        return energies.get(EnergyType.WATER);


    }

    /** Checks if the energy counter is greater than the energy counter compared to
     *
     * @param other the other energy counter
     * @return True if greater or equal, false is lesser
     */
    public boolean greaterThan(EnergyCounter other){
        for (EnergyType type : EnergyType.values()) {
            if (energies.get(type) < other.getMap().get(type)) {
                return false;
            }
        }
        return true;

    }

    /** Returns the total counter
     *
     * @return total counter
     */
    public int totalCounter(){
        int counter = 0;
        for (EnergyType type : EnergyType.values()) {
            counter += energies.get(type);
        }
        return counter;
    }
    public String printEnergyCounter(){
        String result = "";
        for (EnergyType entry : EnergyType.values()) {
            if(this.getMap().get(entry)>0) {
                result += String.valueOf(entry) + ": " + String.valueOf(this.getMap().get(entry)) + ". ";
            }
        }
        return result;
    }



}
