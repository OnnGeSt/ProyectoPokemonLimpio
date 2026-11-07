package juego;

import java.util.ArrayList;
import java.util.List;

import modeloCartas.Carta;
import modeloCartas.Pokemon;
import modeloCartas.TipoEnergia;
import modeloEntrenador.Entrenador;

public class Jugador {
    private String nombre;
    private Mazo mazo;
    private List<Carta> mano = new ArrayList<>();
    private Campo campo = new Campo();
    private int puntosPremio;
    private TipoEnergia energiaZona;
    private boolean energiaDisponible;
    private int reduccionRetirada;
    private boolean suppUsado;
    private boolean ataqueRealizado;

    public Jugador(String nombre, Mazo mazo, TipoEnergia energiaZona){
        this.nombre = nombre;
        this.mazo = mazo;
        this.puntosPremio = 0;
        this.energiaZona = energiaZona;
        this.energiaDisponible = false;
        this.suppUsado = false;
        this.ataqueRealizado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public List<Carta> getMano() {
        return new ArrayList<>(mano);
    }

    public Campo getCampo() {
        return campo;
    }

    public int getPuntosPremio() {
        return puntosPremio;
    }

    public TipoEnergia getEnergiaZona(){
        return energiaZona;
    }

    public  boolean isEnergiaDisponible(){
        return energiaDisponible;
    }

    public boolean robarCarta(){
        Carta cartaRobada = mazo.robar();
        if(cartaRobada != null){
            mano.add(cartaRobada);
            return true;
        }
        return false;
    }
    
    private boolean manoTienePokemon(){
        for(Carta carta : mano){
            if(carta instanceof Pokemon){
                return true;
            }
        }
        return false;
    }

    public void repartirIniciales(){
        do{
            mazo.devolver(mano);
            mano.clear();
            mazo.barajar();
            for(int i=0; i<5;i++){
                robarCarta();
            }
        } while(!manoTienePokemon());
    }

    public void recibirEnergia(){
        energiaDisponible = true;
    }

    public boolean adjuntarEnergia(Pokemon pokemon){
        if(!energiaDisponible){
            return false;
        }
        if(campo.getActivo() != pokemon && !campo.getBanco().contains(pokemon)){
            return false;
        }
        pokemon.adjuntarEnergia(energiaZona);
        energiaDisponible = false;
        return true;
    }
    
    public boolean colocarEnBanco(Pokemon pokemon){
        if(!mano.contains(pokemon)){
            return false;
        }
        if(campo.ponerEnBanco(pokemon)){
            mano.remove(pokemon);
            return true;
        }
        return false;
    }

    public boolean colocarEnActivo(Pokemon pokemon){
        if(!mano.contains(pokemon)){
            return false;
        }
        if(campo.getActivo() != null){
            return false;
        }
        campo.ponerActivo(pokemon);
        mano.remove(pokemon);
        return true;
    }

    public boolean retirarActivo(Pokemon reemplazo){
        Pokemon activo = campo.getActivo();
        if(activo == null){
            return false;
        }
        if(!campo.getBanco().contains(reemplazo)){
            return false;
        }
        int precioRetirada = activo.getCostoRetirada() - reduccionRetirada;
        if(precioRetirada < 0){
            precioRetirada = 0;
        }
        if(!activo.descartarEnergias(precioRetirada)){
            return false;
        }
        campo.intercambiarActivoBanco(reemplazo);
        return true;
    }

    public boolean jugarEntrenador(Entrenador carta){
        if(!mano.contains(carta)){
            return false;
        }
        if(carta.esCartaSupp() && suppUsado){
            return false;
        }
        if(!carta.activar(this)){
            return false;
        }
        mano.remove(carta);
        if(carta.esCartaSupp()){
            suppUsado = true;
        }
        return true;

    }

    public void sumarPuntosPremio(int puntos){
        puntosPremio += puntos;
    }

    public void reiniciarTurno(){
        suppUsado = false;
        reduccionRetirada = 0;
        energiaDisponible = false;
        ataqueRealizado = false;
    }
    
    public boolean haAtacado(){
        return ataqueRealizado;
    }

    public void marcarAtaque(){
        ataqueRealizado = true;
    }
    
    public void agregarAMano(Carta carta){
        mano.add(carta);
    }

    public void descartarMano(){
        mano.clear();
    }

    public void reducirRetirada(int reduccion){
        reduccionRetirada += reduccion;
    }

}