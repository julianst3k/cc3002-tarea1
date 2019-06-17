package test;

import cc3002.tarea1.Card.AttachObjectCard;
import cc3002.tarea1.Card.Mazo;
import cc3002.tarea1.Card.Premio;
import cc3002.tarea1.Controller;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.PsychEnergy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class AttachObjectGetAttached {
    private AttachObjectCard card;
    private Entrenador trainer;
    private Controller controller;
    private Pokemon poke;
    private Mazo deck;
    private AttachObjectCard secondCard;
    @Before public void setUp(){
        card = new AttachObjectCard("Uno", "No hace nada");
        secondCard = new AttachObjectCard("Dos", "No hace nada");
        deck = new Mazo(new ArrayList<>(Arrays.asList(card, secondCard)));
        for(int i=0; i<60; i++){
            deck.addCarta(new PsychEnergy());
        }
        poke = new BasicFirePokemon("xD",33,33, new ArrayList<>());
        poke.setEnergy(new PsychEnergy());
        trainer = new Entrenador(poke, deck, new Premio(new ArrayList<>()));
        controller = new Controller(trainer, trainer);
        controller.startTurn();
        controller.endTurn();
        controller.endTurn();
    }
    @Test
    public void testCanBeAttachedOnceAndJustOnce(){
        controller.selectObjective(0); // selecciona al pokemon
        controller.playCard(1); // juega el objeto
        assertEquals(poke.getActualObject().getName(), "Uno");
        controller.selectObjective(0);
        controller.playCard(1);
        assertEquals(poke.getActualObject().getName(), "Uno");

    }

}
