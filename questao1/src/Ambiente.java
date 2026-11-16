import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    private String nomeAmbiente;
    private String nomeProvedor;
    private final List<iMaquinaVirtual> maquinasVirtuais;
    private iArmazenamentoDeObjetos armazenamento;
    private int quantidadeGbArmazenamento;
    private iFilaDeMensagens fila;

    public Ambiente(String nomeAmbiente, String nomeProvedor,List<iMaquinaVirtual> maquinasVirtuais, iArmazenamentoDeObjetos armazenamento,
            int quantidadeGbArmazenamento, iFilaDeMensagens fila) {
        this.nomeAmbiente = nomeAmbiente;
        this.nomeProvedor = nomeProvedor;
        this.maquinasVirtuais = new ArrayList<>(maquinasVirtuais);
        this.armazenamento = armazenamento;
        this.quantidadeGbArmazenamento = quantidadeGbArmazenamento;
        this.fila = fila;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public List<iMaquinaVirtual> getMaquinasVirtuais() {
        return maquinasVirtuais;
    }

    public iArmazenamentoDeObjetos getArmazenamento() {
        return armazenamento;
    }

    public iFilaDeMensagens getFila() {
        return fila;
    }

    public String getNomeProvedor() {
        return nomeProvedor;
    }

    public int getQuantidadeGbArmazenamento() {
        return quantidadeGbArmazenamento;
    }

    public double getCustoMensalEstimado() {
        double custoMaquinas = 0;
        for (iMaquinaVirtual mv : maquinasVirtuais) {
            custoMaquinas += mv.getCustoHora() * 730;
        }

        double custoArmazenamento = quantidadeGbArmazenamento * armazenamento.getCustoGbMes();
        double custoFila = fila.getCustoMensal();

        return custoMaquinas + custoArmazenamento + custoFila;
    }

}
