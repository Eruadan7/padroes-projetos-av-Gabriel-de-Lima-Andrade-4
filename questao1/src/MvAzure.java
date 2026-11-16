public class MvAzure implements iMaquinaVirtual {
    private String identificador = "vm-";

    public MvAzure(String identificador) {
        this.identificador = this.identificador + identificador;
    }

    @Override
    public double getCustoHora() {
        return 0.12;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }
}
