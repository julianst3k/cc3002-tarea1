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

public class TestFirePokemon {
    private Pokemon firePokemon;
    private Pokemon waterPokemon;
    private Pokemon leafPokemon;
    private ArrayList<ISkill> skillsWater;
    @Before public void setUp(){
        skillsWater = new ArrayList<>(Arrays.asList(new Skill("generic", 100, new ArrayList<IEnergia>(), "XD")));
        firePokemon = new FirePokemon("Zuko", 33, 300, skillsWater);
        leafPokemon = new LeafPokemon("Chikorita", 33, 300, skillsWater);
        waterPokemon = new WaterPokemon("Squirtle", 33, 300, skillsWater);
    }
    @Test public void testResist(){
        firePokemon.selectSkill(0); leafPokemon.selectSkill(0); waterPokemon.selectSkill(0);
        firePokemon.attack(leafPokemon); waterPokemon.attack(firePokemon);
        assertTrue(firePokemon.getHp()==100);
        assertTrue(leafPokemon.getHp()==100);
        waterPokemon.attack(leafPokemon);
        assertTrue(leafPokemon.getHp()==30);
    }
}
