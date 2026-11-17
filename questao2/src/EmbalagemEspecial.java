public class EmbalagemEspecial implements iServicoStrategy {
    @Override
    public String getDescricao() {
        return "Embalagem Especial";
    }

    @Override
    public double calcularCusto(double valorVenda) {
        return 180.00;
    }
}
