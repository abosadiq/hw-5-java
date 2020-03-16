

class Multithread extends Thread {
    public void run() {
        try {
            System.out.println ("Thread " + Thread.currentThread().getName() + " is running");
        }catch (Exception e) {
            System.out.println ("Exception");
        }
    }
}
class Hw6Q1 {
    public static void funMainThread(){
        System.out.println("This is from main thread.");
    }
    public static void main(String arg[]){
        try{
            for(int i=0;i<3;i++) {
                for(int childCounter=0;childCounter<3;childCounter++) {
                    Multithread obj = new Multithread();
                    obj.start();
                }
                Thread.sleep(2000); //otherwise thread would be concurrent
                for(int mainCounter=0;mainCounter<5;mainCounter++) funMainThread();
            }
        }catch(Exception e){

        }
    }

}