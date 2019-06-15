package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestWingBuzz {
    private Controller bigController;
    private Entrenador iDoTheEffect;
    private Entrenador enemyTrainer;
    private Mazo deck;
    private Mazo seconddeck;
    private Pokemon pokemon;
    @Before public void setUp(){
        pokemon = new BasicFirePokemon("Gameun", 33, 100, new ArrayList<ISkill>(Arrays.asList(new WingBuzz(new ArrayList<>(Arrays.asList(new FireEnergy()))), new BasicAttack("Basic", 33, new ArrayList<>(Arrays.asList(new FireEnergy())), "XD"))));
        deck = new Mazo(new ArrayList<>(Arrays.asList(new FireEnergy())));
        seconddeck = new Mazo(new ArrayList<>(Arrays.asList(new FireEnergy())));
        for(int i=deck.getSize(); i<60; i++){
            deck.addCarta(new FireEnergy());
            seconddeck.addCarta(new FireEnergy());
        }
        iDoTheEffect = new Entrenador(pokemon, deck, new Premio(new ArrayList<>()));
        enemyTrainer = new Entrenador(pokemon, seconddeck, new Premio(new ArrayList<>()));
        bigController = new Controller(iDoTheEffect, enemyTrainer);
    }
    @Test public void worksAsIntended(){
        bigController.startTurn();
        bigController.selectSkill(1);
        assertEquals(iDoTheEffect.getActiva().getSelectedSkill(), null);
        bigController.useSkill();
        assertTrue(bigController.getWingBuzzPlayed()==0);
        bigController.playCard(1);
        bigController.selectSkill(1);
        bigController.useSkill();
        assertTrue(bigController.getWingBuzzPlayed()==0); // No cards to be buzzed
        bigController.endTurn();
        bigController.endTurn();
        bigController.selectCard(1);
        bigController.useSkill();
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(iDoTheEffect.getMano().size()==0); // Popeo la que seleccione
        assertTrue(enemyTrainer.getMazo().getSize()==58); //Popeo 1
    }
    @Test public void cantBePlayedTwice(){
        bigController.startTurn();
        bigController.playCard(1);
        bigController.selectSkill(1);
        bigController.useSkill();
        bigController.endTurn();
        bigController.endTurn();
        bigController.endTurn();
        bigController.endTurn();
        bigController.selectCard(1);
        bigController.useSkill();
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(iDoTheEffect.getMano().size()==1);
        bigController.useSkill();
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(iDoTheEffect.getMano().size()==1);
    }

}
