package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Mazo;
import cc3002.tarea1.Card.PokemonPark;
import cc3002.tarea1.Premio;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;


public class PokemonParkTest {
    private Mazo deck;
    private Mazo secondDeck;
    private Pokemon pokemon;
    private Pokemon pokemonSecond;
    private Entrenador entrenador;
    private Entrenador entrenadorSecond;
    private Controller controller;
    @Before
    public void setUp(){
        deck = new Mazo(new ArrayList<>(Arrays.asList(new PokemonPark(), new FireEnergy())));
        secondDeck = new Mazo(new ArrayList<>());
        for(int i=0; i<60; i++){
            deck.addCarta(new FireEnergy());
            secondDeck.addCarta(new FireEnergy());
        }
        pokemon = new BasicFirePokemon("LULW", 33, 1000, new ArrayList<>());
        pokemonSecond = new BasicFirePokemon("WidePeepo", 33, 10000, new ArrayList<>(Arrays.asList(new BasicAttack("XD", 15, new ArrayList<>(), ",,,"))));
        entrenador = new Entrenador(pokemon, deck, new Premio(new ArrayList<>()));
        entrenadorSecond = new Entrenador(pokemonSecond, secondDeck, new Premio(new ArrayList<>()));
        controller = new Controller(entrenador, entrenadorSecond);
    }
    @Test // Funciona como debiese. No hay sobre cura.
    public void testPokemonPark(){
        controller.startTurn();
        controller.endTurn();
        controller.useSkill(1);
        assertEquals(entrenador.getActiva().getHp(), 985);
        controller.selectObjective(0);
        controller.playCard(2);
        assertEquals(entrenador.getActiva().getHp(), 985); // No lo cura
        controller.endTurn();
        controller.endTurn();
        controller.playCard(1);
        controller.selectObjective(0);
        controller.playCard(1);
        assertEquals(entrenador.getActiva().getHp(), 995);
        controller.endTurn();
        controller.endTurn();
        controller.selectObjective(0);
        controller.playCard(1);
        assertEquals(entrenador.getActiva().getHp(), 1000);


    }
}
