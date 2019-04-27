package cc3002.tarea1;
import java.util.ArrayList;
import java.util.HashMap;

public interface IPokemon {
    int getIndex();
    ISkill getSelectedSkill();
    ArrayList<ISkill> getSkills();
    int getHp();
    HashMap<String, Integer> getEnergies();
    boolean isDed();
    void attackedByPsych(ISkill A);
    void attackedByFire(ISkill A);
    void attackedByWater(ISkill A);
    void attackedByLeaf(ISkill A);
    void attackedByLight(ISkill A);
    void attackedByFighter(ISkill A);
    void attack(Pokemon A);
    void setEnergy(IEnergia A);
    String showSkill(int A);
}
