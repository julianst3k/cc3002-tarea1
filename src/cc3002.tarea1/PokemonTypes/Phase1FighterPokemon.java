package cc3002.tarea1.PokemonTypes;

import cc3002.tarea1.ISkill;

import java.util.ArrayList;

public class Phase1FighterPokemon extends AbstractFighterPokemon {
    public Phase1FighterPokemon(String name, int id, int healthPoints, ArrayList<ISkill> skills){
        super(name, id, healthPoints, skills);
    }
}
