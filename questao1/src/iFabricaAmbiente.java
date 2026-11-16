public interface iFabricaAmbiente {
    public iMaquinaVirtual criarMaquinaVirtual(String identificador);
    public iArmazenamentoDeObjetos criarArmazenamentoDeObjetos(String identificador);
    public iFilaDeMensagens criarFilaDeMensagens(String identificador);
}
