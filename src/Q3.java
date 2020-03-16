class letter extends Thread{
    private Object object;
    public letter(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.print(i);
                object.notifyAll();
                if (i < 'Z') {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class integer extends Thread{
    private Object object;
    public integer(Object object){
        this.object = object;
    }
    public void run(){
        synchronized (object){
            for (int i = 1; i < 53; i++){
                if (i > 1 && i % 2 == 1){
                    System.out.print(" ");
                }
                System.out.print(i);
                if (i % 2 == 0){
                    object.notifyAll();
                    try {
                        object.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Q3{
    public static void main(String[] args){
        Object object = new Object();
        new Thread(new integer(object)).start();
        new Thread(new letter(object)).start();
    }
}
