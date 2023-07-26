package projetoAgenciaBancaria;

import projetoAgenciaBancaria.Pessoa.Conta;
import projetoAgenciaBancaria.Pessoa.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

public class AgenciaBank {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +
                        "\n"+"|   Opção 1 - Criar conta" +
                        "\n"+"|   Opção 2 - Depositar" +
                        "\n"+"|   Opção 3 - Sacar" +
                        "\n"+"|   Opção 4 - Transferir" +
                        "\n"+"|   Opção 5 - Listar" +
                        "\n"+"|   Opção 6 - Sair"));

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agência");
                System.exit(0);

            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));

        pessoa.setCPF(JOptionPane.showInputDialog("CPF: "));

        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Sua conta foi criado com sucesso!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) ;
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {

        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog(" Número da conta para depósito: "));

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito =
                    Double.parseDouble((JOptionPane.showInputDialog("Qual valor que deseja depositar: ")));
            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta por saque: "));

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            Double valorSaque =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual valor desejar sacar? "));
            conta.sacar(valorSaque);

            System.out.println("Valor sacado com sucesso! ");
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        int numeroContaRemetente =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
           int numeroContaDestinatario =
                   Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário: "));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                Double valor =
                        Double.parseDouble((JOptionPane.showInputDialog("Valor da transferência: ")));

                contaRemetente.transferir(contaDestinatario, valor);
            }else {
                JOptionPane.showMessageDialog(null, "Conta para depósito não encontrada");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                JOptionPane.showMessageDialog(null,conta);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Não há contas cadastradas! ");
        }
        operacoes();
    }
}