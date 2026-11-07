package modeloCartas;

public enum TipoEnergia {
    ELECTRICO, FUEGO, AGUA, PSIQUICO, INCOLORO;

    public boolean debilidad(TipoEnergia tipo) {
        switch (this) {
            case ELECTRICO:
                return false;
            case FUEGO:
                return tipo == TipoEnergia.AGUA;
            case AGUA:
                return tipo == TipoEnergia.FUEGO || tipo == TipoEnergia.ELECTRICO;
            case PSIQUICO:
                return false;
            case INCOLORO:
                return tipo == TipoEnergia.INCOLORO;
            default:
                return false;
        }
    }

}