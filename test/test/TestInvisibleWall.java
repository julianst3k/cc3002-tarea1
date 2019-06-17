package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFighterPokemon;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.PokemonTypes.BasicLeafPokemon;
import cc3002.tarea1.PokemonTypes.BasicWaterPokemon;
import cc3002.tarea1.Skill.BasicAttack;
import cc3002.tarea1.Skill.InvisibleWall;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestInvisibleWall {
    Pokemon attacked;
    Pokemon attacker;
    Pokemon attackedVulnerable;
    Pokemon attackedResistent;
    Pokemon attackerv2;
    Pokemon attackedNonTicked;
    Pokemon attackedNonEnoughEnergies;
    @Before public void setUp(){
        attacked = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(), 50))));
        attacker = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new BasicAttack("Basic", 20, new ArrayList<>(), "lulw"), new BasicAttack("Basic", 70, new ArrayList<>(), "lulw"), new BasicAttack("Basic", 200, new ArrayList<>(), "lulw"))));
        attackedResistent = new BasicWaterPokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(), 50))));
        attackedVulnerable = new BasicLeafPokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(), 50))));
        attackedNonEnoughEnergies = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));
        attackerv2 = new BasicFighterPokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new BasicAttack("Basic", 20, new ArrayList<>(), "lulw"), new BasicAttack("Basic", 70, new ArrayList<>(), "lulw"), new BasicAttack("Basic", 200, new ArrayList<>(), "lulw"))));


    }
    @Test public void ableToDefend(){
        attacker.selectSkill(0);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 180);
        attacker.selectSkill(1);
        attacker.useSkill(attacked);
        assertEquals(attacked.getHp(), 130); // Just lost 50 HP

    }
    @Test public void notEnoughEnergiesToDefend(){
        attacker.selectSkill(0);
        attacker.useSkill(attackedNonEnoughEnergies);
        assertEquals(attackedNonEnoughEnergies.getHp(), 180);
        attacker.selectSkill(1);
        attacker.useSkill(attackedNonEnoughEnergies);
        assertEquals(attackedNonEnoughEnergies.getHp(), 110);
    }
    @Test public void differentResist(){
        attacker.selectSkill(0);
        attacker.useSkill(attackedVulnerable);
        assertEquals(attackedVulnerable.getHp(), 160);
        attacker.selectSkill(1);
        attacker.useSkill(attackedVulnerable);
        assertEquals(attackedVulnerable.getHp(), 110);
        attackerv2.selectSkill(0);
        attackerv2.useSkill(attackedResistent);
        assertEquals(attackedResistent.getHp(), 200);
        attackerv2.selectSkill(1);
        attackerv2.useSkill(attackedResistent);
        assertEquals(attackedResistent.getHp(), 160);
        attackerv2.selectSkill(2);
        attackerv2.useSkill(attackedResistent);
        assertEquals(attackedResistent.getHp(), 110);
    }

}
