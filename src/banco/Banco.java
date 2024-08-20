package banco;

import banco.conta.Conta;

import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void imprimirContas() {
        contas.stream().forEach(conta -> {
            conta.imprimirExtrato();
        });
    }

    public void buscarConta(int numero) {
        contas.get(numero).imprimirExtrato();
    }

    public void depositarConta(int numero, double valor) {
        contas.get(numero).depositar(valor);
    }

    public void sacarConta(int numero, double valor) {
        contas.get(numero).sacar(valor);
    }
}
