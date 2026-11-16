public class FabricaAzure implements iFabricaAmbiente {
    @Override
    public iMaquinaVirtual criarMaquinaVirtual(String identificador) {
        return new MvAzure(identificador);
    }

    @Override
    public iArmazenamentoDeObjetos criarArmazenamentoDeObjetos(String identificador) {
        return new AoAzure(identificador);
    }

    @Override
    public iFilaDeMensagens criarFilaDeMensagens(String identificador) {
        return new FmAzure(identificador);
    }
}
