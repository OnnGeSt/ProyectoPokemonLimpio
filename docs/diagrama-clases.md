classDiagram
    direction TB

    class TipoEnergia {
        <<enumeration>>
        ELECTRICO
        FUEGO
        AGUA
        PSIQUICO
        INCOLORO
        +debilidad(tipo) boolean
    }

    class Ataque {
        -String nombre
        -List~TipoEnergia~ costo
        -int danoBase
        +getNombre() String
        +getCosto() List
        +getDanoBase() int
    }

    class Carta {
        <<abstract>>
        -String nombre
        +getNombre() String
        +descripcion()* String
    }

    class Pokemon {
        <<abstract>>
        -TipoEnergia tipo
        -int psMax
        -int psActual
        -int costoRetirada
        -List~Ataque~ ataques
        -List~TipoEnergia~ energias
        +getTipo() TipoEnergia
        +getPsMax() int
        +getPsActual() int
        +getCostoRetirada() int
        +getAtaques() List
        +getEnergias() List
        +recibirDano(dano)
        +curar(cantidad)
        +adjuntarEnergia(energia)
        +descartarEnergias(cantidad) boolean
        +puedeUsar(ataque) boolean
        +estaDerrotado() boolean
        +getPuntosPremio()* int
        +descripcion() String
    }

    class PokemonNormal {
        +getPuntosPremio() int
    }

    class PokemonEx {
        +getPuntosPremio() int
    }

    class Activable {
        <<interface>>
        +activar(jugador) boolean
    }

    class Entrenador {
        <<abstract>>
        +esCartaSupp()* boolean
        +descripcion() String
    }

    class Objeto {
        <<abstract>>
        +esCartaSupp() boolean
    }

    class Soporte {
        <<abstract>>
        +esCartaSupp() boolean
    }

    class Pocion {
        +activar(jugador) boolean
    }
    class Pokeball {
        +activar(jugador) boolean
    }
    class TurboVelocidad {
        +activar(jugador) boolean
    }
    class InvestigacionProfesor {
        +activar(jugador) boolean
    }
    class Misty {
        +activar(jugador) boolean
    }

    class Mazo {
        -List~Carta~ cartas
        +agregar(carta)
        +agregarCarta(carta)
        +robar() Carta
        +robarCarta(carta) Carta
        +esValido() boolean
        +estaVacio() boolean
        +barajar()
        +buscarPokemonesBasicos() Carta
        +devolver(cartas)
    }

    class Campo {
        -Pokemon activo
        -List~Pokemon~ banco
        +ponerActivo(pokemon)
        +ponerEnBanco(pokemon) boolean
        +hayPokemonJugando() boolean
        +quitarActivo()
        +promoverActivo(pokemon) boolean
        +intercambiarActivoBanco(pokemon) boolean
        +getActivo() Pokemon
        +getBanco() List
    }

    class Jugador {
        -String nombre
        -Mazo mazo
        -List~Carta~ mano
        -Campo campo
        -int puntosPremio
        -TipoEnergia energiaZona
        -boolean energiaDisponible
        -int reduccionRetirada
        -boolean suppUsado
        -boolean ataqueRealizado
        +getNombre() String
        +getMazo() Mazo
        +getMano() List
        +getCampo() Campo
        +getPuntosPremio() int
        +getEnergiaZona() TipoEnergia
        +isEnergiaDisponible() boolean
        +robarCarta() boolean
        -manoTienePokemon() boolean
        +repartirIniciales()
        +recibirEnergia()
        +adjuntarEnergia(pokemon) boolean
        +colocarEnBanco(pokemon) boolean
        +colocarEnActivo(pokemon) boolean
        +retirarActivo(reemplazo) boolean
        +jugarEntrenador(carta) boolean
        +sumarPuntosPremio(puntos)
        +reiniciarTurno()
        +haAtacado() boolean
        +marcarAtaque()
        +agregarAMano(carta)
        +descartarMano()
        +reducirRetirada(reduccion)
    }

    class Partida {
        -List~Jugador~ jugadores
        -int turnoActual
        -int numeroTurno
        -Jugador ganador
        +getNumeroTurno() int
        +getGanador() Jugador
        +getJugadorActual() Jugador
        +getRival() Jugador
        +atacar(ataque) boolean
        +iniciarTurno() boolean
        +terminarTurno()
        +revisarVictoria() boolean
        -calcularDano(atacante, defensor, ataque) int
    }

    class Consola {
        -Scanner scanner
        +pedirNombre(n) String
        +leerOpcion(min, max) int
        +elegirMazo(nombre) int
        +barraVida(psActual, psMax) String
        +simbolo(tipo) String
        +energiasDe(pokemon) String
        +mostrarCampo(jugador, titulo)
        +mostrarTablero(actual, rival, turno)
        +mostrarMenu() int
        +elegirCarta(jugador) Carta
        +elegirPokemon(lista) Pokemon
        +elegirAtaque(pokemon) Ataque
        +pokemonesEnMano(jugador) List
        +prepararJugador(jugador)
        -elegirReemplazo(jugador)
        +jugar(partida)
    }

    class CatalogoPokemon {
        +crearPikachu() Pokemon
        +crearCharmander() Pokemon
        +crearSquirtle() Pokemon
        +crearJigglypuff() Pokemon
        +crearMagikarp() Pokemon
        +crearSnorlax() Pokemon
        +crearMewtwoEx() Pokemon
        +crearZapdosEx() Pokemon
        +crearMoltresEx() Pokemon
        +crearArticunoEx() Pokemon
    }

    class CatalogoEntrenador {
        +crearPocion() Entrenador
        +crearPokeball() Entrenador
        +crearTurboVelocidad() Entrenador
        +crearInvestigacionProfesor() Entrenador
        +crearMisty() Entrenador
    }

    class MazosPredefinidos {
        +crearMazoAgua() Mazo
        +crearMazoFuego() Mazo
        +crearMazoPikachu() Mazo
        +crearMazo(opcion) Mazo
        +energiaDeZona(opcion) TipoEnergia
    }

    %% Herencia
    Carta <|-- Pokemon
    Carta <|-- Entrenador
    Pokemon <|-- PokemonNormal
    Pokemon <|-- PokemonEx
    Entrenador <|-- Objeto
    Entrenador <|-- Soporte
    Objeto <|-- Pocion
    Objeto <|-- Pokeball
    Objeto <|-- TurboVelocidad
    Soporte <|-- InvestigacionProfesor
    Soporte <|-- Misty

    %% Interfaz
    Activable <|.. Entrenador

    %% Composicion y agregacion
    Pokemon "1" *-- "1..2" Ataque : ataques
    Pokemon --> TipoEnergia : tipo y energias
    Ataque --> TipoEnergia : costo
    Mazo "1" o-- "0..20" Carta
    Campo "1" o-- "0..1" Pokemon : activo
    Campo "1" o-- "0..2" Pokemon : banco
    Jugador "1" *-- "1" Campo
    Jugador "1" o-- "1" Mazo
    Jugador "1" o-- "*" Carta : mano
    Jugador --> TipoEnergia : energiaZona
    Partida "1" o-- "2" Jugador

    %% Dependencias de uso
    Activable ..> Jugador : activar(jugador)
    Consola ..> Partida
    Consola ..> Jugador
    CatalogoPokemon ..> Pokemon : crea
    CatalogoEntrenador ..> Entrenador : crea
    MazosPredefinidos ..> Mazo : crea
    MazosPredefinidos ..> CatalogoPokemon
    MazosPredefinidos ..> CatalogoEntrenador
