package cc3002.tarea1;

public class Moneda {
    /** Creates a coin, it is used for certain methods. But it is currently unused
     * @author  Julian Solis Torrejon
     */
    /** Creates the coin
     *
     */
    public Moneda(){

    }

    /** Flips a coin
     *
     * @return Cara o Sello dependiendo del valor del random
     */
    public String getResult(){
        double val = Math.random();
        if(val<0.5)
            return "Sello";
        else{
            return "Cara";
        }
    }
}
