package modeloCartas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon extends Carta {
    private TipoEnergia tipo;
    private int psMax;
    private int psActual;
    private int costoRetirada;
    private List<Ataque> ataques;
    private List<TipoEnergia> energias;


    public Pokemon(String nombre, TipoEnergia tipo, int psMax, int costoRetirada,
                   List<Ataque> ataques){
        super(nombre);
        this.tipo = tipo;
        this.psMax = psMax;
        this.psActual = psMax;
        this.costoRetirada = costoRetirada;
        this.ataques = List.copyOf(ataques);
        this.energias = new ArrayList<>();
    }

    public TipoEnergia getTipo() {
        return tipo;
    }

    public int getPsMax() {
        return psMax;
    }

    public int getPsActual() {
        return psActual;
    }

    public int getCostoRetirada() {
        return costoRetirada;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public List<TipoEnergia> getEnergias() {
        return new ArrayList<>(energias);
    }

    public boolean puedeUsar(Ataque ataque){
    List<TipoEnergia> disponibles = new ArrayList<>(energias);
    int incoloro = 0;
    for(TipoEnergia costo : ataque.getCosto()){
        if(costo == TipoEnergia.INCOLORO){
            incoloro++;
        }else if(!disponibles.contains(costo)){
            return false;
        }else{
            disponibles.remove(costo);
        }
    }
    return disponibles.size() >= incoloro;
    }   

    public void recibirDano(int dano){
        psActual -= dano;
        if(psActual < 0){
            psActual = 0;
        }
    }

    public void curar(int cantidad){
        psActual += cantidad;
        if(psActual > psMax){
            psActual = psMax;
        }
    }

    public void adjuntarEnergia(TipoEnergia energia){
        energias.add(energia);
    }

    public boolean descartarEnergias(int cantidad){
        if(energias.size() < cantidad){
            return false;
        }
        for(int i=0;i<cantidad;i++){
            energias.remove(0);
        }
        return true;
    }

    public boolean estaDerrotado(){
        return psActual <= 0;
    }

    public abstract int getPuntosPremio();
    
    @Override
    public String descripcion(){
        return getNombre() + " - Tipo: " + tipo + ", PS: " + psActual + "/" + psMax 
        + ", costo de retirada: " + costoRetirada + ", ataques: " + ataques.size()
        + ", energias: " + energias.size();
    }
}
