package cc3002.tarea1;


import cc3002.tarea1.Effect.NullGlobalEffect;

public class NullStadiumCard extends StadiumCard {
    public NullStadiumCard(){
        super("No Name Stadium", "Do Nothing", new NullGlobalEffect());
    }
}
