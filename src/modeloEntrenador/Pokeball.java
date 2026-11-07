package modeloEntrenador;

import juego.Jugador;
import modeloCartas.Carta;

public class Pokeball extends Objeto {
    public Pokeball(){
        super("Pokeball");
    }

    @Override 
    public boolean activar(Jugador jugador){
        Carta carta = jugador.getMazo().buscarPokemonesBasicos();
        if(carta == null){
            return false;
        }
        jugador.agregarAMano(carta);
        return true;
    }
    
}
