package juego;

import java.util.ArrayList;
import java.util.List;

import modeloCartas.Ataque;
import modeloCartas.Pokemon;

public class Partida {
    private List<Jugador> jugadores = new ArrayList<>();
    private int turnoActual;
    private int numeroTurno;
    private Jugador ganador;

    public Partida(Jugador jugador1, Jugador jugador2){
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        this.turnoActual = 0;
        this.numeroTurno = 1;

    }
    public int getNumeroTurno(){
        return numeroTurno;
    }

    public Jugador getGanador(){
        return ganador;
    }

    public Jugador getJugadorActual(){
        return jugadores.get(turnoActual);
    }

    public Jugador getRival(){
        return jugadores.get(1-turnoActual);
    }

    private int calcularDano(Pokemon atacante, Pokemon defensor, Ataque ataque){
        int dano = ataque.getDanoBase();
        if(defensor.getTipo().debilidad(atacante.getTipo())){
            dano += 20;
        }
        return dano;
    }
    
        public boolean atacar(Ataque ataque){
        Jugador atacante = getJugadorActual();
        Jugador rival = getRival();
        Pokemon activoAtacante = atacante.getCampo().getActivo();
        Pokemon rivalActivo = rival.getCampo().getActivo();

        if(numeroTurno == 1){
            return false;
        }
        if(activoAtacante == null || rivalActivo == null){
            return false;
        }
        if(atacante.haAtacado()){
            return false;
        }
        if(!activoAtacante.puedeUsar(ataque)){
            return false;
        }
        int dano = calcularDano(activoAtacante, rivalActivo, ataque);
        rivalActivo.recibirDano(dano);
        atacante.marcarAtaque();
        if(rivalActivo.estaDerrotado()){
            atacante.sumarPuntosPremio(rivalActivo.getPuntosPremio());
            rival.getCampo().quitarActivo();
        }
        return true;
    }

    public boolean iniciarTurno(){
        if(!getJugadorActual().robarCarta()){
            ganador = getRival();
            return false;
        }
        getJugadorActual().recibirEnergia();
        return true;
    }

    public void terminarTurno(){
        getJugadorActual().reiniciarTurno();
        turnoActual = 1 - turnoActual;
        numeroTurno +=1;
    }

    public boolean revisarVictoria(){
        for(int i=0; i<jugadores.size();i++){
            Jugador j = jugadores.get(i);
            if(j.getPuntosPremio() >= 3){
                ganador = j;
                return true;
            }
            if(!j.getCampo().hayPokemonJugando()){
                ganador = jugadores.get(1 - i);
                return true;
            }
        }
        return ganador != null;
    } 

}
