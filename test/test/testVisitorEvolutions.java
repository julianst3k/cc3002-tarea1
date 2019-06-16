package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Card.Mazo;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Skill.nullSkill;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class testVisitorEvolutions {
    private Entrenador myTrainer;
    private Pokemon firstEvo;
    private Pokemon secondEvo;
    private Pokemon secondEvoNoFirst;
    private Pokemon enduranceTester;
    private Pokemon enduranceTester2;
    private Pokemon enduranceTester3;
    private  Pokemon firstEvoCopy;
    private Pokemon secondEvoCopy;
    private Entrenador secondTrainer;
    private Mazo mazo;
    private Mazo secondMazo;
    private Pokemon thirdEvo;
    EnergyCounter energy;
    EnergyCounter energy2;

    @Before public void setUp(){
        firstEvo = new BasicFirePokemon("Myth",35, 100, new ArrayList<>(Arrays.asList(new nullSkill())));
        firstEvoCopy = new BasicFirePokemon("Mythx",35, 100, new ArrayList<>(Arrays.asList(new nullSkill())));
        secondEvo = new Phase1FirePokemon("Myth Evo", 35, 200, new ArrayList<>(Arrays.asList(new nullSkill())), 35);
        thirdEvo = new Phase2FirePokemon("Myth Evo Omega", 35, 200, new ArrayList<>(Arrays.asList(new nullSkill())), 35);
        secondEvoCopy = new Phase1FirePokemon("Myth Evo Copy", 35, 200, new ArrayList<>(Arrays.asList(new nullSkill())), 35);
        secondEvoNoFirst = new Phase1FirePokemon("Beach", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())), 36);
        enduranceTester2 = new BasicLightPokemon("Myth", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        enduranceTester = new BasicPsychPokemon("Myth", 37, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        enduranceTester3 = new BasicWaterPokemon("Myth", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        mazo = new Mazo(new ArrayList<ICardPlayable>(Arrays.asList(secondEvo, new FireEnergy(), new WaterEnergy(), secondEvoNoFirst, enduranceTester, enduranceTester2, enduranceTester3, firstEvoCopy, secondEvoCopy)));
        for(int i=mazo.getSize(); i<60; i++){
            mazo.addCarta(new FireEnergy());
        }
        secondMazo = new Mazo(new ArrayList<>(Arrays.asList(secondEvo, new FireEnergy(), new WaterEnergy(), thirdEvo)));
        for(int i=secondMazo.getSize(); i<60; i++){
            secondMazo.addCarta(new FireEnergy());
        }
        myTrainer= new Entrenador(firstEvo, mazo, null);
        secondTrainer = new Entrenador(firstEvo, secondMazo, null);
        energy = myTrainer.getActiva().getEnergies();
        energy2 = secondTrainer.getActiva().getEnergies();
    }
    @Test public void getEvolved(){
        myTrainer.sacarCarta();
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.jugarCarta(1);
        assertEquals(myTrainer.getActiva(), secondEvo);
        assertEquals(myTrainer.getActiva().getEnergies(), energy);


    }
    @Test public void dontGetEvolved(){
        myTrainer.sacarCarta();
        myTrainer.sacarCarta();
        myTrainer.sacarCarta();
        myTrainer.sacarCarta();
        myTrainer.setObjective(0);
        myTrainer.jugarCarta(4);
        assertTrue(myTrainer.getMano().contains(secondEvoNoFirst));
    }
    @Test public void getEvolvedFromTheSidelines(){
        myTrainer.sacarCarta();
        myTrainer.sacarCarta(); myTrainer.setObjective(0); myTrainer.jugarCarta(2);
        myTrainer.sacarCarta(); myTrainer.setObjective(0); myTrainer.jugarCarta(2);
        myTrainer.setObjective(0);
        myTrainer.jugarCarta(1);
        myTrainer.sacarCarta(); myTrainer.sacarCarta();
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2); myTrainer.sacarCarta(); myTrainer.jugarCarta(2); myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.jugarCarta(2);
        myTrainer.sacarCarta();
        myTrainer.setObjective(4);
        myTrainer.jugarCarta(2);
        assertTrue(myTrainer.getBanca().contains(secondEvoCopy));
        assertTrue(!myTrainer.getBanca().contains(firstEvoCopy));
    }
    @Test public void getTripleEvolved(){
        secondTrainer.sacarCarta();
        secondTrainer.sacarCarta(); myTrainer.setObjective(0); secondTrainer.jugarCarta(2);
        secondTrainer.sacarCarta(); myTrainer.setObjective(0); secondTrainer.jugarCarta(2);
        secondTrainer.setObjective(0);
        secondTrainer.jugarCarta(1);
        secondTrainer.sacarCarta();
        secondTrainer.setObjective(0);
        secondTrainer.jugarCarta(1);
        assertEquals(secondTrainer.getActiva(), thirdEvo);
        assertEquals(secondTrainer.getActiva().getEnergies(), energy2);
    }

}
