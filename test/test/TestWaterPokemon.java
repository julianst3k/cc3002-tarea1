package test;
import static org.junit.Assert.*;

import cc3002.tarea1.Energies.*;
import cc3002.tarea1.PokemonTypes.*;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Skill;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.IEnergia;
import java.util.ArrayList;
import java.util.Arrays;

public class TestWaterPokemon {
    private Pokemon waterPokemon;
    private Pokemon fighterPokemon;
    private Pokemon leafPokemon;
    private Pokemon lightPokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new Skill("generic", 100, new ArrayList<IEnergia>(), "XD")));
        waterPokemon = new BasicWaterPokemon("Zuko", 33, 1000, skillsWater);
        leafPokemon = new BasicLeafPokemon("Chikorita", 33, 300, skillsWater);
        fighterPokemon = new BasicFighterPokemon("Zuko", 33, 300, skillsWater);
        lightPokemon = new BasicLightPokemon("Zuko", 33, 300, skillsWater);
    }
    @Test public void testResist() {
        waterPokemon.selectSkill(0);
        leafPokemon.selectSkill(0);
        fighterPokemon.selectSkill(0);
        lightPokemon.selectSkill(0);
        leafPokemon.attack(waterPokemon);
        assertTrue(waterPokemon.getHp() == 800);
        fighterPokemon.attack(waterPokemon);
        assertTrue(waterPokemon.getHp() == 730);
        lightPokemon.attack(waterPokemon);
        assertTrue(waterPokemon.getHp()==530);
    }
    @Test public void testEnergies(){
        waterPokemon.setEnergy(new LightEnergy());
        assertEquals(waterPokemon.getEnergiesString(), "LIGHT: 1. ");
    }
}