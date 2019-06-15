package cc3002.tarea1;

import cc3002.tarea1.ControlVisitor.ControlVisitor;
import cc3002.tarea1.Effect.WingBuzzEffect;

import java.util.ArrayList;

public class WingBuzz extends Skill {
    public WingBuzz(ArrayList<IEnergia> costo){
        super("Wing Buzz", costo, "Una vez por turno, si  ́este Pokemon es el activo, puedes descartar una carta de tu mano. Si lo haces, descarta la carta superior del mazo de tu oponente", new WingBuzzEffect());
    }
}
