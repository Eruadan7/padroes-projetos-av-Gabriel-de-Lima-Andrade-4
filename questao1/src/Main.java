import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<String, iFabricaAmbiente> fabricas = Map.of(
            "AWS", new FabricaAws(),
            "AZURE", new FabricaAzure()
        );
        ServicoProvisionamento servico = new ServicoProvisionamento();

        List<Solicitacao> solicitacoes = List.of(
            new Solicitacao("producao", "AWS", 3, 500),
            new Solicitacao("homologacao", "AWS", 2, 100),
            new Solicitacao("analytics", "AZURE", 2, 100),
            new Solicitacao("gigante", "AWS", 10, 100)   // estoura o orçamento
        );

        List<Thread> threads = new ArrayList<>();
        for (Solicitacao s : solicitacoes) {
            Thread t = new Thread(() ->
                servico.provisionar(s, fabricas.get(s.getProvedor())));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        
        for (String registro : AuditLog.getInstance().getRegistros()) {
            System.out.println(registro);
        }
    }
}