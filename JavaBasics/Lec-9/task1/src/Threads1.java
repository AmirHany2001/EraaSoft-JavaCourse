public class Threads1 extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from thread1" + "\n" + Thread.currentThread().getName());
    }
}
