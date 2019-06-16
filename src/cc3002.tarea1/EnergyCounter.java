package cc3002.tarea1;

import java.util.EnumMap;
import java.util.Map;

public class EnergyCounter {
    private Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);
    public EnergyCounter(){
     for(EnergyType type: EnergyType.values()){
         energies.put(type,0);
     }
    }
    public Map<EnergyType, Integer> getMap(){
        return this.energies;
    }
    public void setFighterEnergy(){
        energies.put(EnergyType.FIGHTER, 1+this.getFighterEnergy());

    }
    public void setFighterEnergy(int amount){
        energies.put(EnergyType.FIGHTER, amount+this.getFighterEnergy());

    }
    public void setFireEnergy(){
        energies.put(EnergyType.FIRE, 1+this.getFireEnergy());

    }
    public void setFireEnergy(int amount){
        energies.put(EnergyType.FIRE, amount+this.getFireEnergy());

    }
    public void setLeafEnergy(){
        energies.put(EnergyType.LEAF, 1+this.getLeafEnergy());
    }
    public void setLeafEnergy(int amount){
        energies.put(EnergyType.LEAF, amount+this.getLeafEnergy());
    }

    public void setLightEnergy(){
        energies.put(EnergyType.LIGHT, 1+this.getLightEnergy());

    }
    public void setLightEnergy(int amount){
        energies.put(EnergyType.LIGHT, amount+this.getLightEnergy());

    }
    public void setPsychEnergy(){
        energies.put(EnergyType.PSYCH, 1+this.getPsychEnergy());

    }
    public void setPsychEnergy(int amount){
        energies.put(EnergyType.PSYCH, amount+this.getPsychEnergy());

    }
    public void setWaterEnergy(){
        energies.put(EnergyType.WATER, 1+this.getWaterEnergy());

    }
    public void setWaterEnergy(int amount){
        energies.put(EnergyType.WATER, amount+this.getWaterEnergy());

    }
    public int getFighterEnergy(){
        return energies.get(EnergyType.FIGHTER);

    }
    public int getFireEnergy(){
        return energies.get(EnergyType.FIRE);

    }
    public int getLeafEnergy(){
        return energies.get(EnergyType.LEAF);


    }
    public int getLightEnergy(){
        return energies.get(EnergyType.LIGHT);


    }
    public int getPsychEnergy(){
        return energies.get(EnergyType.PSYCH);


    }
    public int getWaterEnergy(){
        return energies.get(EnergyType.WATER);


    }
    public boolean greaterThan(EnergyCounter other){
        for (EnergyType type : EnergyType.values()) {
            if (energies.get(type) < other.getMap().get(type)) {
                return false;
            }
        }
        return true;

    }
    public int totalCounter(){
        int counter = 0;
        for (EnergyType type : EnergyType.values()) {
            counter += energies.get(type);
        }
        return counter;
    }




}
