import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coleccion coleccion = new Coleccion();
        Scanner scanner = new Scanner(System.in);
        
        char opcion;
        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);
            switch (opcion) {
                case 'A':
                    coleccion.leerDatos();
                    System.out.println("Los datos de su archivo se han leído y almacenado correctamente");
                
                case 'B':
                    System.out.println("ingrese el nombre de la persona a agregar");
                    String nombre = scanner.next();
                    int[] respuestas = new int[5];
                    System.out.println("Ingrese las respuestas a las preguntas (valores entre 0 y 10):");
                    System.out.println("1. ¿Qué tanto te gusta escuchar música?");
                    System.out.println("2. ¿Qué tanto te gusta estudiar?");
                    System.out.println("3. ¿Qué tanto te gusta dibujar?");
                    System.out.println("4. ¿Qué tanto te gusta ejercitarte?");
                    System.out.println("5. ¿Qué tanto te gusta dormir?");
                    for(int i=0; i<respuestas.length; i++){
                        System.out.println("respuesta " + (i+1) + ": ");
                        respuestas[i] = scanner.nextInt();
                    }
                    Persona nuevaPersona = new Persona(nombre, respuestas);
                    coleccion.agregarPersona(nuevaPersona);
                    System.out.println("Persona agregada correctamente.");
                
                case 'C':
                    coleccion.escribirDatos();
                    System.out.println("Datos escritos en el archivo.");
                    
                case 'D':
                    
                    
                case 'E':
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 'E');
    
    }
    
    static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("A. Leer el archivo con los datos");
        System.out.println("B. Recibir nueva persona con sus respuestas");
        System.out.println("C. Escribir el conjunto de datos en el archivo");
        System.out.println("D. Encontrar la persona más afín");
        System.out.println("E. Terminar");
        System.out.println();
        System.out.print("Ingrese la opción deseada en MAYÚSCULA: ");
    }
}
