package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modeloCartas.Carta;
import modeloCartas.Pokemon;

public class Mazo {
    private List<Carta> cartas = new ArrayList<>();
    
    public Carta robar(){
        if(cartas.size() <= 0){
            return null;
        }else{
            return cartas.remove(0);
        }
    }

    public boolean esValido(){
        if(cartas.size() != 20){
            return false;
            }
        int cantidadPokemones = 0;
        for(Carta carta : cartas){
            if(carta instanceof Pokemon){
                cantidadPokemones++;
            }
        }
        if(cantidadPokemones < 6){
            return false;
        }
        for(Carta carta : cartas){
            int cartasRepetidas = 0;
            for(Carta cartaR : cartas){
                if(carta.getNombre().equals(cartaR.getNombre())){
                    cartasRepetidas++;
                }
                if(cartasRepetidas > 2){
                    return false;
                }
            }
        }
        return true;
    }

    public void agregar(Carta carta){
        cartas.add(carta);
    }

    public boolean estaVacio(){
        return cartas.isEmpty();
    }

    public void barajar(){
        Collections.shuffle(cartas);
    }

    public Carta buscarPokemonesBasicos(){
        for(int i=0;i<cartas.size();i++){
            if(cartas.get(i) instanceof Pokemon){
                return cartas.remove(i);
            }
        }
        return null;
    }

    public void devolver(List<Carta> manoCartas){
        cartas.addAll(manoCartas);
    }
}
