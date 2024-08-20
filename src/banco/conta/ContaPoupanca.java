package banco.conta;

import banco.usuario.Cliente;

public class ContaPoupanca extends Conta{
    final String CONTA_POUPANCA = "conta poupança";
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }


    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return this.CONTA_POUPANCA + " de " + cliente.getNome();
    }
}
