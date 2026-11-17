public class EntregaExpressa implements iServicoStrategy {
    @Override
    public String getDescricao() {
        return "Entrega Expressa";
    }

    @Override
    public double calcularCusto(double valorVenda) {
        return 450.00;
    }
}
