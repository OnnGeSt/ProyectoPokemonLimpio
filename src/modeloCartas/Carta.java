package modeloCartas;

public abstract class Carta {
    private String nombre;

    public Carta(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract String descripcion();
}
