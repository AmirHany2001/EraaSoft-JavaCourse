
void main() {
    /*Print numbers 1 to 5 with a 1-second delay between each number using sleep().*/
    Thread1 thread1 = new Thread1();
    thread1.start();

    /*Create two threads. Make the main thread wait for them to finish using join().*/

    Thread1 thread2 = new Thread1();
    thread2.start();
    
    try {
        thread1.join();
        thread2.join();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

    System.out.println("Thread1 and Thread2 is finished");
}
