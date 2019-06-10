package cc3002.tarea1;

import cc3002.tarea1.Effect.NullInstantEfect;
import cc3002.tarea1.Effect.NullPokemonEffect;

import java.util.ArrayList;
import java.util.Arrays;

public class nullSkill extends Attack {
    public nullSkill(){
        super("", 0, new ArrayList<IEnergia>(), "", new NullPokemonEffect());
    }
}
