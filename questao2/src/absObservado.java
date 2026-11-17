import java.util.ArrayList;
import java.util.List;

public abstract class absObservado {
    protected List<absObservador> listaObservadores = new ArrayList<absObservador>();

    public abstract void inscreverParticipante(absObservador observador);
    public abstract void removerParticipante(absObservador observador);
}