public class FmAzure implements iFilaDeMensagens {
    private String identificador = "sb-";

    public FmAzure(String identificador) {
        this.identificador = this.identificador + identificador;
    }

    @Override
    public double getCustoMensal() {
        return 0.50;
    }
    
    @Override
    public String getIdentificador() {
        return identificador;
    }
}
