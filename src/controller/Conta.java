package controller;

public class Conta {

    private int codigo;
    private int saldo;

    public Conta(int codigo, int saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public synchronized int getCodigo() {
        return codigo;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void sacar(int valor) {
        saldo -= valor;
    }

    public synchronized void depositar(int valor) {
        saldo += valor;
    }
}
