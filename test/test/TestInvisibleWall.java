package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

public class TestInvisibleWall {
    Pokemon attacked;
    Pokemon attacker;
    Pokemon attackedVulnerable;
    Pokemon attackedResistent;
    Pokemon attackedNonTicked;
    Pokemon attackedNonEnoughEnergies;
    @Before public void setUp(){
        attacked = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));
        attacker = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new BasicAttack("Basic", 20, new ArrayList<>(), "lulw")));
        attackedResistent = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));
        attackedVulnerable = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));
        attackedNonTicked = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));
        attackedNonEnoughEnergies = new BasicFirePokemon("Yeet", 33, 200, new ArrayList<ISkill>(Arrays.asList(new InvisibleWall(new ArrayList<IEnergia>(Arrays.asList(new FireEnergy())), 50))));


    }
}
