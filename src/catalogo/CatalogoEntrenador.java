package catalogo;

import modeloEntrenador.Entrenador;
import modeloEntrenador.InvestigacionProfesor;
import modeloEntrenador.Misty;
import modeloEntrenador.Pocion;
import modeloEntrenador.Pokeball;
import modeloEntrenador.TurboVelocidad;

public class CatalogoEntrenador {
    public static Entrenador crearPocion(){
        return new Pocion();
    }

    public static Entrenador crearPokeball(){
        return new Pokeball();
    }

    public static Entrenador crearTurboVelocidad(){
        return new TurboVelocidad();
    }

    public static Entrenador crearInvestigacionProfesor(){
        return new InvestigacionProfesor();
    }

    public  static Entrenador crearMisty(){
        return new Misty();
    }
}
