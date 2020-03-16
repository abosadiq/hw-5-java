
public class Q2 {
    public static void main(String[] args){
        CubbyHole cubbyHole = new CubbyHole();
        Producer p1 = new Producer(cubbyHole,1);
        Consumer c1 = new Consumer(cubbyHole,1);
        p1.start();
        c1.start();
    }
}

class CubbyHole {
    private int contents;
    private boolean available = false;

    public synchronized int get() {
        while (available==false) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    available = false;
        notifyAll();
        return contents;
    }

    public synchronized void put(int value) {
        while (available==true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }

}
    class Consumer extends Thread{
        private CubbyHole cubbyHole;
        private int num;
        public Consumer(CubbyHole cubbyHole, int num){
            this.cubbyHole = cubbyHole;
            this.num = num;

        }
        public void run(){
            int value = 0;
            int i =0;
            for(;i<10;i++){
                value = cubbyHole.get();
                System.out.println("Consumber # "+ this.num +  " Got: " + value);

            }
        }
    }
    class Producer extends Thread{
        private CubbyHole cubbyHole;
        private int num;
        public Producer(CubbyHole cubbyHole, int num){
            this.cubbyHole = cubbyHole;
            this.num = num;

        }
        public void run(){
            int i =0;
            for(;i<10;i++){
                 cubbyHole.put(i);
                System.out.println("Procedure # "+ this.num +  " Put " + i);

                try {
                   sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
