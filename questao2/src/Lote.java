import java.util.ArrayList;
import java.util.List;

public class Lote extends absObservado {
    private String nome;
    private String categoria;
    private iRegraComissao regraComissao;
    private double precoInicial;
    private double precoAtual;
    private double precoReserva;
    private boolean aberto;
    private static final double MARGEM = 0.000001;
    protected List<Lance> lancesAceitos = new ArrayList<Lance>();
    private int totalLances = 0;
    private absObservador comprador = null;

    public Lote(String nome, String categoria,  iRegraComissao regraComissao, double precoInicial, double precoReserva) {
        this.nome = nome;
        this.categoria = categoria;
        this.regraComissao = regraComissao;
        this.precoInicial = precoInicial;
        this.precoAtual = precoInicial;
        this.precoReserva = precoReserva;
        this.aberto = true;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public iRegraComissao getRegraComissao() {
        return regraComissao;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }


    public double getPrecoAtual() {
        return precoAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isVendido() {
        return comprador != null;
    }

    public double getPrecoReserva() {
        return precoReserva;
    }

    public void setRegraComissao(iRegraComissao regraComissao) {
        this.regraComissao = regraComissao;
    }

    public double getLanceMinimo() {
        return precoAtual * 1.05;
    }

    public int getTotalLances() {
        return totalLances;
    }


    public absObservador getComprador() {
        return comprador;
    }

    public boolean receberLance(Lance lance) {
        if (!aberto) {
            return false;
        }
        totalLances += 1;
        if (lance.getValor() >= getLanceMinimo() - MARGEM) {
            precoAtual = lance.getValor();
            lancesAceitos.add(lance);
            for (absObservador observador: this.listaObservadores){
                observador.update(this, lance);
            }
            return true;
        }
        return false;
    }

    @Override
    public void inscreverParticipante(absObservador observador) {
        if (!listaObservadores.contains(observador)){
            this.listaObservadores.add(observador);
        }  
    }

    @Override
    public void removerParticipante(absObservador observador) {
        if (listaObservadores.contains(observador)){
            this.listaObservadores.remove(observador);
        }
        
    }

    public boolean encerrar() {
        if (!this.aberto) {
            System.out.println("Lote já encerrado.");
            return false;
        }

        this.aberto = false;

        if (!lancesAceitos.isEmpty() && this.precoAtual >= this.precoReserva) {
            Lance maiorLance = lancesAceitos.get(lancesAceitos.size() - 1);
            this.comprador = maiorLance.getParticipante();
            System.out.println("Lote encerrado e vendido!");
            return true; 
        }

        System.out.println("Lote encerrado sem vencedores (não atingiu a reserva).");
        return false; 
    }
}
