import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    private static final DateTimeFormatter FORMATO =
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    // A lista é thread-safe para gravações simultâneas
    private final List<String> registros = new CopyOnWriteArrayList<>();

    private AuditLog() {}

    // Initialization-on-demand holder idiom
    private static class Holder {
        private static final AuditLog INSTANCIA = new AuditLog();
    }

    public static AuditLog getInstance() {
        return Holder.INSTANCIA;
    }

    public void registrar(String mensagem) {
        if (mensagem != null && !mensagem.trim().isEmpty()) {
            String carimbo = LocalDateTime.now().format(FORMATO);
            registros.add("[" + carimbo + "] " + mensagem);
        }
    }

    public List<String> getRegistros() {
        // Retorna uma cópia imutável para leitura
        return List.copyOf(registros); 
    }
    
    public void limpar() {
        registros.clear();
    }
}
