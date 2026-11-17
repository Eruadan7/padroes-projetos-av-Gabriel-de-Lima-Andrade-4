public class ComissaoVeiculos implements iRegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        double comissao = valorVenda * 0.08;
        return Math.min(comissao, 5000.00);
    }
    @Override
    public String getNomeRegra() { return "Veículos (8% limitado a R$ 5.000)"; }
}
