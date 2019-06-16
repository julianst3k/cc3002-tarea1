package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Card.Mazo;
import cc3002.tarea1.Card.Premio;
import cc3002.tarea1.Energies.*;
import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.BasicAttack;
import cc3002.tarea1.Skill.EnergyBurn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;


public class TestEnergyBurner {
    private Controller bigController;
    private Entrenador iDoTheEffect;
    private Entrenador enemyTrainer;
    private Mazo deck;
    private Mazo seconddeck;
    private Pokemon pokemon;
    private Pokemon secondpokemon;
    private Pokemon leafpokemon;
    private Pokemon lightpokemon;
    private Pokemon psychpokemon;
    private Pokemon waterpokemon;
    private Entrenador voidTrainer;
    private Mazo voiddeck;
    @Before
    public void setUp(){
        pokemon = new BasicFirePokemon("Gameun", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>(Arrays.asList(new FireEnergy()))), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        secondpokemon = new BasicFighterPokemon("72hrs", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>(Arrays.asList(new FireEnergy()))), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        deck = new Mazo(new ArrayList<>(Arrays.asList(new FireEnergy())));
        seconddeck = new Mazo(new ArrayList<>(Arrays.asList(new FireEnergy(), new LeafEnergy(), new LightEnergy(), new PsychEnergy(), new WaterEnergy())));
        leafpokemon = new BasicLeafPokemon("72hrs", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>()), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        lightpokemon = new BasicLightPokemon("72hrs", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>()), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        psychpokemon = new BasicPsychPokemon("72hrs", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>()), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        waterpokemon = new BasicWaterPokemon("72hrs", 33, 100, new ArrayList<ISkill>(Arrays.asList(new EnergyBurn(new ArrayList<>()), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        voiddeck = new Mazo(new ArrayList<>(Arrays.asList(lightpokemon, psychpokemon, waterpokemon)));
        for(int i=deck.getSize(); i<60; i++){
            deck.addCarta(new FireEnergy());
            seconddeck.addCarta(new FireEnergy());
            voiddeck.addCarta(new FireEnergy());
        }
        iDoTheEffect = new Entrenador(pokemon, deck, new Premio(new ArrayList<>()));
        enemyTrainer = new Entrenador(secondpokemon, seconddeck, new Premio(new ArrayList<>()));
        bigController = new Controller(iDoTheEffect, enemyTrainer);
        voidTrainer = new Entrenador(leafpokemon, voiddeck, new Premio(new ArrayList<>()));
    }
    @Test
    public void testQuemaCartasDeTodoTipo(){
        bigController.selectObjective(0);
        bigController.startTurn();
        bigController.playCard(1); // iDoEffect habilita la carta
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // enemyTrainer habilita la carta
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // iDoEffect = 2 fuego si usa burn
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // enemyTrainer = 2 fighter si usa burn
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 3
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 3
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 4
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 4
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 5
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.playCard(1); // 5
        bigController.endTurn();
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertEquals(iDoTheEffect.getActiva().getEnergies().getFireEnergy(), 5);
        bigController.endTurn();
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertEquals(enemyTrainer.getActiva().getEnergies().getFighterEnergy(), 5);

    }
    @Test public void testQuemaCartasDistintosTipos(){
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1); // Aqui los 4 pokemon ya estan en el campo
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.selectAttack(1);
        voidTrainer.pokemonAttack(voidTrainer);
        assertEquals(voidTrainer.getActiva().getEnergies().getLeafEnergy(), 1);
        voidTrainer.activePokemonSwapWithIndex(1);
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.selectAttack(1);
        voidTrainer.pokemonAttack(voidTrainer);
        assertEquals(voidTrainer.getActiva().getEnergies().getLightEnergy(), 1);
        voidTrainer.activePokemonSwapWithIndex(2);
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.selectAttack(1);
        voidTrainer.pokemonAttack(voidTrainer);
        assertEquals(voidTrainer.getActiva().getEnergies().getPsychEnergy(), 1);
        voidTrainer.activePokemonSwapWithIndex(3);
        voidTrainer.sacarCarta();
        voidTrainer.setObjective(0);
        voidTrainer.jugarCarta(1);
        voidTrainer.selectAttack(1);
        voidTrainer.pokemonAttack(voidTrainer);
        assertEquals(voidTrainer.getActiva().getEnergies().getWaterEnergy(), 1);
    }

}
