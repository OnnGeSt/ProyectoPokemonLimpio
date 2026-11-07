package catalogo;

import juego.Mazo;
import modeloCartas.TipoEnergia;

public class MazosPredefinidos {
    public static Mazo crearMazoAgua(){
        Mazo mazo = new Mazo();
        for(int i=0;i<2;i++){
            mazo.agregar(CatalogoPokemon.crearSquirtle());
            mazo.agregar(CatalogoPokemon.crearArticunoEx());
            mazo.agregar(CatalogoPokemon.crearMagikarp());
            mazo.agregar(CatalogoPokemon.crearSnorlax());
            mazo.agregar(CatalogoPokemon.crearJigglypuff());
            mazo.agregar(CatalogoEntrenador.crearInvestigacionProfesor());
            mazo.agregar(CatalogoEntrenador.crearMisty());
            mazo.agregar(CatalogoEntrenador.crearPocion());
            mazo.agregar(CatalogoEntrenador.crearPokeball());
            mazo.agregar(CatalogoEntrenador.crearTurboVelocidad());

        }
        return mazo;
    }

    public static Mazo crearMazoFuego(){
        Mazo mazo = new Mazo();
        for(int i=0;i<2;i++){
            mazo.agregar(CatalogoPokemon.crearCharmander());
            mazo.agregar(CatalogoPokemon.crearJigglypuff());
            mazo.agregar(CatalogoPokemon.crearSnorlax());
            mazo.agregar(CatalogoPokemon.crearZapdosEx());
            mazo.agregar(CatalogoPokemon.crearMoltresEx());
            mazo.agregar(CatalogoEntrenador.crearInvestigacionProfesor());
            mazo.agregar(CatalogoEntrenador.crearPocion());
            mazo.agregar(CatalogoEntrenador.crearMisty());
            mazo.agregar(CatalogoEntrenador.crearPokeball());
            mazo.agregar(CatalogoEntrenador.crearTurboVelocidad());
        }
        return mazo;
    }

    public static Mazo crearMazoPikachu(){
        Mazo mazo = new Mazo();
        for(int i=0;i<2;i++){
            mazo.agregar(CatalogoPokemon.crearPikachu());
            mazo.agregar(CatalogoPokemon.crearJigglypuff());
            mazo.agregar(CatalogoPokemon.crearSnorlax());
            mazo.agregar(CatalogoPokemon.crearZapdosEx());
            mazo.agregar(CatalogoPokemon.crearMoltresEx());
            mazo.agregar(CatalogoEntrenador.crearInvestigacionProfesor());
            mazo.agregar(CatalogoEntrenador.crearPokeball());
            mazo.agregar(CatalogoEntrenador.crearTurboVelocidad());
            mazo.agregar(CatalogoEntrenador.crearMisty());
            mazo.agregar(CatalogoEntrenador.crearPocion());
        }
        return mazo;
    }

    public static Mazo crearMazo(int opcion){
        switch (opcion) {
            case 1:
                return crearMazoAgua();
            case 2:
                return crearMazoFuego();
            default:
                return crearMazoPikachu();
        }
    }

    public static TipoEnergia energiaDeZona(int opcion){
        switch (opcion) {
            case 1:
                return TipoEnergia.AGUA;
            case 2:
                return TipoEnergia.FUEGO;
            default:
                return TipoEnergia.ELECTRICO;
        }
    }
}
