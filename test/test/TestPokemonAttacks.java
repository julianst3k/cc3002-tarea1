package test;
import static org.junit.Assert.*;
import cc3002.tarea1.Energies.FighterEnergy;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.*;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Energies.LeafEnergy;
import cc3002.tarea1.Skill;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.IEnergia;
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
        skillsWater = new ArrayList<>(Arrays.asList(new Skill("generic", 100, new ArrayList<IEnergia>(), "XD")));
        lightPokemon = new LightPokemon("Azula", 33, 300, skillsWater);
        fighterPokemon = new FighterPokemon("Iron Man dies", 33, 300, skillsWater);
        waterPokemon = new WaterPokemon("Squirtle", 33, 300, skillsWater);
        punchingBag = new FirePokemon("Kanojedo", 400, 10000, skillsWater);
        leafPokemon = new LeafPokemon("Eco", 400, 300, skillsWater);
        psychPokemon = new PsychPokemon("Pedro Engel", 300, 300, skillsWater);
        firePokemon = new FirePokemon("My Mixtape", 300, 300, skillsWater);
    }
    @Test public void testResist(){
        lightPokemon.selectSkill(0); fighterPokemon.selectSkill(0); waterPokemon.selectSkill(0);
        leafPokemon.selectSkill(0); psychPokemon.selectSkill(0); firePokemon.selectSkill(0);
        lightPokemon.attack(punchingBag);
        assertTrue(punchingBag.getHp()==9900);
        fighterPokemon.attack(punchingBag);
        assertTrue(punchingBag.getHp()==9800);
        waterPokemon.attack(psychPokemon);
        assertTrue(psychPokemon.getHp()==200);
        leafPokemon.attack(punchingBag);
        assertTrue(punchingBag.getHp()==9700);
        psychPokemon.attack(punchingBag);
        assertTrue(punchingBag.getHp()==9600);
        firePokemon.attack(punchingBag);
        assertTrue(punchingBag.getHp()==9500);
    }
    @Test public void testOutput(){
        assertEquals(waterPokemon.showSkills(), "1. generic, de tipo agua y realiza 100 de daño. Descripcion: XD. Requiere: \n");
        assertEquals(lightPokemon.showSkills(), "1. generic, de tipo rayo y realiza 100 de daño. Descripcion: XD. Requiere: \n");
    }
}
