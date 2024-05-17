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
                    break;
                case 'B':
                    
                    break;
                case 'C':
                    coleccion.escribirDatos();
                    break;
                case 'D':
                    
                    break;
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
        System.out.println("B. Recibir nuevas personas con sus respuestas");
        System.out.println("C. Escribir el conjunto de datos al archivo");
        System.out.println("D. Encontrar la persona más afín");
        System.out.println("E. Terminar");
        System.out.println();
        System.out.print("Ingrese la opción deseada en MAYÚSCULA: ");
    }
}