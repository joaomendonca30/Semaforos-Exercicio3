import controller.Conta;
import controller.Transacao;

public class Main {
    private static final int NUM_CONTAS = 10;
    private static final int NUM_TRANSACOES = 20;

    public static void main(String[] args) {
        Conta[] contas = new Conta[NUM_CONTAS];

        for (int i = 0; i < NUM_CONTAS; i++) {
            contas[i] = new Conta(i, (int) (Math.random() * 1000));
        }

        Transacao[] transacoes = new Transacao[NUM_TRANSACOES];
        for (int i = 0; i < NUM_TRANSACOES; i++) {
            transacoes[i] = new Transacao(contas);
            transacoes[i].start();
        }

        for (int i = 0; i < NUM_TRANSACOES; i++) {
            try {
                transacoes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Conta conta : contas) {
            System.out.println("Conta " + conta.getCodigo() + ": Saldo = " + conta.getSaldo());
        }
    }
}