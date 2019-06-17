package test;

import cc3002.tarea1.Card.FrozenCity;
import cc3002.tarea1.Mazo;
import cc3002.tarea1.Premio;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class FrozenCityTest {
    private Mazo deck;
    private Mazo secondDeck;
    private Pokemon pokemon;
    private Pokemon pokemonSecond;
    private Entrenador entrenador;
    private Entrenador entrenadorSecond;
    private Pokemon pokemonTwo;
    private Controller controller;
    @Before
    public void setUp(){
        pokemonTwo = new BasicFirePokemon("LULW", 33, 25, new ArrayList<>());
        deck = new Mazo(new ArrayList<>(Arrays.asList(new FrozenCity(3), new FireEnergy())));
        secondDeck = new Mazo(new ArrayList<>(Arrays.asList(pokemonTwo)));
        for(int i=0; i<60; i++){
            deck.addCarta(new FireEnergy());
            secondDeck.addCarta(new FireEnergy());
        }
        pokemon = new BasicFirePokemon("LULW", 33, 50, new ArrayList<>());
        pokemonSecond = new BasicFirePokemon("WidePeepo", 33, 10000, new ArrayList<>(Arrays.asList(new BasicAttack("XD", 15, new ArrayList<>(), ",,,"))));
        entrenador = new Entrenador(pokemon, deck, new Premio(new ArrayList<>()));
        entrenadorSecond = new Entrenador(pokemonSecond, secondDeck, new Premio(new ArrayList<>()));
        controller = new Controller(entrenador, entrenadorSecond);

    }
    @Test // Funciona como debiese, purga el pokemon activo
    public void testFrozenCityToActive(){
        controller.startTurn();
        controller.endTurn();
        controller.useSkill(1);
        assertEquals(entrenador.getActiva().getHp(), 35);
        controller.selectObjective(0);
        controller.playCard(2);
        assertEquals(entrenador.getActiva().getHp(), 35); // No le pega
        controller.endTurn();
        controller.endTurn();
        controller.playCard(1);
        controller.selectObjective(0);
        controller.playCard(1);
        assertEquals(entrenador.getActiva().getHp(), 5);
        controller.endTurn();
        controller.endTurn();
        controller.selectObjective(0);
        controller.playCard(1);
        assertTrue(!controller.getStatus()); // lo purga, no hay carta en la banca, gg
    }
    @Test // Funciona como debiese, purga el pokemon en la banca tambien
    public void testFrozenCItyToBanca(){
        controller.startTurn();
        controller.endTurn();
        controller.playCard(1);
        controller.endTurn();
        controller.playCard(1);
        controller.endTurn();
        assertEquals(entrenadorSecond.getBanca().size(), 1);
        controller.selectObjective(1);
        controller.playCard(1);
        assertEquals(entrenadorSecond.getBanca().size(), 0);

    }
}
