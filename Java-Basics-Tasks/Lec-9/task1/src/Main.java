                         /* Basic Thread Creation*/

void main() {

    /*  Create and run a simple thread
        Create a class that extends Thread,
        override run() method,
        and print "Hello from thread". Start the thread./*
    */

    Threads1 thread1 = new Threads1();
    thread1.start();

    /*  Implement Runnable interface
        Create a class that implements Runnable and
        prints the current thread name and a message
    */

    Threads2 thread2 = new Threads2();
    thread2.run();



}
