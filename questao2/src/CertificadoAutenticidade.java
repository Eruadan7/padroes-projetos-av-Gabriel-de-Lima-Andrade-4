public class CertificadoAutenticidade implements iServicoStrategy {
    @Override
    public String getDescricao() {
        return "Certificado de Autenticidade";
    }

    @Override
    public double calcularCusto(double valorVenda) {
        return 300.00;
    }
}
