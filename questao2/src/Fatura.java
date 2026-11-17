import java.util.ArrayList;
import java.util.List;

public class Fatura {
    private Lote lote;
    private double valorVenda;
    private List<iServicoStrategy> servicosContratados = new ArrayList<>();

    public Fatura(Lote lote, double valorVenda) {
        this.lote = lote;
        this.valorVenda = valorVenda;
    }

    public void adicionarServico(iServicoStrategy servico) {
        this.servicosContratados.add(servico);
    }

    public void imprimirFatura() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("FATURA DO COMPRADOR");
        System.out.println("Lote: " + lote.getNome());
        System.out.println("Valor de Venda: R$ " + String.format("%.2f", valorVenda));
        
        double totalServicos = 0;
        
        // Imprime cada serviço e calcula o total (RNF04: sem if/switch)
        for (iServicoStrategy servico : servicosContratados) {
            double custo = servico.calcularCusto(valorVenda);
            totalServicos += custo;
            System.out.println("- " + servico.getDescricao() + ": R$ " + String.format("%.2f", custo));
        }

        double totalPagar = valorVenda + totalServicos;
        System.out.println("-----------------------------------");
        System.out.println("Total a Pagar: R$ " + String.format("%.2f", totalPagar));
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
