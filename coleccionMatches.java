import java.util.ArrayList;
/**
 * Write a description of class coleccionMatches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class coleccionMatches
{
    private ArrayList<Matches> matches;
    public coleccionMatches(){
        matches = new ArrayList<>();
    }
    
    public void agregarMatches(Matches match){
        matches.add(match);
    }
    
    public void selectionSortArraylistDescendente(){
        if(matches.isEmpty()){
            System.out.println("No hay nada que ordenar");
        }else{
            for(int i = 0; i < matches.size()-1; i++){
                int posMayor = i;
                for(int j = i+1; j < matches.size(); j++){
                    Matches matchPosMayor = matches.get(posMayor);
                    Matches matchj = matches.get(j);
                    if(matchj.getAfinidad() > matchPosMayor.getAfinidad()){
                        posMayor = j;
                    }
                }
                //"swap"
                if(i!=posMayor){
                    Matches matchaCambiar = matches.get(posMayor);
                    matches.add(i, matchaCambiar);
                    matches.remove(posMayor+1);
                }
            }
        }
    }
    
    public void imprimirMatches(){
        if(matches.isEmpty()){
            System.out.println("Está vacío");
        }
        System.out.println("El que tiene más afinidad es: " );
        Matches primero = matches.get(0);
        System.out.println("match: "+ primero.getNombres() + " con afinidad: " + primero.getAfinidad());
        System.out.println("Otras opciones: ");
        if(matches.size() < 6){
            for(int i = 1; i < matches.size(); i++){
                Matches matchPosi = matches.get(i);
                System.out.println("match: " + matchPosi.getNombres() + " - " + matchPosi.getAfinidad());
            }
        }else{
            for(int i = 1; i < 5; i++){
                Matches matchPosi = matches.get(i);
                System.out.println("match: "+ matchPosi.getNombres() + " - " + matchPosi.getAfinidad());
            } 
        }
    }
    
    public ArrayList<Matches> getMatches(){
        return this.matches;
    }
}
