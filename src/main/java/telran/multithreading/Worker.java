package telran.multithreading;

public class Worker extends Thread {
    private final Object mutex1;
    private final Object mutex2;

    public Worker(Object mutex1, Object mutex2) {
        this.mutex1 = mutex1;
        this.mutex2 = mutex2;
    }

    @Override
    public void run() {
        while (true) {
            f1();
            f2();
        }
    }

    public void f1() {
        synchronized (mutex1) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mutex2) {}
        }
    }

    public void f2() {
        synchronized (mutex2) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mutex1) {}
        }
    }
}
