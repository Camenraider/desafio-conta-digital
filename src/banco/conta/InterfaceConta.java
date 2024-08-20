package banco.conta;

public interface InterfaceConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, InterfaceConta contaDestino);
    void imprimirExtrato();
    public double getCredito();
    public boolean isEspecial();
    void clienteEspecial();
    void pagarCredito();
}
