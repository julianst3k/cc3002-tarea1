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

public class TestPsychPokemon {
    private Pokemon psychPokemon;
    private Pokemon psychPokemon1;
    private Pokemon fighterPokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new Skill("generic", 100, new ArrayList<IEnergia>(), "XD")));
        psychPokemon = new PsychPokemon("Zuko", 33, 300, skillsWater);
        fighterPokemon = new FighterPokemon("Chikorita", 33, 300, skillsWater);
        psychPokemon1 = new PsychPokemon("Zuko", 33, 300, skillsWater);

    }
    @Test public void testResist(){
        psychPokemon.selectSkill(0); fighterPokemon.selectSkill(0); psychPokemon1.selectSkill(0);
        psychPokemon1.attack(psychPokemon);
        assertTrue(psychPokemon.getHp()==100);
        fighterPokemon.attack(psychPokemon);
        assertTrue(psychPokemon.getHp()==30);
        psychPokemon1.attack(fighterPokemon);
        assertTrue(fighterPokemon.getHp()==100);
    }
    @Test public void testOutput(){
        assertEquals(psychPokemon.showSkills(), "1. generic, de tipo psiquico y realiza 100 de daño. Descripcion: XD. Requiere: \n");

    }
}