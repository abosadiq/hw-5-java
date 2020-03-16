
import java.util.Random;



class GetSuareNum extends  Thread{
    int num;
    GetSuareNum(int num2){
        num = num2;
    }
    public void run(){
        int square = (int) Math.pow(num, 2);
        System.out.println("Square of "  + num + " is "+ square);
    }
}

class GetCubeNum extends Thread{
    int num;
    GetCubeNum(int num2){
        num = num2;
    }
    public void run(){
        int cubNum = num *num * num;
        System.out.println("The Cube of "  + num + " is "+ cubNum);
    }
}

class Number extends Thread{

    public void run(){
          Random rand = new Random();
          int i = 0;
          while(i <5){
              int randNum = rand.nextInt(100);
               GetSuareNum sqr = new GetSuareNum(randNum);
                sqr.start();
               GetCubeNum cub = new GetCubeNum(randNum);
               cub.start();

              i++;
          }
      }
}

class Square {
  public static void main(String args[]){
      Number num = new Number();
      num.start();
  }

}