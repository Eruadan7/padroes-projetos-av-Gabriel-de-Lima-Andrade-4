public class AcertoVendedor {
    
    public static void imprimirAcerto(Lote lote) {
        if (!lote.isVendido()) {
            System.out.println("Lote não vendido. Não há acerto.");
            return;
        }

        double valorVenda = lote.getPrecoAtual();
        double comissao = lote.getRegraComissao().calcularComissao(valorVenda);
        double valorLiquido = valorVenda - comissao;

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("ACERTO DO VENDEDOR");
        System.out.println("Lote: " + lote.getNome());
        System.out.println("Valor de Venda: R$ " + String.format("%.2f", valorVenda));
        System.out.println("Regra Aplicada: " + lote.getRegraComissao().getNomeRegra());
        System.out.println("Comissão Cobrada: R$ " + String.format("%.2f", comissao));
        System.out.println("Valor Líquido a Repassar: R$ " + String.format("%.2f", valorLiquido));
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
