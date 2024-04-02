package controller;

public class Transacao extends Thread{
    private Conta[] contas;

    public Transacao(Conta[] contas) {
        this.contas = contas;
    }

    @Override
    public void run() {
        int codigoConta = (int) (Math.random() * contas.length);
        Conta conta = contas[codigoConta];

        if (Math.random() < 0.5) {
            int valor = (int) (Math.random() * 100);
            synchronized (conta) {
                conta.sacar(valor);
                System.out.println("Realizado um saque de " + valor + " na conta " + conta.getCodigo());
            }
        } else {
            int valor = (int) (Math.random() * 100);
            synchronized (conta) {
                conta.depositar(valor);
                System.out.println("Realizado umd epósito de " + valor + " na conta " + conta.getCodigo());
            }
        }
    }
}
