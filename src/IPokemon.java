package cc3002.tarea;

import java.util.ArrayList;

public interface IPokemon {
    int getIndex();
    ISkill getSelectedSkill();
    ArrayList<ISkill> getSkills();
    double getHp();
    boolean isDed();
    void attackedByPsych(PsychSkill A);
    void attackedByFire(FireSkill A);
    void attackedByWater(WaterSkill A);
    void attackedByLeaf(LeafSkill A);
    void attackedByLight(LightSKill A);
    void attackedByFighter(FighterSkill A);
    void setEnergy(IEnergia A);
    void attack(IPokemon A);
}
