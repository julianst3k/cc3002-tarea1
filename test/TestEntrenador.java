package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class TestEntrenador {
    private Entrenador entrenador;
    @Before public void setUp(){
        entrenador = new Entrenador(new PokemonFuego());
    }
    @Test public void testInitial(){ // Inicialmente tenemos un pokemon activo, y 0 en la banca, esto el jugador ha de tener
        // siempre uno activo?
        assertNotNull(entrenador.getActiva()); // No nulo
        assertNotNull(entrenador.cardInfo(entrenador.getActiva()));
        assertNotNull(entrenador.activeSkillsInfo()); // No nulo
    }
    @Test public void testMandarSkills(){
        assertNotNull(entrenador.selectAttack(1));
        assertTrue(entrenador.sacarCarta(new EnergiaPlanta()).cantidadEnergias()==1);
        assertTrue(entrenador.sacarCarta(new PokemonPlanta()).cantidadBanca()==1);
        assertNotNull(entrenador.cardInfoBanca(0));
        assertNotNull(entrenador.activeUseEnergy(0).getActive().Energy()); // No le habiamos puesto nada antes
    }
    @Test public void testActiveSwap(){
        Pokemon oldActive = entrenador.getActive();
        assertEquals(entrenador.activePokemonSwap(), oldActive);
    }
}
