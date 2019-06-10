package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Effect.NullInstantEfect;
import cc3002.tarea1.Effect.NullPokemonEffect;
import cc3002.tarea1.Energies.FighterEnergy;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.*;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Energies.LeafEnergy;

import java.util.ArrayList;
import java.util.Arrays;

public class TestPokemonAttacks {
    private Pokemon lightPokemon;
    private Pokemon waterPokemon;
    private Pokemon fighterPokemon;
    private Pokemon punchingBag;
    private Pokemon leafPokemon;
    private Pokemon psychPokemon;
    private Pokemon firePokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new Attack("generic", 100, new ArrayList<IEnergia>(), "XD", new NullPokemonEffect())));
        lightPokemon = new BasicLightPokemon("Azula", 33, 300, skillsWater);
        fighterPokemon = new BasicFighterPokemon("Iron Man dies", 33, 300, skillsWater);
        waterPokemon = new BasicWaterPokemon("Squirtle", 33, 300, skillsWater);
        punchingBag = new BasicFirePokemon("Kanojedo", 400, 10000, skillsWater);
        leafPokemon = new BasicLeafPokemon("Eco", 400, 300, skillsWater);
        psychPokemon = new BasicPsychPokemon("Pedro Engel", 300, 300, skillsWater);
        firePokemon = new BasicFirePokemon("My Mixtape", 300, 300, skillsWater);
    }
    @Test public void testResist(){
        lightPokemon.selectSkill(0); fighterPokemon.selectSkill(0); waterPokemon.selectSkill(0);
        leafPokemon.selectSkill(0); psychPokemon.selectSkill(0); firePokemon.selectSkill(0);
        lightPokemon.useSkill(punchingBag);
        assertTrue(punchingBag.getHp()==9900);
        fighterPokemon.useSkill(punchingBag);
        assertTrue(punchingBag.getHp()==9800);
        waterPokemon.useSkill(psychPokemon);
        assertTrue(psychPokemon.getHp()==200);
        leafPokemon.useSkill(punchingBag);
        assertTrue(punchingBag.getHp()==9700);
        psychPokemon.useSkill(punchingBag);
        assertTrue(punchingBag.getHp()==9600);
        firePokemon.useSkill(punchingBag);
        assertTrue(punchingBag.getHp()==9500);
    }
    @Test public void testOutput(){
        assertEquals(waterPokemon.showSkills(), "1. generic, de tipo agua y realiza 100 de daño. Descripcion: XD. Requiere: \n");
        assertEquals(lightPokemon.showSkills(), "1. generic, de tipo rayo y realiza 100 de daño. Descripcion: XD. Requiere: \n");
    }
}
