import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PainelLeiloeiro extends absObservador {
    private final List<Lote> lotes = new CopyOnWriteArrayList<>();

    private PainelLeiloeiro() {}

    private static class Holder {
        private static final PainelLeiloeiro INSTANCIA = new PainelLeiloeiro();
    }

    public static PainelLeiloeiro getInstance() {
        return Holder.INSTANCIA;
    }

    public void registrarLote(Lote lote) {
        if (!lotes.contains(lote)) {
            lotes.add(lote);
            // inscrevendo automaticamente nos observadores do lote
            lote.inscreverParticipante(this);
        }
    }

    @Override
    public void update(Lote lote, Lance lance) {
        System.out.println("\n--- PAINEL DO LEILOEIRO ---");
        System.out.println("Lote: " + lote.getNome());
        System.out.println("Maior Lance: R$ " + String.format("%.2f", lote.getPrecoAtual()));
        System.out.println("Total de Lances: " + lote.getTotalLances());
        System.out.println("---------------------------");
    }

    public void mostrarDadosLotes() {
        System.out.println("PAINEL DO LEILOEIRO - Dados dos Lotes");
        for (Lote l : List.copyOf(lotes)) {
            System.out.println("=-".repeat(25));
            System.out.println(String.format(
                "Lote: %s\nMaior Lance: %.2f\nTotal de Lances: %d",
                l.getNome(), l.getPrecoAtual(), l.getTotalLances()
            ));
        }
    }
}