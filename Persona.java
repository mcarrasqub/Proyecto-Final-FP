
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    private String nombre;
    private int [] resp;
    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombre, int[] resp)
    {
        this.nombre = nombre;
        this.resp = resp;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Integer> getRespuestas(){
        return resp;
    }
    
    public String toString(){
        return nombre + ": " + resp.toString();
    }
}
