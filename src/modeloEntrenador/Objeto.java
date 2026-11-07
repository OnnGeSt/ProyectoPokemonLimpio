package modeloEntrenador;

public abstract class Objeto extends Entrenador {
    public Objeto(String nombre){
        super(nombre);
    }

    @Override 
    public boolean esCartaSupp(){
        return false;
    }
    
}
