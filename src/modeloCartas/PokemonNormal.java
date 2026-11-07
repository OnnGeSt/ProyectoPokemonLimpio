package modeloCartas;

import java.util.List;

public class PokemonNormal extends Pokemon {
    public PokemonNormal(String nombre, TipoEnergia tipo, int psMax,
                        int costoRetirada, List<Ataque> ataques){
        super(nombre, tipo, psMax, costoRetirada, ataques);
    }

    @Override 
    public int getPuntosPremio() {
        return 1;
    }
    
}
