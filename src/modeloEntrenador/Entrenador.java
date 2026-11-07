package modeloEntrenador;

import modeloCartas.Carta;

public abstract class Entrenador extends Carta implements Activable {
    public Entrenador(String nombre){
        super(nombre);
    }

    @Override 
    public String descripcion(){
        return "Carta de tipo Entrenador: " + getNombre();
    }
    
    public abstract boolean esCartaSupp();

}
