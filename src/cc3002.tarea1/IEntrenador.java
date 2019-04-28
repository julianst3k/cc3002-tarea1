package cc3002.tarea1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IEntrenador {
    /** Interface of trainer
     * @author Julian Solis Torrejon
     *
     */
    /** Plays a card from the set of cards
     *
     * @param A The index +1 of the card
     */
    void jugarCarta(int A);
    /** Gets a card from somewhere
     *
     * @param A A card
     */
    void sacarCarta(ICard A);
    /** Gets an active
     *
     * @return A pokemon
     */
    Pokemon getActiva();
    /** Swap the active pokemon. This is used when the active pokemon is dead or when he just wants to
     * swap it.
     *
     */
    void activePokemonSwap();
    /** If the pokemon is dead, then the pokemon is swapped off
     *
     */
    void deadActive();
    /** Show the info of the card
     *
     * @param A A card
     * @return A string
     */
    String cardInfo(ICard A);
    /** Select some attack to be the main one
     *
     * @param A Index of the attack that i want to select
     *
     */
    void selectAttack(int A);
    /** Get the list of cards that are not played yet
     *
     * @return The array of cards
     */
    ArrayList<ICard> getMano();
    /** Get the list of 5-Pokemon
     *
     * @return An array with the list
     */
    ArrayList<Pokemon> getBanca();
    /** The active pokemon attacks the enemy's pokemon
     *
     * @param A A trainer
     */
    void pokemonAttack(Entrenador A);
    /** Trainer's pokemon is attacked
     *
     */
    void getAttacked();

    /** Show the active pokemon of the enemy
     * @param A The enemy trainer
     * @return An string of it
     */
    String showEnemyField(Entrenador A);
    /** Gets the enemy active
     * @param A The trainer
     * @return His active
     */
    Pokemon enemyActive(Entrenador A);

    /** Gets the enemy 5-Pokemon list
     *
     * @param A The trainer
     * @return His pokemon that are not active
     */
    ArrayList<Pokemon> enemyBanca(Entrenador A);

    /** Do a string that show the entire field of battle
     *
     * @param A The enemy trainer
     * @return A string that show it
     */
    String showEntireField(Entrenador A);

}
