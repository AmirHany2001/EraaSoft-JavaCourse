public class Threads2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from thread2" + "\n" + Thread.currentThread().getName());
    }

}
