package test;
import static org.junit.Assert.*;

import cc3002.tarea1.Energies.FireEnergy;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PokemonTypes.FirePokemon;
import cc3002.tarea1.PokemonTypes.LeafPokemon;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Energies.LeafEnergy;
import cc3002.tarea1.Skill;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.IEnergia;
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
    private Skill elMataNachos;
    private Entrenador faker;
    @Before public void setUp(){
        Green = new ArrayList<IEnergia>(Arrays.asList(new LeafEnergy(), new FireEnergy()));
        LeafAttack = new Skill("Cures Cancer", 420, Green, "Smoke that" );
        ByronsEnergies = new ArrayList<IEnergia>(Arrays.asList(new FireEnergy(), new FireEnergy()));
        skills = new ArrayList<ISkill>(Arrays.asList(new Skill("Big Flames", 33, ByronsEnergies, "Pega")));
        skillsGreen = new ArrayList<ISkill>(Arrays.asList(LeafAttack));
        entrenador = new Entrenador(new FirePokemon("Byron", 23, 69, skills));
        elMataNachos = new Skill("Bomb", 10000, ByronsEnergies, "Kills everything");
        faker = new Entrenador(new FirePokemon("Unkillable Demon King", 666, 10000, new ArrayList<ISkill>(Arrays.asList(elMataNachos))));
        GreenDay = new LeafPokemon("Green", 420, 1000, skillsGreen);
    }
    @Test public void testInitial(){
        assertEquals(entrenador.cardInfo(entrenador.getActiva()), "El pokemon es Byron, su id es 23, Health Points = 69, y sus energias son: .");
        assertEquals(entrenador.activeSkillsInfo(), "Los ataques del Pokemon son: 1. Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: Energia de Fuego: 2. \n");
        assertEquals(entrenador.activeSelectedSkill(), "No hay ataque selecto");
    }
    @Test public void testMandarSkills(){
        entrenador.selectAttack(1);
        assertNull(entrenador.getActiva().getSelectedSkill()); // No hay suficientes energias!!
        entrenador.sacarCarta(new FireEnergy()); faker.sacarCarta(new FireEnergy());
        assertEquals(entrenador.cantidadEnergias(), 1);
        entrenador.sacarCarta(new FireEnergy()); faker.sacarCarta(new FireEnergy());
        assertEquals(entrenador.energyString(2), "Energia de Fuego" );
        entrenador.activeUseEnergy(1); faker.activeUseEnergy(1);
        assertEquals(entrenador.cantidadEnergias(), 1);
        entrenador.activeUseEnergy(1); faker.activeUseEnergy(1);
        entrenador.selectAttack(1); faker.selectAttack(1);
        assertTrue((entrenador.getActiva().enoughEnergy(0)));
        assertEquals(entrenador.getActiva().getSelectedSkill().getName(), "Big Flames");
        entrenador.sacarCarta(GreenDay);
        assertEquals(entrenador.cantidadBanca(), 1);
        assertEquals(entrenador.cardInfoBanca(1), "1. El pokemon es Green, su id es 420, Health Points = 1000, y sus energias son: .");
        entrenador.activePokemonSwap();
        assertEquals(entrenador.cardInfo(entrenador.getActiva()), "El pokemon es Green, su id es 420, Health Points = 1000, y sus energias son: .");
        faker.pokemonAttack(entrenador.getActiva());
        entrenador.deadActive();
        assertEquals(entrenador.getActiva().getName(), "Byron");
        assertEquals(entrenador.activeSelectedSkill(), "El ataque selecto es: Big Flames, de tipo fuego y realiza 33 de daño. Descripcion: Pega. Requiere: Energia de Fuego: 2. \n");
        entrenador.activePokemonSwap();;
        assertEquals(entrenador.getActiva().getName(), "Byron");
    }

}
