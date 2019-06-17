package test;

import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.BasicFighterPokemon;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class AttackWithoutEnergies {
    private Pokemon attacker;
    private Pokemon attacked;
    @Before public void setUp(){
        attacked = new BasicFighterPokemon("xD", 33, 300, new ArrayList<>());
        attacker = new BasicFighterPokemon("xD", 33, 330, new ArrayList<>(Arrays.asList(new BasicAttack("hola", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "xd"))));
    }
    @Test public void attackWithoutEnergy(){
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 300);
    }
}
