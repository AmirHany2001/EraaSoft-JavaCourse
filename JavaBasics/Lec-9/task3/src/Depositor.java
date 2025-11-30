
public class Depositor extends Thread {
    BankAccount depositor;

    public Depositor(BankAccount depositor) {
        this.depositor = depositor;
    }

    public void run() {
        while (true) {
            try {
                depositor.deposit(1000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
