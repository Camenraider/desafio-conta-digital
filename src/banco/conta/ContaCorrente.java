package banco.conta;

import banco.usuario.Cliente;

public class ContaCorrente extends Conta {
    final String CONTA_CORRENTE = "conta corrente";
    final double CREDITO_BASE = 1000.00;
    private boolean especial;
    private double credito;

    public ContaCorrente(Cliente cliente, boolean especial) {
        super(cliente);
        this.especial = especial;
        if (isEspecial()){
            credito = CREDITO_BASE;
        } else {
            credito = 0;
        }
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
        if (isEspecial()) {
            System.out.println(String.format("Conta com credito especial: R$%.2f", this.getCredito()));
        }
    }

    @Override
    public void sacar(double valor) {
//        super.sacar(valor);
        if (saldo < valor) {
            credito -= valor;
            System.out.println("Saque realizado");
            System.out.println(String.format("Você está usando credito especial -R$%.2f" , valor));
        } else if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public boolean isEspecial() {
        if (especial) {
//            System.out.println("Conta Corrente Especial");
            return true;
        } else {
//            System.out.println("Conta Corrente convencional");
            return false;
        }
    }

    public double getCredito() {
        return this.credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void clienteEspecial() {
        if (isEspecial()) {
            this.credito = 1000;
            System.out.println(String.format("Cliente especial tem credito de R$%.2f", credito));
        }
    }

    public void pagarCredito(){
        double saldoDevedor =  CREDITO_BASE - credito;
        if (getSaldo()> saldoDevedor){
            saldo = saldo - credito;
            System.out.println(String.format("Fatura do credito paga R$%.2f", credito));
            setCredito(CREDITO_BASE);
        } else {
            System.out.println("Saldo insuficiente para pagar a fatura do credito!");
        }
    }

    @Override
    public String toString() {
        return CONTA_CORRENTE + " de " + cliente.getNome();
    }
}
