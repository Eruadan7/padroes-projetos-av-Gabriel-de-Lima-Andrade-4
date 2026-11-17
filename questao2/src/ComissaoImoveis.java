public class ComissaoImoveis implements iRegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        return (valorVenda * 0.03) + 1500.00;
    }
    @Override
    public String getNomeRegra() { return "Imóveis (3% + R$ 1.500)"; }
}
