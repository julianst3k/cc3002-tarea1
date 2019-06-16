package test;

import cc3002.tarea1.*;
import cc3002.tarea1.Card.Mazo;
import cc3002.tarea1.Card.Potion;
import cc3002.tarea1.Card.Premio;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.Skill.BasicAttack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class PotionTest {
    private Entrenador trainer;
    private Entrenador otherTrainer;
    private Mazo decktrainer;
    private Mazo deckOther;
    private Controller bigController;
    private Pokemon trainerPok;
    private Pokemon otherPok;
    @Before public void setUp(){
        decktrainer = new Mazo(new ArrayList<>()); decktrainer.addCarta(new Potion(2)); decktrainer.addCarta(new Potion(100));
        deckOther = new Mazo(new ArrayList<>());
        for(int i=0; i<60; i++){
            decktrainer.addCarta(new FireEnergy());
            deckOther.addCarta(new FireEnergy());
        }
        trainerPok = new BasicFirePokemon("attacked", 33, 1000, new ArrayList<>());
        otherPok = new BasicFirePokemon("attacker", 33, 1000, new ArrayList<>(Arrays.asList(new BasicAttack("lul", 30, new ArrayList<>(), "tutu"))));
        trainer = new Entrenador(trainerPok, decktrainer, new Premio(new ArrayList<>()));
        otherTrainer = new Entrenador(otherPok, deckOther, new Premio(new ArrayList<>()));

        bigController = new Controller(trainer, otherTrainer);
    }
    @Test public void play(){
        bigController.startTurn();
        bigController.endTurn();
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertEquals(trainer.getActiva().getHp(), 970);
        bigController.selectObjective(0);
        bigController.playCard(1);
        assertEquals(trainer.getActiva().getHp(), 990);
        bigController.endTurn();
        bigController.selectObjective(0);
        bigController.selectSkill(1);
        bigController.useSkill(1);
        assertEquals(trainer.getActiva().getHp(), 960);
        bigController.selectObjective(0);
        bigController.playCard(1);
        assertEquals(trainer.getActiva().getHp(), 1000);
    }
}
