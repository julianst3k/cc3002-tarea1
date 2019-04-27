package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.*;
import cc3002.tarea1.PokemonTypes.*;
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

    @Before public void setUp(){
        fightEnergy = new FighterEnergy();
        fireEnergy = new FireEnergy();
        leafEnergy = new LeafEnergy();
        lightEnergy = new LightEnergy();
        psychEnergy = new PsychEnergy();
        waterEnergy = new WaterEnergy();
    }
    @Test public void testResist() {
        assertEquals(fightEnergy.getDescrp(), "Energia de Lucha");
        assertEquals(fireEnergy.getDescrp(), "Energia de Fuego");
        assertEquals(leafEnergy.getDescrp(), "Energia de Planta");
        assertEquals(lightEnergy.getDescrp(), "Energia de Rayo");
        assertEquals(psychEnergy.getDescrp(), "Energia de Psiquico");
        assertEquals(waterEnergy.getDescrp(), "Energia de Agua");
    }
}