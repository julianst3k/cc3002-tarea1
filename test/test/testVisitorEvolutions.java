package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.FighterEnergy;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Energies.LeafEnergy;

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
    private Mazo mazo;
    EnergyCounter energy;

    @Before public void setUp(){
        firstEvo = new BasicFirePokemon("Myth",35, 100, new ArrayList<>(Arrays.asList(new nullSkill())));
        firstEvoCopy = new BasicFirePokemon("Myth",35, 100, new ArrayList<>(Arrays.asList(new nullSkill())));
        secondEvo = new Phase1FirePokemon("Myth Evo", 35, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        secondEvoCopy = new Phase1FirePokemon("Myth Evo", 35, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        secondEvoNoFirst = new Phase1FirePokemon("Beach", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        enduranceTester2 = new BasicFirePokemon("Myth", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        enduranceTester = new BasicFirePokemon("Myth", 37, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        enduranceTester3 = new BasicFirePokemon("Myth", 36, 200, new ArrayList<>(Arrays.asList(new nullSkill())));
        mazo = new Mazo(new ArrayList<ICardPlayable>(Arrays.asList(secondEvo, new FireEnergy(), new WaterEnergy(), secondEvoNoFirst, enduranceTester, enduranceTester2, enduranceTester3, firstEvoCopy, secondEvoCopy)));
        for(int i=mazo.getSize(); i<60; i++){
            mazo.addCarta(new FireEnergy());
        }
        myTrainer= new Entrenador(firstEvo, mazo, null);
        energy = myTrainer.getActiva().getEnergies();

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
        myTrainer.jugarCarta(4);
        assertTrue(myTrainer.getMano().contains(secondEvoNoFirst));
    }
    @Test public void getEvolvedFromTheSidelines(){
        myTrainer.sacarCarta();
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.jugarCarta(1);
        myTrainer.sacarCarta(); myTrainer.sacarCarta();
        myTrainer.sacarCarta(); myTrainer.jugarCarta(2); myTrainer.sacarCarta(); myTrainer.jugarCarta(2); myTrainer.sacarCarta(); myTrainer.jugarCarta(2);
        myTrainer.jugarCarta(2);
        myTrainer.sacarCarta();
        myTrainer.jugarCarta(2);
        assertTrue(myTrainer.getBanca().contains(secondEvoCopy));
        assertTrue(!myTrainer.getBanca().contains(firstEvoCopy));
    }

}
