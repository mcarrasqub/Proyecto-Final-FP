
public class Matches
{
    private double afinidad;
    private String nombres;
    public Matches(double afinidad, String nombres){
        this.afinidad = afinidad;
        this.nombres =  nombres;
    }
    public double getAfinidad(){
        return this.afinidad;
    }
    public String getNombres(){
        return this.nombres;
    }
}
