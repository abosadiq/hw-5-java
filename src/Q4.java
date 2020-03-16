class A extends Thread{
   public void run(){
       System.out.println("A");
   }
}
class B extends Thread{
    public void run(){
        System.out.println("B");
    }
}
class C extends Thread{
    public void run(){
        int i =0;
        while(i<10){

            B b = new B();
            A a = new A();
            a.start();
            b.start();
            try {
                a.join();
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }


    }
}

public class Q4 {
    public static void main(String[]args){
        C c = new C();
        c.start();
    }

}

