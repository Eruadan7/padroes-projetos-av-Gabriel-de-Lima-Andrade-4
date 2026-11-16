public class FmAws implements iFilaDeMensagens {
    private String identificador = "sqs-";

    public FmAws(String identificador) {
        this.identificador = this.identificador + identificador;
    }

    @Override
    public double getCustoMensal() {
        return 0.40;
    }
    
    @Override
    public String getIdentificador() {
        return identificador;
    }
}
