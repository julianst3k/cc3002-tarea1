package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Mazo;
import cc3002.tarea1.Premio;
import cc3002.tarea1.Card.ProfessorJuniper;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class ProfessorJuniperTest {
    private Entrenador entrenador;
    private Entrenador othertrainer;
    private Pokemon pokemon;
    private Controller controller;
    private Mazo mazo;
    private Mazo mazotwo;
    @Before public void setUp(){
        mazo = new Mazo(new ArrayList<>(Arrays.asList()));
        mazotwo = new Mazo(new ArrayList<>());
        mazo.addCarta(new ProfessorJuniper());
        mazo.addCarta(new ProfessorJuniper());
        for(int i=0; i<60; i++){
            mazo.addCarta(new FireEnergy());
            mazotwo.addCarta(new FireEnergy());
        }
        pokemon = new BasicFirePokemon("xx", 33, 333, new ArrayList<>());
        entrenador = new Entrenador(pokemon, mazo, new Premio(new ArrayList<>()));
        othertrainer = new Entrenador(pokemon, mazotwo, new Premio(new ArrayList<>()));
        controller = new Controller(entrenador,othertrainer);
    } // Funciona como debiese
    @Test public void testProfessorJuniperFunctionality(){
        controller.startTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn();
        assertEquals(entrenador.getMano().size(), 5);
        assertEquals(entrenador.getMazo().getSize(), 55);
        controller.playCard(1);
        assertEquals(entrenador.getMano().size(), 7);
        assertEquals(entrenador.getMazo().getSize(), 48);
        assertEquals(entrenador.getPila().getSize(), 4);
    } // Funcionara hasta sin 7 cartas en el mazo (Se asumio)
    @Test public void testProfessorJuniperFunctionalityWithout7CardsOnDeck(){
        controller.startTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn(); controller.endTurn();
        assertEquals(entrenador.getMano().size(), 5);
        entrenador.getMazo().popNCards(50);
        assertEquals(entrenador.getMazo().getSize(), 5);
        controller.playCard(1);
        assertEquals(entrenador.getMano().size(), 5);
        assertEquals(entrenador.getMazo().getSize(), 0);
        assertEquals(entrenador.getPila().getSize(), 4);
    }
}
