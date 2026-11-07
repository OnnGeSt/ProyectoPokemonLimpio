import catalogo.MazosPredefinidos;
import juego.Consola;
import juego.Jugador;
import juego.Partida;

public class App {
    public static void main(String[] args) {
        Consola consola = new Consola();

        String nombre1 = consola.pedirNombre(1);
        int mazo1 = consola.elegirMazo(nombre1);
        Jugador jugador1 = new Jugador(nombre1,
                MazosPredefinidos.crearMazo(mazo1),
                MazosPredefinidos.energiaDeZona(mazo1));

        String nombre2 = consola.pedirNombre(2);
        int mazo2 = consola.elegirMazo(nombre2);
        Jugador jugador2 = new Jugador(nombre2,
                MazosPredefinidos.crearMazo(mazo2),
                MazosPredefinidos.energiaDeZona(mazo2));

        consola.prepararJugador(jugador1);
        consola.prepararJugador(jugador2);

        Partida partida = new Partida(jugador1, jugador2);
        consola.jugar(partida);
    }
}