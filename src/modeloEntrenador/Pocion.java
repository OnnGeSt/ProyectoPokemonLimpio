package modeloEntrenador;

import juego.Jugador;
import modeloCartas.Pokemon;

public class Pocion extends Objeto {
    
    public Pocion(){
        super("Pocion");
    }

    @Override 
    public boolean activar(Jugador jugador){
        Pokemon activo = jugador.getCampo().getActivo();
        if(activo == null){
            return false;
        }
        activo.curar(20);
        return true;
    }
}