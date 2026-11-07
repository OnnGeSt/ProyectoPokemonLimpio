package catalogo;

import java.util.List;

import modeloCartas.Ataque;
import modeloCartas.Pokemon;
import modeloCartas.PokemonEx;
import modeloCartas.PokemonNormal;
import modeloCartas.TipoEnergia;

public class CatalogoPokemon {

    public static Pokemon crearPikachu(){
        Ataque mordisco = new Ataque("Mordisco", List.of(TipoEnergia.ELECTRICO), 20);
        return new PokemonNormal("Pikachu", TipoEnergia.ELECTRICO, 60, 1, List.of(mordisco));
    }

    public static Pokemon crearCharmander(){
        Ataque ascuas = new Ataque("Ascuas", List.of(TipoEnergia.FUEGO), 30);
        return new PokemonNormal("Charmander", TipoEnergia.FUEGO, 60, 2, List.of(ascuas));
    }

    public static Pokemon crearSquirtle(){
        Ataque placaje = new Ataque("Placaje", List.of(TipoEnergia.AGUA), 20);
        return new PokemonNormal("Squirtle", TipoEnergia.AGUA, 60, 2, List.of(placaje));
    }

    public static Pokemon crearJigglypuff(){
        Ataque golpe = new Ataque("Golpe", List.of(TipoEnergia.INCOLORO), 20);
        return new PokemonNormal("Jigglypuff", TipoEnergia.INCOLORO, 70, 2, List.of(golpe));
    }

    public static Pokemon crearMagikarp(){
        Ataque chapoteo = new Ataque("Chapoteo", List.of(TipoEnergia.AGUA), 10);
        return new PokemonNormal("Magikarp", TipoEnergia.AGUA, 30, 2, List.of(chapoteo));
    }

    public static Pokemon crearSnorlax(){
        Ataque golpeCuerpo = new Ataque("Golpe Cuerpo", List.of(TipoEnergia.INCOLORO, TipoEnergia.INCOLORO, TipoEnergia.INCOLORO), 100);
        return new PokemonNormal("Snorlax", TipoEnergia.INCOLORO, 150, 3, List.of(golpeCuerpo));
    }

    public static Pokemon crearMewtwoEx(){
        Ataque ataquePsiquico = new Ataque("Ataque Psiquico", List.of(TipoEnergia.PSIQUICO, TipoEnergia.PSIQUICO), 50);
        Ataque psicorrayo = new Ataque("Psicorrayo", List.of(TipoEnergia.PSIQUICO,TipoEnergia.PSIQUICO,TipoEnergia.PSIQUICO),
         150);
         return new PokemonEx("Mewtwo Ex", TipoEnergia.PSIQUICO, 150, 3, List.of(ataquePsiquico, psicorrayo));
    }

    public static Pokemon crearZapdosEx(){
        Ataque picotazo = new Ataque("Picotazo", List.of(TipoEnergia.INCOLORO), 30);
        Ataque tormentaElectrica = new Ataque("Tormenta Electrica", List.of(TipoEnergia.ELECTRICO, TipoEnergia.ELECTRICO, TipoEnergia.ELECTRICO),
         100);
        return new PokemonEx("Zapdos Ex", TipoEnergia.ELECTRICO, 130, 3, List.of(picotazo, tormentaElectrica));
    }

    public static Pokemon crearMoltresEx(){
        Ataque aleteo = new Ataque("Aleteo", List.of(TipoEnergia.INCOLORO), 30);
        Ataque danzaInfernal = new Ataque("Danza Infernal", List.of(TipoEnergia.FUEGO, TipoEnergia.FUEGO, TipoEnergia.FUEGO),
         70);
        return new PokemonEx("Moltres Ex", TipoEnergia.FUEGO, 130, 3, List.of(aleteo, danzaInfernal));
    }

    public static Pokemon crearArticunoEx(){
        Ataque vientoHelado = new Ataque("Viento Helado", List.of(TipoEnergia.AGUA), 30);
        Ataque ventisca = new Ataque("Ventisca", List.of(TipoEnergia.AGUA, TipoEnergia.AGUA, TipoEnergia.AGUA),
         100);
        return new PokemonEx("Articuno Ex", TipoEnergia.AGUA, 130, 3, List.of(vientoHelado, ventisca));
    }
}
