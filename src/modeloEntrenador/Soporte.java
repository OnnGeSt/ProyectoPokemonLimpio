package modeloEntrenador;

public abstract class Soporte extends Entrenador{
    public Soporte(String nombre){
        super(nombre);
    }

    @Override 
    public boolean esCartaSupp(){
        return true;
    }
    
}
