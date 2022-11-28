import java.util.Scanner;

class count extends Thread{
    @Override
    public void run(){
        System.out.println("스레드 시작");
        for(int i =0; i <= 10; i++){
            System.out.print(i+" ");
        }System.out.println("\n스레드 종료");
    }
}

public class c13에1 {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.println("아무 키 입력>>");
        String str = s.next();

        count th = new count();
        th.start();
        s.close();        
    }
}
