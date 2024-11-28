package telran.multithreading;

public class Main {
    public static void main(String[] args) {
        Object mutex1 = new Object();
        Object mutex2 = new Object();

        Worker worker1 = new Worker(mutex1, mutex2);
        Worker worker2 = new Worker(mutex2, mutex1);

        worker1.start();
        worker2.start();
    }
}
