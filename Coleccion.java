import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;

/**
 * Write a description of class Afinidad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coleccion
{

    private ArrayList<Persona> personas;

    /**
     * Constructor for objects of class Afinidad
     */
    public Coleccion()    {
        personas = new ArrayList<>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void leerDatos() {
        personas.clear();
        try (Scanner sc = new Scanner(new FileReader("encuesta.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(" ");
                String nombre = partes[0];
                int[] resp = new int[5];
                for (int i = 1; i < partes.length; i++) {
                    resp[i-1] = Integer.parseInt(partes[i]);
                }
                personas.add(new Persona(nombre, resp));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado ");
        }
    }

    public void escribirDatos(Persona persona) {
        try{
         FileWriter escribir = new FileWriter("encuesta.txt", true);
         escribir.write('\n' + persona.toString());
         escribir.close();
        } catch(IOException e){
            System.out.println("Archivo no encontrado");
        }

    }
    public double match(Persona p1, Persona p2){
        int[] arrP1 = p1.getRespuestas();
        int[] arrP2 = p2.getRespuestas();
        double sumatoriaMultiplicacion = 0;
        int pitagorasP1 = 0;
        int pitagorasP2 = 0;
        for(int i = 0; i < arrP1.length; i++){
            sumatoriaMultiplicacion = sumatoriaMultiplicacion + arrP1[i] * arrP2[i];
            pitagorasP1 = pitagorasP1 + arrP1[i] * arrP1[i];
            pitagorasP2 = pitagorasP2 + arrP2[i] * arrP2[i];
        }
        double resultado = sumatoriaMultiplicacion / (Math.sqrt(pitagorasP1) * Math.sqrt(pitagorasP2));
        return resultado;
    }
    public int buscarPersona(String nombre){
        int encontrado = -1;
        for(int i = 0; i < personas.size(); i++){
            Persona personaPosi = personas.get(i);
            if((personaPosi.getNombre()).equals(nombre)){
                return i;
            }
        }
        return encontrado;
    }
    public ArrayList<Persona> getPersonas(){
        return this.personas;
    }
}
