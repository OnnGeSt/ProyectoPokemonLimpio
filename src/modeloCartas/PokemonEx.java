package modeloCartas;

import java.util.List;

public class PokemonEx extends Pokemon {
    public PokemonEx(String nombre, TipoEnergia tipo, int psMax,
                        int costoRetirada, List<Ataque> ataques){
        super(nombre, tipo, psMax, costoRetirada, ataques);
    }

    @Override 
    public int getPuntosPremio() {
        return 2;
    }
    
}
