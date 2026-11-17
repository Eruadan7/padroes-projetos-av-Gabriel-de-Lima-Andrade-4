public interface iServicoStrategy {
    String getDescricao();
    double calcularCusto(double valorVenda); // Recebe o valor base para calcular porcentagens, se necessário
}