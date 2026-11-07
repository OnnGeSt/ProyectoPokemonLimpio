package modeloEntrenador;

import juego.Jugador;

public class TurboVelocidad extends Objeto{
    public TurboVelocidad(){
        super("Turbo Velocidad");
    }

    @Override 
    public boolean activar(Jugador jugador){
        if(!jugador.getCampo().hayPokemonJugando()){
            return false;
        }
        jugador.reducirRetirada(1);
        return true;
    }
    
}
