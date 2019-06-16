package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;

import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestFirePokemon {
    private Pokemon firePokemon;
    private Pokemon waterPokemon;
    private Pokemon leafPokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new BasicAttack("generic", 100, new ArrayList<IEnergia>(), "XD")));
        firePokemon = new BasicFirePokemon("Zuko", 33, 300, skillsWater);
        leafPokemon = new BasicLeafPokemon("Chikorita", 33, 300, skillsWater);
        waterPokemon = new BasicWaterPokemon("Squirtle", 33, 300, skillsWater);
    }
    @Test public void testResist(){
        firePokemon.selectSkill(0); leafPokemon.selectSkill(0); waterPokemon.selectSkill(0);
        firePokemon.useSkill(leafPokemon); waterPokemon.useSkill(firePokemon);
        assertTrue(firePokemon.getHp()==100);
        assertTrue(leafPokemon.getHp()==100);
        waterPokemon.useSkill(leafPokemon);
        assertTrue(leafPokemon.getHp()==30);
    }
}
