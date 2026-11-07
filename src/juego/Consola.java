package juego;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import modeloCartas.Ataque;
import modeloCartas.Carta;
import modeloCartas.Pokemon;
import modeloCartas.TipoEnergia;
import modeloEntrenador.Entrenador;

public class Consola {
    private Scanner scanner = new Scanner(System.in);

    public String pedirNombre(int numeroJugador){
        System.out.print("Seleccione el nombre del entrenador " + numeroJugador + ": ");
        String nombre = scanner.nextLine().trim();
        while (nombre.isEmpty()) {
            System.out.print("El nombre del entrenador no puede estar vacio. Intenta de nuevo: ");
            nombre = scanner.nextLine().trim();
        }
        return nombre;
    }

    public int leerOpcion(int minimo, int maximo){
        while (true) {
            System.out.print("Elige una opcion de " + minimo + " hasta " + maximo + ": ");
            String texto = scanner.nextLine().trim();
            try{
                int opcion = Integer.parseInt(texto);
                if(opcion >= minimo && opcion <= maximo){
                    return opcion;
                }
                System.out.println("Debe ser una opcion valida.");
            }catch(NumberFormatException e){
                System.out.println("Escribe un numero, no una letra.");
            }
        }
    }

    public String barraVida(int psActual, int psMax){
        int llenas = (psActual * 10) / psMax;
        String barra = "";
        if(psActual > 0 && llenas == 0){
            llenas = 1;
        }
        for(int i=0;i<10;i++){
            if(i<llenas){
                barra += "█";
            }else{
                barra += "░";
            }
        }
        return barra;
    }

    public String simbolo(TipoEnergia tipo){
        switch (tipo) {
            case ELECTRICO:
                return "[E]";
            case FUEGO:
                return "[F]";
            case AGUA:
                return "[A]";
            case PSIQUICO:
                return "[P]";
            case INCOLORO:
                return "[*]";
            default:
                return "?";
        }
    }

    public String energiasDe(Pokemon pokemon){
        String energia = "";
        for(TipoEnergia a : pokemon.getEnergias()){
            energia += simbolo(a);
        }
        if(energia.isEmpty()){
            return "-";
        }
        return energia;
    }

    public void mostrarCampo(Jugador jugador, String titulo){
        Pokemon activo = jugador.getCampo().getActivo();
        if(activo == null){
            System.out.println(titulo + " " +jugador.getNombre());
            System.out.println("[Activo] -");
        }else{
            System.out.println(titulo + " " + jugador.getNombre() + " PS: " + barraVida(activo.getPsActual(), activo.getPsMax()) + " "
                                + activo.getPsActual() + "/" + activo.getPsMax());
            System.out.println("[Activo] " + activo.getNombre() + " Energía adjunta: " + energiasDe(activo));
        }
        String banco = "";
        for(Pokemon p : jugador.getCampo().getBanco()){
            banco += p.getNombre() + ": " + p.getPsActual() + " PS ";
        }
        if(banco.isEmpty()){
            banco =  "-";
        }
        System.out.println("[Banco] " + banco);
        System.out.println("Puntos de premio propios: " + jugador.getPuntosPremio() + "/3");
    }

    public void mostrarTablero(Jugador actual, Jugador rival, int numTurno){
        String linea = "===================================================";
        System.out.println(linea);
        System.out.println("Turno " + numTurno + " — " + actual.getNombre());
        System.out.println(linea);
        mostrarCampo(rival, "Rival");

        System.out.println();

        mostrarCampo(actual, "TU CAMPO");
        String estado;
        if(actual.isEnergiaDisponible()){
            estado = "(Disponible)";
        }else{
            estado = "(Usada)";
        }
        System.out.println("Zona de energia: " + simbolo(actual.getEnergiaZona()) + estado);
        
        System.out.println();

        System.out.println("Tu mano: " + actual.getMano().size() + " cartas:");
        List<Carta> mano = actual.getMano();
        for(int i=0;i<actual.getMano().size();i++){
            System.out.println((i+1) + "." + mano.get(i).getNombre());
        }
        System.out.println(linea);
    }

    public int mostrarMenu(){
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Adjuntar energia de zona");
        System.out.println("2. Jugar carta de entrenador");
        System.out.println("3. Colocar Pokemon en Banco");
        System.out.println("4. Retirar Pokemon activo");
        System.out.println("5. Atacar");
        System.out.println("6. Pasar turno");
        return leerOpcion(1, 6);
    }

    public Carta elegirCarta(Jugador jugador){
        List<Carta> mano = jugador.getMano();
        if(mano.isEmpty()){
            System.out.println("No tienes cartas en la mano.");
            return null;
        }
        System.out.println("0. cancelar");
        for(int i=0;i<mano.size();i++){
            System.out.println((i+1) + "." + mano.get(i).getNombre());
        }
        int opc = leerOpcion(0 , mano.size());
        if(opc == 0){
            return null;
        }
        return mano.get(opc-1);
    }

    public Pokemon elegirPokemon(List<Pokemon> opc){
        if(opc.isEmpty()){
            return null;
        }
        System.out.println("0. cancelar");
        for(int i=0; i<opc.size();i++){
            Pokemon p = opc.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + "(" + p.getPsActual() + "/" + p.getPsMax() + " PS)");
        }
        int opc1 = leerOpcion(0, opc.size());
        if(opc1 == 0){
            return null;
        }
        return opc.get(opc1 - 1);
    }

    public Ataque elegirAtaque(Pokemon pokemon){
        List<Ataque> ataque = pokemon.getAtaques();
        System.out.println("0. cancelar");
        for(int i=0;i<ataque.size();i++){
            Ataque p = ataque.get(i);
            String costo = "";
            for(TipoEnergia e : p.getCosto()){
                costo += simbolo(e);
            } 
            System.out.println((i+1) + ". " + p.getNombre() + ": " +p.getDanoBase() + " daño (" + costo + ")" );
        }
        int opc = leerOpcion(0, ataque.size());
        if(opc == 0){
            return null;
        }
        return ataque.get(opc - 1);
    }

    public List<Pokemon> pokemonesEnMano(Jugador jugador){
        List<Pokemon> pokemones = new ArrayList<>();
        for(Carta c :jugador.getMano()){
            if(c instanceof Pokemon){
                pokemones.add((Pokemon) c);
            }
        }
        return pokemones;
    }

    public void prepararJugador(Jugador jugador){
        jugador.repartirIniciales();
        List<Pokemon> pokemones = pokemonesEnMano(jugador);
        int opc;
            System.out.println("Elige tu pokemon activo:");
            for(int i=0;i<pokemones.size();i++){
                System.out.println((i + 1) + ". " + pokemones.get(i).getNombre() + ", tipo: " + pokemones.get(i).getTipo());
            }
            opc = leerOpcion(1, pokemones.size());
        jugador.colocarEnActivo(pokemones.get(opc - 1));
        System.out.println("El pokemon " + jugador.getCampo().getActivo().getNombre() + " ha sido activado");
        for(int i=0;i<2;i++){
            List<Pokemon> disponibles = pokemonesEnMano(jugador);
            if(disponibles.isEmpty()){
                break;
            }
            System.out.println("¿Quieres agregar un pokemon al banco? (" + (i+1) + "/2)");
            Pokemon elegido = elegirPokemon(disponibles);
            if(elegido == null){
                break;
            }
            jugador.colocarEnBanco(elegido);
        }
    }
    
    private void elegirReemplazo(Jugador jugador){
    if (jugador.getCampo().getActivo() == null) {
        Pokemon reemplazo = null;
        while (reemplazo == null) {
            System.out.println(jugador.getNombre() + ", elige quién sube al activo:");
            reemplazo = elegirPokemon(jugador.getCampo().getBanco());
        }
        jugador.getCampo().promoverActivo(reemplazo);
    }
}

    public void jugar(Partida partida){
        while (partida.getGanador() == null) {
            if (!partida.iniciarTurno()) {
                break;
            }

            boolean turnoTerminado = false;
            while (!turnoTerminado) {
                Jugador actual = partida.getJugadorActual();
                Jugador rival = partida.getRival();
                mostrarTablero(actual, rival, partida.getNumeroTurno());
                int opc = mostrarMenu();
                switch (opc) {
                    case 1:
                        Pokemon activoEnergia = actual.getCampo().getActivo();
                        if (activoEnergia == null || !actual.adjuntarEnergia(activoEnergia)) {
                            System.out.println("No se pudo adjuntar la energía.");
                        }
                        break;
                    case 2:
                        Carta carta = elegirCarta(actual);
                        if(carta instanceof Entrenador){
                            if(!actual.jugarEntrenador((Entrenador) carta)){
                                System.out.println("No se pudo jugar la carta");
                            }
                        }else if(carta != null){
                            System.out.println("Esa carta no es de entrenador");
                        }
                        break;
                    case 3:
                        Pokemon paraBanco = elegirPokemon(pokemonesEnMano(actual));
                        if (paraBanco != null && !actual.colocarEnBanco(paraBanco)) {
                            System.out.println("No se pudo colocar en el banco.");
                        }
                        break;
                    case 4:
                        Pokemon nuevoActivo = elegirPokemon(actual.getCampo().getBanco());
                        if (nuevoActivo != null && !actual.retirarActivo(nuevoActivo)) {
                            System.out.println("No se pudo retirar (energías insuficientes o banco vacío).");
                        }
                        break;
                    case 5:
                        Pokemon activo = actual.getCampo().getActivo();
                        if (activo == null) {
                            System.out.println("No tienes Pokémon activo.");
                            break;  
                        }
                        Ataque ataque = elegirAtaque(activo);
                        if (ataque != null) {
                            if (partida.atacar(ataque)) {
                                if (!partida.revisarVictoria()) {
                                    elegirReemplazo(rival);
                                }
                                turnoTerminado = true;   // atacar termina el turno
                            } else {
                                System.out.println("No se pudo atacar.");
                            }
                        }
                        break;
                    case 6:
                        turnoTerminado = true;
                        break;
                    default:
                        System.out.println("Elija una opcion valida.");
                        break;
                }
                if (partida.revisarVictoria()) {
                    turnoTerminado = true;
                }
            }
            if (partida.getGanador() == null) {
                partida.terminarTurno();
            }
        }
        if (partida.getGanador() != null) {
            System.out.println("¡Ganó " + partida.getGanador().getNombre() + "!");
        }
    }

    public int elegirMazo(String nombre){
        System.out.println(nombre + ", elige tu mazo:");
        System.out.println("1. Mazo Agua");
        System.out.println("2. Mazo Fuego");
        System.out.println("3. Mazo Pikachu");
        return leerOpcion(1, 3);
    }

}
