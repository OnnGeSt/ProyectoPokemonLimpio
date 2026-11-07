package juego;

import java.util.ArrayList;
import java.util.List;

import modeloCartas.Pokemon;

public class Campo {
    private Pokemon activo;
    private List<Pokemon> banco = new ArrayList<>();

    public void ponerActivo(Pokemon pokemon){
        this.activo = pokemon;
    }

    public boolean ponerEnBanco(Pokemon pokemon){
        if(banco.size() >= 2){
            return false;
        }
        banco.add(pokemon);
        return true;
    }

    public boolean hayPokemonJugando(){
        return activo != null || !banco.isEmpty();
    }

    public void quitarActivo(){
        activo = null;
    }

    public boolean promoverActivo(Pokemon pokemon){
        if(!banco.contains(pokemon) || activo != null){
            return false;
        }
        banco.remove(pokemon);
        activo = pokemon;
        return true;
    }

    public boolean intercambiarActivoBanco(Pokemon pokemon){
        if(activo == null){
            return false;
        }
        if(!banco.contains(pokemon)){
            return false;
        }
        Pokemon temp = activo;
        banco.remove(pokemon);
        activo = pokemon;
        banco.add(temp);
        return true;
    }

    public Pokemon getActivo() {
        return activo;
    }

    public List<Pokemon> getBanco() {
        return new ArrayList<>(banco);
    }
}
