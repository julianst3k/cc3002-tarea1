package test;
import static org.junit.Assert.*;

import cc3002.tarea1.*;
import cc3002.tarea1.Effect.InstantEffect;
import cc3002.tarea1.Effect.NullInstantEfect;
import cc3002.tarea1.Effect.NullPokemonEffect;
import cc3002.tarea1.Effect.PokemonEffect;
import cc3002.tarea1.Energies.FighterEnergy;
import cc3002.tarea1.Energies.WaterEnergy;
import cc3002.tarea1.PokemonTypes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestFighterPokemon {
    private AbstractFighterPokemon fighterOne;
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
    private AbstractPsychPokemon psychOne;
    private AbstractLeafPokemon leafOne;
    private AbstractLightPokemon lightOne;
    @Before public void setUp(){
        energiaFighter = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new WaterEnergy()));
        energiaFighter2 = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new FighterEnergy(), new WaterEnergy()));
        energiaFighter3 = new ArrayList<IEnergia>(Arrays.asList(new FighterEnergy(), new FighterEnergy(), new WaterEnergy(), new WaterEnergy()));
        fighterSkill1= new BasicAttack("Slap", 45, energiaFighter, "Slapping");
        fighterSkill2 = new BasicAttack("Big Slap", 60, energiaFighter2, "More Slapping");
        fighterSkill3 = new BasicAttack("XXXTentaslap", 100, energiaFighter3, "Slap powered by mysoginia");
        fighterSkill4 = new BasicAttack("Hug", 30, new ArrayList<IEnergia>(), "Do love");
        fighterSkill5 = new BasicAttack("Dab", 420, energiaFighter3, "Dab");
        fighterSkills = new ArrayList<>(Arrays.asList(fighterSkill1, fighterSkill2, fighterSkill3, fighterSkill4, fighterSkill5));
        fighterOne = new BasicFighterPokemon("Clout", 100, 1000, fighterSkills);
        skillToUse = new BasicAttack("Generic Skill", 100, new ArrayList<IEnergia>(), ":)");
        psychOne = new BasicPsychPokemon("Alakazam", 65, 100, new ArrayList<ISkill>(Arrays.asList(skillToUse)));
        leafOne = new BasicLeafPokemon("VapeGod", 101, 100, new ArrayList<ISkill>(Arrays.asList(skillToUse)));
        lightOne = new BasicLightPokemon("Screwed", 100, 60, new ArrayList<>());
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
        fighterOne.useSkill(psychOne);
        assertTrue(psychOne.getHp()==100);
        psychOne.selectSkill(0); psychOne.useSkill(fighterOne);
        assertTrue(fighterOne.getHp()==800);
        leafOne.selectSkill(0); leafOne.useSkill(fighterOne);
        assertTrue(fighterOne.getHp()==600);
        fighterOne.selectSkill(3);
        fighterOne.useSkill(lightOne);
        assertTrue(lightOne.isDed());
        fighterOne.useSkill(psychOne);
        assertTrue(psychOne.getHp()==100);
        psychOne.addAttack(fighterSkill3);
        assertEquals(psychOne.showSkill(1), "XXXTentaslap, de tipo psiquico y realiza 100 de daño. Descripcion: Slap powered by mysoginia. Requiere: FIGHTER: 2. WATER: 2. \n");
        fighterOne.deleteAttack(4);
        assertEquals(fighterOne.showSkills(), "1. Slap, de tipo lucha y realiza 45 de daño. Descripcion: Slapping. Requiere: FIGHTER: 1. WATER: 1. \n2. Big Slap, de tipo lucha y realiza 60 de daño. Descripcion: More Slapping. Requiere: FIGHTER: 2. WATER: 1. \n3. XXXTentaslap, de tipo lucha y realiza 100 de daño. Descripcion: Slap powered by mysoginia. Requiere: FIGHTER: 2. WATER: 2. \n");
    }

}
