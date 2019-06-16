package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;

import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPsychPokemon {
    private Pokemon psychPokemon;
    private Pokemon psychPokemon1;
    private Pokemon fighterPokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new BasicAttack("generic", 100, new ArrayList<IEnergia>(), "XD")));
        psychPokemon = new BasicPsychPokemon("Zuko", 33, 300, skillsWater);
        fighterPokemon = new BasicFighterPokemon("Chikorita", 33, 300, skillsWater);
        psychPokemon1 = new BasicPsychPokemon("Zuko", 33, 300, skillsWater);

    }
    @Test public void testResist(){
        psychPokemon.selectSkill(0); fighterPokemon.selectSkill(0); psychPokemon1.selectSkill(0);
        psychPokemon1.useSkill(psychPokemon);
        assertTrue(psychPokemon.getHp()==100);
        fighterPokemon.useSkill(psychPokemon);
        assertTrue(psychPokemon.getHp()==30);
        psychPokemon1.useSkill(fighterPokemon);
        assertTrue(fighterPokemon.getHp()==100);
    }
    @Test public void testOutput(){
        assertEquals(psychPokemon.showSkills(), "1. generic, de tipo psiquico y realiza 100 de daño. Descripcion: XD. Requiere: \n");

    }
}