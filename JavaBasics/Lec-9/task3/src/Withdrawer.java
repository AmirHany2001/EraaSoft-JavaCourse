public class Withdrawer extends Thread{
    BankAccount withdrawer;

    public Withdrawer(BankAccount withdrawer) {
        this.withdrawer = withdrawer;
    }

    public void run() {
        while (true) {
            try {
                withdrawer.withdraw(1000);
                Thread.sleep(750);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
