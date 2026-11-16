public class AoAws implements iArmazenamentoDeObjetos {
    private String identificador = "s3://";

    public AoAws(String identificador) {
        this.identificador = this.identificador + identificador;
    }
    
    @Override
    public double getCustoGbMes() {
        return 0.023;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }
    
}
