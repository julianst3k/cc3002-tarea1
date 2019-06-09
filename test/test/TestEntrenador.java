package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Energies.FireEnergy;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.PokemonTypes.*;
import cc3002.tarea1.Energies.LeafEnergy;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEntrenador {
    private Entrenador entrenador;
    private ArrayList<IEnergia> Green;
    private Skill LeafAttack;
    private ArrayList<IEnergia> ByronsEnergies;
    private ArrayList<ISkill> skills;
    private ArrayList<ISkill> skillsGreen;
    private Pokemon GreenDay;
    private Pokemon genericGreenDay1; Pokemon genericGreenDay2; private Pokemon genericGreenDay3; Pokemon genericGreenDay4; private Pokemon genericGreenDay5; Pokemon genericGreenDay6;
    private Skill elMataNachos;
    private Entrenador faker;
    private Mazo mazo;
    private Premio premio;
    private ArrayList<ICardPlayable> newMazo;
    @Before public void setUp(){
        Green = new ArrayList<IEnergia>(Arrays.asList(new LeafEnergy(), new FireEnergy()));
        LeafAttack = new Skill("Cures Cancer", 420, Green, "Smoke that" );
        ByronsEnergies = new ArrayList<IEnergia>(Arrays.asList(new FireEnergy(), new FireEnergy()));
        skills = new ArrayList<ISkill>(Arrays.asList(new Skill("Big Flames", 33, ByronsEnergies, "Pega")));
        skillsGreen = new ArrayList<ISkill>(Arrays.asList(LeafAttack));
        elMataNachos = new Skill("Bomb", 10000, ByronsEnergies, "Kills everything");
        GreenDay = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay1 = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay2 = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay3 = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay4 = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay5 = new BasicLeafPokemon("Green", 420, 1000, skillsGreen);
        genericGreenDay6 = new BasicLeafPokemon("Misunderstood Green", 420, 1000, skillsGreen);
        newMazo = new ArrayList<>(Arrays.asList(new FireEnergy(), new FireEnergy(), GreenDay, genericGreenDay1, genericGreenDay2, genericGreenDay3, genericGreenDay4, genericGreenDay5, genericGreenDay6));
        mazo = new Mazo(newMazo);
        for(int i=mazo.getSize(); i<60; i++){
            mazo.addCarta(new FireEnergy());
        }
        entrenador = new Entrenador(new BasicFirePokemon("Byron", 23, 69, skills), mazo, premio);
        faker = new Entrenador(new BasicFirePokemon("Unkillable Demon King", 666, 10000, new ArrayList<ISkill>(Arrays.asList(elMataNachos))), mazo, premio);


    }
    @Test public void testInitial() {
        assertEquals(entrenador.cardInfo(entrenador.getActiva()), "Nombre: Byron, ID: 23, Health Points: 69, Energias: \n1. Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: FIRE: 2. \n");
        assertEquals(entrenador.activeSkillsInfo(), "Los ataques del Pokemon son: 1. Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: FIRE: 2. \n");
        assertEquals(entrenador.activeSelectedSkill(), "No hay ataque selecto");
    }
    @Test public void testJugarCartas() {
        entrenador.selectAttack(1);
        assertNull(entrenador.getActiva().getSelectedSkill()); // No hay suficientes energias!!
        entrenador.sacarCarta(new FireEnergy());
        faker.sacarCarta(new FireEnergy());
        assertEquals(entrenador.cantidadMano(), 1);
        entrenador.sacarCarta(new FireEnergy());
        faker.sacarCarta(new FireEnergy());
        assertEquals(entrenador.showMano(), "1. Energia de Fuego.\n2. Energia de Fuego.\n");
        assertEquals(entrenador.cardInfoMano(2), "Energia de Fuego");
        entrenador.jugarCarta(1);
        faker.jugarCarta(1);
        assertEquals(entrenador.showMano(), "1. Energia de Fuego.\n");
        entrenador.jugarCarta(1);
        faker.jugarCarta(1);
        entrenador.selectAttack(1);
        faker.selectAttack(1);
        System.out.println(entrenador.showMano());
        assertTrue((entrenador.getActiva().enoughEnergy(0)));
        assertEquals(entrenador.getActiva().getSelectedSkill().getName(), "Big Flames");
        entrenador.sacarCarta(GreenDay);
        entrenador.jugarCarta(1);
        assertEquals(entrenador.cantidadBanca(), 1);
        assertEquals(entrenador.cardInfoBanca(1), "1. Nombre: Green, ID: 420, Health Points: 1000, Energias: \n1. Cures Cancer, de tipo hierba y realiza 420 de daño. Descripcion: Smoke that. Requiere: FIRE: 1. LEAF: 1. \n");
        assertEquals(faker.showEnemyField(entrenador), "Activo: Nombre: Byron, ID: 23, Health Points: 69, Energias: FIRE: 2. \n1. Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: FIRE: 2. \nBanca: \n1. Nombre: Green, ID: 420, Health Points: 1000, Energias: \n1. Cures Cancer, de tipo hierba y realiza 420 de daño. Descripcion: Smoke that. Requiere: FIRE: 1. LEAF: 1. \n");
        entrenador.activePokemonSwap();
        assertEquals(entrenador.cardInfo(entrenador.getActiva()), "Nombre: Green, ID: 420, Health Points: 1000, Energias: \n1. Cures Cancer, de tipo hierba y realiza 420 de daño. Descripcion: Smoke that. Requiere: FIRE: 1. LEAF: 1. \n");
        faker.pokemonAttack(entrenador);
        assertEquals(entrenador.getActiva().getName(), "Byron");
        assertEquals(entrenador.activeSelectedSkill(), "El ataque selecto es: Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: FIRE: 2. \n");
        entrenador.activePokemonSwap();
        assertEquals(entrenador.getActiva().getName(), "Byron");
        assertEquals(entrenador.showEntireField(faker), "Tu campo: \nActivo: Nombre: Byron, ID: 23, Health Points: 69, Energias: FIRE: 2. \n1. Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: FIRE: 2. \nBanca: \nCampo enemigo: \nActivo: Nombre: Unkillable Demon King, ID: 666, Health Points: 10000, Energias: FIRE: 2. \n1. Bomb, de tipo fuego y realiza 10000 de daño. Descripcion: Kills everything. Requiere: FIRE: 2. \nBanca: \n" );

    }
    @Test public void testAddingWayTooMuch(){
        entrenador.sacarCarta(genericGreenDay1); entrenador.jugarCarta(1);
        entrenador.sacarCarta(genericGreenDay2); entrenador.jugarCarta(1);
        entrenador.sacarCarta(genericGreenDay3); entrenador.jugarCarta(1);
        entrenador.sacarCarta(genericGreenDay4); entrenador.jugarCarta(1);
        entrenador.sacarCarta(genericGreenDay5); entrenador.jugarCarta(1);
        assertEquals(entrenador.cantidadBanca(), 5);
        entrenador.sacarCarta(genericGreenDay6); entrenador.jugarCarta(1);
        assertEquals(entrenador.cardInfoMano(1), "Nombre: Misunderstood Green, ID: 420, Health Points: 1000, Energias: \n1. Cures Cancer, de tipo hierba y realiza 420 de daño. Descripcion: Smoke that. Requiere: FIRE: 1. LEAF: 1. \n");
        assertEquals(entrenador.cardInfoMano(2), "");
        assertEquals(faker.enemyBanca(entrenador), entrenador.getBanca());

    }
}
