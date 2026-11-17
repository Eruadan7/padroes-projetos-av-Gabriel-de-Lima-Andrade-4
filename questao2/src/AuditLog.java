import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuditLog extends absObservador {
    private final List<String> registros = new CopyOnWriteArrayList<>();

    private AuditLog() {}

    private static class Holder {
        private static final AuditLog INSTANCIA = new AuditLog();
    }

    public static AuditLog getInstance() {
        return Holder.INSTANCIA;
    }

    public void acompanharLote(Lote lote) {
        lote.inscreverParticipante(this);
    }

    @Override
    public void update(Lote lote, Lance lance) {
        String dataHora = LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String registro = String.format("[%s] Lote: %s | Valor: %.2f | Participante: %s", 
        dataHora, lote.getNome(), lance.getValor(), lance.getParticipante().getNome());

        registros.add(registro+"\n");
    }

    public List<String> getRegistros() {
        return List.copyOf(registros); 
    }

    public void limpar() {
        registros.clear();
    }
}
