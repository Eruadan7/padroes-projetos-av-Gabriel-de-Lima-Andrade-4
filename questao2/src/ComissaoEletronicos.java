public class ComissaoEletronicos implements iRegraComissao {
    @Override
    public double calcularComissao(double valorVenda) {
        double comissao = valorVenda * 0.12;
        return Math.max(comissao, 50.00);
    }
    @Override
    public String getNomeRegra() { return "Eletrônicos (12% com mínimo de R$ 50)"; }
}
