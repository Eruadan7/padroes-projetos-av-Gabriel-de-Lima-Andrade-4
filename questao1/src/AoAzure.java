public class AoAzure implements iArmazenamentoDeObjetos{
    private String identificador = "blob://";

    public AoAzure(String identificador) {
        this.identificador = this.identificador + identificador;
    }
    
    @Override
    public double getCustoGbMes() {
        return 0.02;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }
}
