public class MvAws implements iMaquinaVirtual {
    private String identificador = "i-";

    public MvAws(String identificador) {
        this.identificador = this.identificador + identificador;
    }

    @Override
    public double getCustoHora() {
        return 0.10;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }
}