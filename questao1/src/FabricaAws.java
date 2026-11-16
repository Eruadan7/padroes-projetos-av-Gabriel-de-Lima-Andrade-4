public class FabricaAws implements iFabricaAmbiente {

    @Override
    public iMaquinaVirtual criarMaquinaVirtual(String identificador) {
        return new MvAws(identificador);
    }

    @Override
    public iArmazenamentoDeObjetos criarArmazenamentoDeObjetos(String identificador) {
        return new AoAws(identificador);
    }

    @Override
    public iFilaDeMensagens criarFilaDeMensagens(String identificador) {
        return new FmAws(identificador);
    }
    
}
