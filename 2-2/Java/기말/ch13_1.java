import java.util.Scanner;

class Count implements Runnable{
    @Override
    public void run(){
        System.out.println("스레드 실행 시작");
        for(int i =1; i<=10; i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.println("스레드 종료");
    }
}

public class ch13_1{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);

        System.out.print("아무키나 입력 >>");
        String st = s.next();

        Count runnable = new Count();
        
        Thread th = new Thread(runnable);
        th.start();
        s.close();        
    }    
}
