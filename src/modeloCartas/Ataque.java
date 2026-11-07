package modeloCartas;

import java.util.List;

public class Ataque {
    private String nombre;
    private List<TipoEnergia> costo;
    private int danoBase;

    public Ataque(String nombre, List<TipoEnergia> costo, int danoBase){
        this.nombre = nombre;
        this.costo = costo;
        this.danoBase = danoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public List<TipoEnergia> getCosto() {
        return costo;
    }

    public int getDanoBase() {
        return danoBase;
    }    
}
