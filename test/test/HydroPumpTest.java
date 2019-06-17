package test;

import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.Skill.HydroPump;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class HydroPumpTest {
    private Pokemon attacker;
    private Pokemon attacked;
    @Before public void setUp(){
        attacker = new BasicFirePokemon("Attacker", 33, 100, new ArrayList<>(Arrays.asList(new HydroPump(20, new ArrayList<>(Arrays.asList(new FireEnergy())), 30))));
        attacked = new BasicFirePokemon("Attacked", 33, 1000, new ArrayList<>());
    }
    @Test public void testDmgScaling(){
        attacker.selectSkill(0);
        attacker.useSkill(attacked); //
        assertEquals(attacked.getHp(),1000);
        attacker.setEnergy(new FireEnergy());
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 980); // Debiese pegar el dmg normal
        attacker.setEnergy(new FireEnergy());
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 950); // 30
        attacker.setEnergy(new FireEnergy());
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 910); // 40
        attacker.setEnergy(new WaterEnergy());
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 860); // 50, y funciona para cualquier energia :)
        attacker.setEnergy(new FireEnergy());
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 810); // 50, este es el tope
    }
}
