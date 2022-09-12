package choi;
import java.util.*;

abstract class converter{
	abstract protected double convert(double src); //환율 계산 
	abstract protected String getSrcString(); //원
	abstract protected String getDestString();//달러 
	protected double ratio; // 비율 
	
	public void run() {
		Scanner scanner  = new Scanner(System.in);
		System.out.println(getSrcString() + "을  " + getDestString()+ "로 바꿉니다. ");
		System.out.print(getSrcString() + "을 입력하세요>> ");
		
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과: " + res +getDestString() + "입니다. ");
		scanner.close();
		}
}

//class Won2Dollar extends converter{
//	Won2Dollar(double won){
//		this.ratio = won;
//	}
//	@Override
//	protected double convert(double src) {
//		return src / ratio;
//	}
//	@Override
//	protected String getSrcString() {
//		return "원";
//	}
//	@Override
//	protected String getDestString() {
//		return "달러";
//	}
//	
//}


class Km2Mile extends converter{
	Km2Mile(double num){
		this.ratio = num;
	}
	@Override
	protected double convert(double src) {
		return src/ratio;
	}
	@Override
	protected String getSrcString() {
		return "Km";
	}
	@Override
	protected String getDestString() {
		return "mile";
	}
	
}

public class ch5_3 {
	public static void main(String[] argd) {
//		Won2Dollar toDollar = new Won2Dollar(1200);//1달러 1200원 
//		toDollar.run();
		
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();
	}
}
