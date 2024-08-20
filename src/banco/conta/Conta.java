package banco.conta;

import banco.usuario.Cliente;

public class Conta implements InterfaceConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println(String.format("Sacado com sucesso o valor de R$%.2f!", valor));
        } else {
//            throw new RuntimeException("Saldo Insuficiente!");
            System.out.println(String.format("Saldo Insuficiente para sacar R$%.2f!", valor));
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println(String.format("Depositado R$%.2f com sucesso!", valor) + " na conta de " + cliente.getNome());
        } else {
            throw new RuntimeException("Erro na operação, apenas valores positivos");
        }
    }

    @Override
    public void transferir(double valor, InterfaceConta contaDestino) {
        System.out.println("Saque para transferir para "+ contaDestino);
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println(String.format("Transferencia realizada R$%.2f" ,valor)
                + " para a " + contaDestino);
    }

    @Override
    public void imprimirExtrato() {
//        imprimirInfosComuns();
    }

//    @Override
//    public void getEspecial() {
//
//    }

    @Override
    public double getCredito() {
        return 0;
    }

    @Override
    public boolean isEspecial() {
        return false;
    }

    @Override
    public void clienteEspecial() {

    }

    @Override
    public void pagarCredito() {

    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
