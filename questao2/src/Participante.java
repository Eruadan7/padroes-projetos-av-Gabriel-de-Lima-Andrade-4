public class Participante extends absObservador {
    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void acompanharLote(absObservado observado) {
        observado.inscreverParticipante(this);
    }

    public void deixarDeAcompanharLote(absObservado observado) {
        observado.removerParticipante(this);
    }
    
    public boolean darLance(Lote lote, double valor) {
        if (!lote.isAberto()) {
            System.out.println("O lote " + lote.getNome() + " está encerrado e não aceita novos lances.");
            return false;
        }

        boolean aceito = lote.receberLance(new Lance(this, valor));
        if (!aceito) {
            System.out.println(String.format(
                "Lance de %.2f recusado: o mínimo para o lote %s é %.2f.",
                valor, lote.getNome(), lote.getLanceMinimo()));
        }
        return aceito;
    }

    @Override
    public void update(Lote lote, Lance lance) {
        if (lance.getParticipante() == this) {
            return;
        }
        System.out.println(String.format(
            "[%s] Novo lance no lote %s: %.2f (por %s)",
            this.getNome(), lote.getNome(), lance.getValor(), lance.getParticipante().getNome()));
    }
}
