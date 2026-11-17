public class Main {
    public static void main(String[] args) {
        // Lotes de categorias distintas; a regra de comissão já nasce com o lote (RF01, RNF02)
        Lote pintura = new Lote("Pintura", "Arte", new ComissaoArte(), 500.00, 1000.00);
        Lote carro = new Lote("Carro", "Veículos", new ComissaoVeiculos(), 50000.00, 100000.00);

        Participante p1 = new Participante("João");
        Participante p2 = new Participante("José");
        Participante p3 = new Participante("Maria");

        // Painel e auditor acompanham os dois lotes (RF04)
        PainelLeiloeiro painel = PainelLeiloeiro.getInstance();
        AuditLog auditor = AuditLog.getInstance();
        painel.registrarLote(pintura);
        painel.registrarLote(carro);
        auditor.acompanharLote(pintura);
        auditor.acompanharLote(carro);

        // Pintura: lances aceitos e recusado (RF02, RF03)
        System.out.println("\n>>> LANCES NA PINTURA <<<");
        p1.acompanharLote(pintura);
        p2.acompanharLote(pintura);
        p3.acompanharLote(pintura);

        p1.darLance(pintura, 525.00);   // aceito (mínimo 525,00)
        p2.darLance(pintura, 530.00);   // recusado (mínimo 551,25)
        p3.darLance(pintura, 1500.00);  // aceito, acima da reserva

        // Maria sai do acompanhamento; o lance seguinte não deve ser avisado a ela (RF03)
        System.out.println("\n>>> MARIA DEIXA DE ACOMPANHAR A PINTURA <<<");
        p3.deixarDeAcompanharLote(pintura);
        p1.darLance(pintura, 1600.00);  // aceito (mínimo 1.575,00)

        // Campanha: troca de regra em tempo de execução, antes do encerramento (RF07)
        System.out.println("\n>>> CAMPANHA: TROCA DE REGRA DE COMISSÃO <<<");
        pintura.setRegraComissao(new ComissaoEletronicos());

        // Encerramento com venda (RF05)
        System.out.println("\n>>> ENCERRAMENTO DA PINTURA <<<");
        boolean vendeuPintura = pintura.encerrar();
        p2.darLance(pintura, 5000.00);  // recusado: lote encerrado

        if (vendeuPintura) {
            // Fatura com quatro serviços, um deles repetido (RF08, RF09)
            Fatura fatura = new Fatura(pintura, pintura.getPrecoAtual());
            fatura.adicionarServico(new SeguroTransporte());
            fatura.adicionarServico(new CertificadoAutenticidade());
            fatura.adicionarServico(new EmbalagemEspecial());
            fatura.adicionarServico(new EmbalagemEspecial());
            fatura.adicionarServico(new EntregaExpressa());
            fatura.imprimirFatura();

            // Acerto com a regra vigente no encerramento (RF10)
            AcertoVendedor.imprimirAcerto(pintura);
        } else {
            System.out.println("Lote não vendido. Fatura e acerto não gerados.");
        }

        // Carro: nenhum lance atinge a reserva, então não é vendido (RF05)
        System.out.println("\n>>> LANCES NO CARRO <<<");
        p1.acompanharLote(carro);
        p2.acompanharLote(carro);

        p1.darLance(carro, 55000.00);   // aceito
        p2.darLance(carro, 60000.00);   // aceito, mas abaixo da reserva

        System.out.println("\n>>> ENCERRAMENTO DO CARRO <<<");
        boolean vendeuCarro = carro.encerrar();

        if (vendeuCarro) {
            Fatura fatura = new Fatura(carro, carro.getPrecoAtual());
            fatura.imprimirFatura();
            AcertoVendedor.imprimirAcerto(carro);
        } else {
            System.out.println("Lote não vendido. Fatura e acerto não gerados.");
        }

        // Resumo do painel e histórico completo da auditoria (RF04)
        System.out.println();
        painel.mostrarDadosLotes();

        System.out.println("\n>>> HISTÓRICO DE AUDITORIA <<<");
        for (String registro : auditor.getRegistros()) {
            System.out.println(registro);
        }
    }
}