import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler config.properties", e);
        }
        this.regiaoPadrao = props.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
    }

    public static Configuracao getInstancia() {
        return INSTANCIA;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return orcamentoMensalMaximo;
    }

    public boolean permite(double custoEstimado) {
        return custoEstimado <= orcamentoMensalMaximo;
    }
}