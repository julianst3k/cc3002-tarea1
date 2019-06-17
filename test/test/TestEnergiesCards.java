package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.*;
import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.Attack;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEnergiesCards {
    private Energy fightEnergy;
    private Energy fireEnergy;
    private Energy leafEnergy;
    private Energy lightEnergy;
    private Energy psychEnergy;
    private Energy waterEnergy;
    private Pokemon setted;
    private Attack attack;

    @Before public void setUp(){
        fightEnergy = new FighterEnergy();
        fireEnergy = new FireEnergy();
        leafEnergy = new LeafEnergy();
        lightEnergy = new LightEnergy();
        psychEnergy = new PsychEnergy();
        waterEnergy = new WaterEnergy();
        setted = new BasicFighterPokemon("xD", 33, 33, new ArrayList<>());
        attack = new BasicAttack("xD", 33, new ArrayList<>(Arrays.asList(fightEnergy, fireEnergy, leafEnergy, lightEnergy, psychEnergy, waterEnergy)), "xD");

    }
    @Test public void testResist() {
        assertEquals(fightEnergy.getDescrp(), "Energia de Lucha");
        assertEquals(fireEnergy.getDescrp(), "Energia de Fuego");
        assertEquals(leafEnergy.getDescrp(), "Energia de Planta");
        assertEquals(lightEnergy.getDescrp(), "Energia de Rayo");
        assertEquals(psychEnergy.getDescrp(), "Energia de Psiquico");
        assertEquals(waterEnergy.getDescrp(), "Energia de Agua");
    }
    @Test public void setEnergies(){
        EnergyCounter counter = setted.getEnergies();
        setted.setEnergy(fightEnergy);
        assertEquals(counter.getFighterEnergy(), 1);
        setted.setEnergy(fireEnergy);
        assertEquals(counter.getFireEnergy(), 1);
        setted.setEnergy(lightEnergy);
        assertEquals(counter.getLightEnergy(), 1);
        setted.setEnergy(psychEnergy);
        assertEquals(counter.getPsychEnergy(), 1);
        setted.setEnergy(waterEnergy);
        assertEquals(counter.getWaterEnergy(), 1);
        setted.setEnergy(leafEnergy);
        assertEquals(counter.getLeafEnergy(), 1);
        EnergyCounter counter1 = attack.getCost();
        assertEquals(counter1.getLeafEnergy(), 1);
        assertEquals(counter1.getWaterEnergy(), 1);
        assertEquals(counter1.getFighterEnergy(), 1);
        assertEquals(counter1.getPsychEnergy(), 1);
        assertEquals(counter1.getFireEnergy(), 1);
        assertEquals(counter1.getLightEnergy(), 1);
    }
}