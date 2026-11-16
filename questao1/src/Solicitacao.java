public class Solicitacao {
    private String nomeAmbiente;
    private String provedor;
    private int quantidadeMaquinasVirtuais;
    private int quantidadeGbArmazenamento;

    public Solicitacao(String nomeAmbiente, String provedor, int quantidadeMaquinasVirtuais,
            int quantidadeGbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinasVirtuais = quantidadeMaquinasVirtuais;
        this.quantidadeGbArmazenamento = quantidadeGbArmazenamento;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getQuantidadeMaquinasVirtuais() {
        return quantidadeMaquinasVirtuais;
    }

    public int getQuantidadeGbArmazenamento() {
        return quantidadeGbArmazenamento;
    }
    
}
