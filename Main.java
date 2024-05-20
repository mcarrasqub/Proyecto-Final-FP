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
                     if((coleccion.getPersonas().size() < 2)){
                        System.out.println("No hay suficientes personas para hacer los matches");
                        continue;
                    }
                    coleccionMatches coleccionMatch = new coleccionMatches();
                    System.out.println("Elige la persona con la que se harán los matches (exactamente): ");
                    String elegido = scanner.next();
                    int posElegido = coleccion.buscarPersona(elegido);
                    if(posElegido == -1){
                        System.out.println("Esta persona no está");
                        continue;
                    }
                    for(int i = 0; i < (coleccion.getPersonas()).size(); i++){
                        Persona personai = (coleccion.getPersonas()).get(i);
                        Persona personaElegida = (coleccion.getPersonas()).get(posElegido);
                        if(posElegido != i){
                            double afinidad = coleccion.match(personaElegida, personai);
                            String nombres = personaElegida.getNombre() + " - " + personai.getNombre();
                            Matches temp =  new Matches(afinidad, nombres);
                            coleccionMatch.agregarMatches(temp);
                        }
                    }
                    coleccionMatch.selectionSortArraylistDescendente();
                    coleccionMatch.imprimirMatches();
                    continue;
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
