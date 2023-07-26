package projetoAgenciaBancaria.Pessoa;

import projetoAgenciaBancaria.Ultilitarios.Uteis;

import static javax.swing.JOptionPane.*;

public class Conta {

    private static int contadorDeContas;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;


    }

    public String toString(){
        return "\nNúmero da conta: " + this.getNumeroConta() +
         "\nNome: " + this.pessoa.getNome() +
         "\nCPF: " + this.pessoa.getCPF() +
         "\nEmail: " + this.pessoa.getEmail() +
        "\nSaldo: " + Uteis.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            showMessageDialog(null,"Seu depósito foi realizado com sucesso!");
        }else {
            showMessageDialog(null,"Não foi possível realizar o depósito");
        }
    }
    public void sacar (Double valor){
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            showMessageDialog(null,"Saque realizado com sucesso!");
        }else {
            showMessageDialog(null,"Não foi possível realizar o saque!");
        }
    }
    public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            showMessageDialog(null,"Transferência realizada com sucesso!");
        }else {
            showMessageDialog(null,"Não foi possível realizar a transferência");
        }
    }

}
