package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Mazo;
import cc3002.tarea1.Premio;
import cc3002.tarea1.Skill.WingBuzz;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.Skill.BasicAttack;
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
    // En este test se muestra que funciona como debiese funcionar, o sea, si no le das una carta objetivo, no hace nada, si no hay energias, no hace nada, y si se cumple que haya
    // energias, entonces hace lo neceesario
    @Test public void worksAsIntended(){
        bigController.startTurn();
        bigController.selectSkill(1);
        assertEquals(iDoTheEffect.getActiva().getSelectedSkill(), null);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==0);
        bigController.selectObjective(0);
        bigController.playCard(1);
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==0); // No cards to be buzzed
        bigController.endTurn();
        bigController.endTurn();
        assertEquals(enemyTrainer.getMazo().getSize(), 59); // Mazo antes de que se active la skill
        bigController.selectCard(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(iDoTheEffect.getMano().size()==0); // Popeo la que seleccione
        assertEquals(enemyTrainer.getMazo().getSize(),58); //Popeo 1
        assertEquals(enemyTrainer.getPila().getSize(), 1); // se añadio a la pila
    }
    // Si el enemigo no tiene cartas, igual funciona. Esto se asumio
    @Test public void noMazoEnemy(){
        enemyTrainer.getMazo().popNCards(60);
        bigController.startTurn();
        bigController.selectSkill(1);
        assertEquals(iDoTheEffect.getActiva().getSelectedSkill(), null);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==0);
        bigController.selectObjective(0);
        bigController.playCard(1);
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==0); // No cards to be buzzed
        bigController.endTurn();
        bigController.endTurn();
        assertEquals(enemyTrainer.getMazo().getSize(), 0);
        bigController.selectCard(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(iDoTheEffect.getMano().size()==0); // Popeo la que seleccione
        assertEquals(enemyTrainer.getMazo().getSize(),0); //Popeo 1

    }
    // No se puede jugar dos veces el mismo turno
    @Test public void cantBePlayedTwice(){
        bigController.startTurn();
        bigController.selectObjective(0);
        bigController.playCard(1);
        bigController.selectSkill(1);
        bigController.useSkill(1);
        bigController.endTurn();
        bigController.endTurn();
        bigController.endTurn();
        bigController.endTurn();
        assertTrue(bigController.getWingBuzzPlayed()==0);
        assertTrue(bigController.getMano().size()==2);
        bigController.selectCard(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(bigController.getMano().size()==1);
        bigController.selectCard(1);
        bigController.useSkill(1);
        assertTrue(bigController.getWingBuzzPlayed()==1);
        assertTrue(bigController.getMano().size()==1);
    }

}
