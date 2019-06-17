package test;

import cc3002.tarea1.Mazo;
import cc3002.tarea1.Premio;
import cc3002.tarea1.Card.RareCandy;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.PokemonTypes.BasicFirePokemon;
import cc3002.tarea1.PokemonTypes.Phase1FirePokemon;
import cc3002.tarea1.PokemonTypes.Phase2FirePokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class RareCandyTest {
    private RareCandy rare;
    private Pokemon preEvo;
    private Pokemon evo;
    private Pokemon evoPhaseTwo;
    private Entrenador trainer;
    private Mazo deck;
    @Before public void setUp(){
        rare = new RareCandy();
        preEvo = new BasicFirePokemon("xD", 30, 300, new ArrayList<>());
        evo = new Phase1FirePokemon("xD Phase 1", 30, 200, new ArrayList<>());
        evoPhaseTwo = new Phase2FirePokemon("xD Phase 2", 30, 300, new ArrayList<>());
        deck = new Mazo(new ArrayList<>());
        for(int i=0; i<60; i++){
            deck.addCarta(new FireEnergy());
        }
        trainer = new Entrenador(preEvo, deck, new Premio(new ArrayList<>(Arrays.asList())));
    }
    @Test
    public void evolucionaDeUnaAFase2(){
        trainer.getMano().add(rare);
        trainer.getMano().add(evoPhaseTwo);
        trainer.getMano().add(evo);
        trainer.jugarCarta(1);
        assertEquals(trainer.getMano().size(), 3);
        trainer.setObjective(0);
        trainer.setSelectedCard(1);
        trainer.jugarCarta(3);
        assertEquals(trainer.getActiva().getName(), "xD Phase 2");
    }
    @Test
    public void evolucionaAFase1(){
        trainer.getMano().add(rare);
        trainer.getMano().add(evo);
        trainer.jugarCarta(1);
        assertEquals(trainer.getMano().size(), 2);
        trainer.setObjective(0);
        trainer.setSelectedCard(1);
        trainer.jugarCarta(2);
        assertEquals(trainer.getActiva().getName(), "xD Phase 1");
    }
}
