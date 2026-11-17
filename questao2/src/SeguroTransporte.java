public class SeguroTransporte implements iServicoStrategy {
    @Override
    public String getDescricao() {
        return "Seguro de Transporte (1,5%)";
    }

    @Override
    public double calcularCusto(double valorVenda) {
        return valorVenda * 0.015;
    }
}
