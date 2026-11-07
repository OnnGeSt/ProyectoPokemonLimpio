package modeloEntrenador;

import juego.Jugador;

public class InvestigacionProfesor extends Soporte{
    public InvestigacionProfesor(){
        super("Investigacion del profesor");
    }

    @Override
    public boolean activar(Jugador jugador){
        if(jugador.getMazo().estaVacio()){
            return false;
        }
        jugador.descartarMano();
        for(int i=0;i<2;i++){
            jugador.robarCarta();
        }
        return true;
    }
    
}
