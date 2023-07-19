package ex03_class;

public class MainWrapper {

  public static void main(String[] args) {
    
    // Calculator 객체 선언
    // 클래스이름을 타입으로 작성
    Calculator myCalc;
    
    // Calculator 객체 생성
    myCalc = new Calculator();
    
    // 계산하고자 하는 실수 2개
    double a = 1.5;
    double b = 1.2;
    
    // 사칙연산 메소드 호출
    System.out.println(myCalc.addition(a, b));
    System.out.println(myCalc.division(a, b));
    System.out.println(myCalc.multiplication(a, b));
    System.out.println(myCalc.subtraction(a, b));    
  }

}
