import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

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
                int [] resp = new int[5];
                for (int i = 1; i < partes.length; i++) {
                    resp[i-1] =Integer.parseInt(partes[i]);
                }
                personas.add(new Persona(nombre, resp));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado ");
        }
    }

    public void escribirDatos() {
        File archivo = new File("encuesta.txt");
        try { 
            FileWriter escribir = new FileWriter(archivo);
            for(int i = 0; i < personas.size(); i++){
                escribir.write(personas.get(i).toString());
                escribir.write('\n');
            }
            escribir.close();
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }

    }
}
