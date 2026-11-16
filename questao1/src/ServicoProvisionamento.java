public class ServicoProvisionamento {

    public void provisionar(Solicitacao solicitacao, iFabricaAmbiente fabrica) {
        // O ambiente é montado em memória apenas para estimar o custo, pois os preços
        // unitários pertencem aos próprios recursos (fonte única de verdade).
        // Nada é provisionado, registrado ou retido nesse momento: se o custo
        // ultrapassar o orçamento, o objeto é descartado sem nunca ter sido
        // efetivado, o que equivale a recusar sem criar recursos.
        Ambiente ambiente = new MontadorAmbiente(solicitacao, fabrica).montar();
        double custo = ambiente.getCustoMensalEstimado();
        Configuracao config = Configuracao.getInstancia();

        if (!config.permite(custo)) {
            String custoFmt = String.format("%.2f", custo);
            String orcamentoFmt = String.format("%.2f", config.getOrcamentoMensalMaximo());

            System.out.println("RECUSADO: " + solicitacao.getNomeAmbiente()
                + " (custo " + custoFmt + " acima do orçamento " + orcamentoFmt + ")");
            AuditLog.getInstance().registrar(
                solicitacao.getNomeAmbiente() + " | " + solicitacao.getProvedor()
                + " | RECUSADO: custo " + custoFmt + " acima do orçamento " + orcamentoFmt);
            return;
        }
        AuditLog.getInstance().registrar(solicitacao.getNomeAmbiente() + " | " + solicitacao.getProvedor() + " | ACEITO");
        imprimirResumo(ambiente, config.getRegiaoPadrao(), custo);
    }

    private void imprimirResumo(Ambiente ambiente, String regiao, double custo) {
        System.out.println("Ambiente: " + ambiente.getNomeAmbiente());
        System.out.println("Provedor: " + ambiente.getNomeProvedor());
        System.out.println("Região: " + regiao);
        for (iMaquinaVirtual mv : ambiente.getMaquinasVirtuais()) {
            System.out.println("Máquina virtual: " + mv.getIdentificador());
        }
        System.out.println("Armazenamento: " + ambiente.getArmazenamento().getIdentificador());
        System.out.println("Fila: " + ambiente.getFila().getIdentificador());
        System.out.println("Custo mensal estimado: " + custo);
    }
}
