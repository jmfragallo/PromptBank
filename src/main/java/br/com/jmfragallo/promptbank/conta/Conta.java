package br.com.jmfragallo.promptbank.conta;

public abstract class Conta {
    private int agencia = 0;
    private int conta;
    private double saldo;
    private Titular titular;

    public Conta(int agencia, int conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public void deposita(double valor)
    {
        if (valor > 0) {
            saldo += valor;

            System.out.println("Saldo: " + saldo);
        } else {
            System.out.println("Deposite um valor maior que zero");
        }
    }

    public boolean saca(double valor) {
        if (saldo > valor) {
            saldo -= valor;

            System.out.println("Saldo: " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque");
        }
        return false;
    }

    public void transfere(Conta origem, Conta destino, double valor) {
        if (origem.saca(valor)) {
            destino.deposita(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso de "
                    + origem.titular.getNome() + " para " + destino.titular.getNome());
        } else {
            System.out.println("Transferência não realizada.");
        }
    }


    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0) {
            System.out.println("Valor deve ser maior que zero");
            return;
        }

        this.saldo = saldo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }
}
