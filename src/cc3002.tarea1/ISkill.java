package cc3002.tarea1;

import java.util.HashMap;

public interface ISkill {
    String getName();
    int getDamage();
    HashMap<String, Integer> getCost();
    String getDescripcion();
    String getCostString();
}
