package test;

import cc3002.tarea1.Card.Mazo;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.LeafEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

public class ControllerSimulateATurnTest {
    private Mazo deckTrainer;
    private Mazo deckEnemy;
    private Entrenador entrenador;
    private Entrenador enemyTrainer;
    private Pokemon pokemonUno;
    private Pokemon pokemonDos;
    private Pokemon pokemonTres;
    private Pokemon pokemonUnoEvo;
    private Pokemon pokemonUnoSecondEvo;
    private Pokemon pokemonCuatro;
    private Pokemon pokemonCinco;
    private Pokemon pokemon6ix;
    private Pokemon enemyPokemonUno;
    private Pokemon enemyPokemonDos;
    private Pokemon enemyPokemonTres;
    private Pokemon enemyPokemonCuatro;
    private Pokemon enemyPokemonCinco;
    private ISkill wingBuzz;
    private ISkill invisibleWall;
    private ISkill invisibleWall2;
    private ISkill hydroPump;
    private ISkill energyBurn;
    @Before public void setUp(){
        wingBuzz = new WingBuzz(new ArrayList<>(Arrays.asList(new LeafEnergy())));
        energyBurn = new EnergyBurn(new ArrayList<>(Arrays.asList(new LeafEnergy())));
        invisibleWall = new InvisibleWall(new ArrayList<>(Arrays.asList(new LeafEnergy())), 50);
        invisibleWall2 = new InvisibleWall(new ArrayList<>(Arrays.asList(new LeafEnergy(), new LeafEnergy(), new LeafEnergy())), 10);
        hydroPump = new HydroPump(30, new ArrayList<>(Arrays.asList(new LeafEnergy(), new FireEnergy(), new FireEnergy())));
        pokemonUno = new BasicFirePokemon("Into", 50, 200, new ArrayList<>(Arrays.asList(new BasicAttack("Omega", 30, new ArrayList<>(Arrays.asList(new FireEnergy())), "yeap"))));
        pokemonDos = new BasicLeafPokemon("Seal", 50, 200, new ArrayList<>(Arrays.asList(wingBuzz)));
        pokemonTres = new BasicPsychPokemon("Alaka", 70, 2000, new ArrayList<>(Arrays.asList(invisibleWall)));
        pokemonCuatro = new BasicWaterPokemon("Leon", 80, 50, new ArrayList<>(Arrays.asList(hydroPump)));
        pokemonCinco = new BasicFighterPokemon("Dinosaurio", 80, 100, new ArrayList<>(Arrays.asList(new BasicAttack("Tito", 100, new ArrayList<>(Arrays.asList(new FireEnergy())), "yeap"))));
        pokemon6ix = new BasicPsychPokemon("Sion", 156, 200, new ArrayList<>(Arrays.asList(energyBurn, new BasicAttack("Yeet", 200, new ArrayList<>(Arrays.asList(new LeafEnergy())), "yoot"))));
        pokemonUnoEvo = new Phase1FirePokemon("The", 51, 400, new ArrayList<>(Arrays.asList(new BasicAttack("Omega", 50, new ArrayList<>(Arrays.asList(new FireEnergy())), "yeap"))), 50);
        pokemonUnoSecondEvo = new Phase2FirePokemon("Deep Time", 52, 800, new ArrayList<>(Arrays.asList(new BasicAttack("Omega", 50, new ArrayList<>(Arrays.asList(new FireEnergy())), "yeap"))), 52);
        enemyPokemonUno = new BasicLeafPokemon("Forest", 420, 1000, new ArrayList<>(Arrays.asList(invisibleWall2)));
        enemyPokemonDos = new BasicWaterPokemon("Waves", 300, 400, new ArrayList<>(Arrays.asList(new BasicAttack("Wave", 50, new ArrayList<>(Arrays.asList(new WaterEnergy())), "xD"))));
    }
}
