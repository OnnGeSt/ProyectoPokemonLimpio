package modeloEntrenador;

import juego.Jugador;
import modeloCartas.Pokemon;
import modeloCartas.TipoEnergia;

public class Misty extends Soporte {
    public Misty(){
        super("Misty");
    }
    
    @Override 
    public boolean activar(Jugador jugador){
        Pokemon buscado = jugador.getCampo().getActivo();
        if(buscado != null && buscado.getTipo() == TipoEnergia.AGUA){
            for(int i=0;i<3;i++){
                buscado.adjuntarEnergia(TipoEnergia.AGUA);
            }
            return true;
        }
        for(Pokemon b : jugador.getCampo().getBanco()){
            if(b.getTipo() == TipoEnergia.AGUA){
                for(int i=0;i<3;i++){
                b.adjuntarEnergia(TipoEnergia.AGUA);
            }
            return true;
            }
        }
        return false;

    }
}
