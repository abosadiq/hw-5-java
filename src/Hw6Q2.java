public class Hw6Q2 {
    public static void main(String[] args) throws InterruptedException {
        Thread T1 = new Thread(new ThreadOne());
        Thread T2 = new Thread(new ThreadTwo());
        Thread T3 = new Thread(new ThreadThree());
        T1.start();
        T1.join();
        T2.start();
        T2.join();
        T3.start();
        T3.join();

    }
    static class ThreadOne implements Runnable {
        public void run() {
                System.out.println(Thread.currentThread().getName() + " is running inside of thread1");
        }
    }

    static class ThreadTwo implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running inside of thread2");
        }
    }

    static class ThreadThree implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running inside of thread3");
        }
    }
}