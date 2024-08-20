import banco.Banco;
import banco.conta.Conta;
import banco.conta.ContaCorrente;
import banco.conta.ContaPoupanca;
import banco.usuario.Cliente;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente joao = new Cliente();
        joao.setNome("João");
        Cliente paulo = new Cliente();
        paulo.setNome("Paulo");

        Conta ccJoao = new ContaCorrente(joao, false);
        Conta poupancaJoao = new ContaPoupanca(joao);

        Conta ccPaulo = new ContaCorrente(paulo, true);
        Conta poupancaPaulo = new ContaPoupanca(paulo);

        Banco bancoEletronico = new Banco("Claro");

        List<Conta> contasClaro = Arrays.asList(ccJoao, ccPaulo, poupancaJoao, poupancaPaulo);
        bancoEletronico.setContas(contasClaro);


//        cc.depositar(-100);
        System.out.println("-----------------------------");
        ccJoao.depositar(100);
        ccJoao.clienteEspecial();
        ccJoao.imprimirExtrato();
        ccJoao.transferir(100, poupancaJoao);
        ccJoao.imprimirExtrato();

        System.out.println("------------------------------");
        poupancaJoao.imprimirExtrato();

        System.out.println("------------------------------");
        poupancaPaulo.sacar(500);
        poupancaPaulo.imprimirExtrato();
        System.out.println("------------------------------");
        ccPaulo.imprimirExtrato();
        System.out.println("------------------------------");
        ccPaulo.sacar(500);
        ccPaulo.imprimirExtrato();
        System.out.println("------------------------------");
        ccPaulo.depositar(600);
        ccPaulo.pagarCredito();
        ccPaulo.imprimirExtrato();

        System.out.println(bancoEletronico.getContas());

        System.out.println("\n=== Imprimindo contas do Banco ===");
        bancoEletronico.imprimirContas();

        System.out.println("---");
        bancoEletronico.buscarConta(1);
        bancoEletronico.depositarConta(1, 200.00);
        bancoEletronico.sacarConta(1, 50.00);
        bancoEletronico.buscarConta(1);
    }
}