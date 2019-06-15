package cc3002.tarea1;

import cc3002.tarea1.PlayVisitor.PlayVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IEntrenador {
    /** Interface of trainer
     * @author Julian Solis Torrejon
     *
     */
    /** Plays a card from the set of cards
     *
     * @param index The index +1 of the card
     */
    void jugarCarta(int index);
    /** Gets a card from the deck
     */
    void sacarCarta();
    /** Gets an active
     *
     * @return A pokemon
     */
    IPokemon getActiva();
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
     * @param card A card
     * @return A string
     */
    String cardInfo(ICardPlayable card);
    /** Select some attack to be the main one
     *
     * @param index Index of the attack that i want to select
     *
     */
    void selectAttack(int index);
    /** Get the list of cards that are not played yet
     *
     * @return The array of cards
     */
    ArrayList<ICardPlayable> getMano();
    /** Get the list of 5-Pokemon
     *
     * @return An array with the list
     */
    ArrayList<IPokemon> getBanca();
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
     * @param trainer The enemy trainer
     * @return An string of it
     */
    String showEnemyField(Entrenador trainer);
    /** Gets the enemy active
     * @param trainer The trainer
     * @return His active
     */
    IPokemon enemyActive(Entrenador trainer);

    /** Gets the enemy 5-Pokemon list
     *
     * @param trainer The trainer
     * @return His pokemon that are not active
     */
    ArrayList<IPokemon> enemyBanca(Entrenador trainer);

    /** Do a string that show the entire field of battle
     *
     * @param trainer The enemy trainer
     * @return A string that show it
     */
    String showEntireField(Entrenador trainer);
    /** Accept a visitor
     * @param visitor The visitor, indeed
     */
    void accept(PlayVisitor visitor);
    /** Replace a Pokemon with another one, transferring the energies to the new one
     * @param after New pokemon that replaces the old one
     */
    void pokemonEvolve(IPokemon after);

    /** Gets the index of some Pokemon (0 if Active).
     *
     * @param poke Pokemon that will return the index
     * @return An integer that show the current position
     */
    int pokemonPlace(IPokemon poke);
    /** Set a new stadium for the game :)
     * @param card The card that will be setted
     */
    void setStadium(StadiumCard card);
}
