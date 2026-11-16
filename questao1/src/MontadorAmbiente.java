import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {
    private final Solicitacao solicitacao;
    private final iFabricaAmbiente fabrica;

    public MontadorAmbiente(Solicitacao solicitacao, iFabricaAmbiente fabrica) {
        this.solicitacao = solicitacao;
        this.fabrica = fabrica;
    }

    public Ambiente montar() {
        List<iMaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 1; i <= solicitacao.getQuantidadeMaquinasVirtuais(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual(String.valueOf(i)));
        }

        iArmazenamentoDeObjetos armazenamento = fabrica.criarArmazenamentoDeObjetos("1");
        iFilaDeMensagens fila = fabrica.criarFilaDeMensagens("1");

        return new Ambiente(
            solicitacao.getNomeAmbiente(),
            solicitacao.getProvedor(),
            maquinas,
            armazenamento,
            solicitacao.getQuantidadeGbArmazenamento(),
            fila);
    }
}
