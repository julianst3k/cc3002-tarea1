package test;
import static org.junit.Assert.*;

import cc3002.tarea1.Energies.FighterEnergy;
import cc3002.tarea1.Energies.FireEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.LeafPokemon;
import cc3002.tarea1.PokemonTypes.LightPokemon;
import cc3002.tarea1.PokemonTypes.FighterPokemon;
import org.junit.Before;
import org.junit.Test;
import cc3002.tarea1.Entrenador;
import cc3002.tarea1.PokemonTypes.PsychPokemon;
import cc3002.tarea1.Pokemon;
import cc3002.tarea1.Energies.LeafEnergy;
import cc3002.tarea1.Skill;
import cc3002.tarea1.ISkill;
import cc3002.tarea1.IEnergia;
import java.util.ArrayList;
import java.util.Arrays;

public class TestFighterPokemon {
    private FighterPokemon fighterOne;
    private Skill skillToUse;
    private Skill fighterSkill1;
    private Skill fighterSkill2;
    private Skill fighterSkill3;
    private Skill fighterSkill4;
    private Skill fighterSkill5;
    private ArrayList<ISkill> fighterSkills;
    private ArrayList<IEnergia> energiaFighter;
    private ArrayList<IEnergia> energiaFighter2;
    private ArrayList<IEnergia> energiaFighter3;
    private PsychPokemon psychOne;
    private LeafPokemon leafOne;
    private LightPokemon lightOne;
    @Before public void setUp(){
        energiaFighter = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new WaterEnergy()));
        energiaFighter2 = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new FighterEnergy(), new WaterEnergy()));
        energiaFighter3 = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new FighterEnergy(), new WaterEnergy(), new WaterEnergy()));
        fighterSkill1= new Skill("Slap", 45, energiaFighter, "Slapping");
        fighterSkill2 = new Skill("Big Slap", 60, energiaFighter2, "More Slapping");
        fighterSkill3 = new Skill("XXXTentaslap", 100, energiaFighter3, "Slap powered by mysoginia");
        fighterSkill4 = new Skill("Hug", 30, new ArrayList<IEnergia>(), "Do love");
        fighterSkill5 = new Skill("Dab", 420, energiaFighter3, "Dab");
        fighterSkills = new ArrayList<>(Arrays.asList(fighterSkill1, fighterSkill2, fighterSkill3, fighterSkill4, fighterSkill5));
        fighterOne = new FighterPokemon("Clout", 100, 1000, fighterSkills);
        skillToUse = new Skill("Generic Skill", 100, new ArrayList<IEnergia>(), ":)");
        psychOne = new PsychPokemon("Alakazam", 65, 100, new ArrayList<ISkill>(Arrays.asList(skillToUse)));
        leafOne = new LeafPokemon("VapeGod", 101, 100, new ArrayList<ISkill>(Arrays.asList(skillToUse)));
        lightOne = new LightPokemon("Screwed", 100, 60, new ArrayList<>());
    }
    @Test public void initialConditions(){
        assertEquals(fighterOne.getName(), "Clout");
        assertEquals(fighterOne.showSkills(), "1. Slap, de tipo lucha y realiza 45 de daño. Descripcion: Slapping. Requiere: FIGHTER: 1. WATER: 1. \n2. Big Slap, de tipo lucha y realiza 60 de daño. Descripcion: More Slapping. Requiere: FIGHTER: 2. WATER: 1. \n3. XXXTentaslap, de tipo lucha y realiza 100 de daño. Descripcion: Slap powered by mysoginia. Requiere: FIGHTER: 2. WATER: 2. \n4. Hug, de tipo lucha y realiza 30 de daño. Descripcion: Do love. Requiere: \n");
        assertFalse(fighterOne.enoughEnergy(4));
        fighterOne.selectSkill(4);
        assertNull(fighterOne.getSelectedSkill());

        assertFalse(fighterOne.enoughEnergy(0));
        assertTrue(fighterOne.enoughEnergy(3));
    }
    @Test public void fighterFighting(){
        fighterOne.attack(psychOne);
        assertTrue(psychOne.getHp()==100);
        psychOne.selectSkill(0); psychOne.attack(fighterOne);
        assertTrue(fighterOne.getHp()==800);
        leafOne.selectSkill(0); leafOne.attack(fighterOne);
        assertTrue(fighterOne.getHp()==600);
        fighterOne.selectSkill(3);
        fighterOne.attack(lightOne);
        assertTrue(lightOne.isDed());
        fighterOne.attack(psychOne);
        assertTrue(psychOne.getHp()==100);
        psychOne.addAttack(fighterSkill3);
        assertEquals(psychOne.showSkill(1), "XXXTentaslap, de tipo psiquico y realiza 100 de daño. Descripcion: Slap powered by mysoginia. Requiere: FIGHTER: 2. WATER: 2. \n");
        fighterOne.deleteAttack(4);
        assertEquals(fighterOne.showSkills(), "1. Slap, de tipo lucha y realiza 45 de daño. Descripcion: Slapping. Requiere: FIGHTER: 1. WATER: 1. \n2. Big Slap, de tipo lucha y realiza 60 de daño. Descripcion: More Slapping. Requiere: FIGHTER: 2. WATER: 1. \n3. XXXTentaslap, de tipo lucha y realiza 100 de daño. Descripcion: Slap powered by mysoginia. Requiere: FIGHTER: 2. WATER: 2. \n");
    }

}
