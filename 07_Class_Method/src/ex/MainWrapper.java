package ex;

public class MainWrapper {
  
  public static void ex01() {
    System.out.println("파라미터가 없는 ex01");
  }
  
  public static void ex01(String str) {  // 파라미터 String str : 인수를 받아서 저장하는 변수(매개변수)
    System.out.println("파라미터 String str = " + str);
  }
  
  public static void ex01(int a, int b) {  // 파라미터 int a, int b 생성 
    System.out.println("파라미터 int a =" + a);
    System.out.println("파라미터 int b =" + b);
  }
  
  // 메소드 오버로딩 : 이름이 같은 메소드는 가능하지만 파라미터는 달라야 한다.
  
  public static void main(String[] args) {
    ex01(); // ex01() 메소드에 전달하는 인수가 없다.
    ex01("Hello world"); // ex01() 메소드에 인수 "Hello world"를 전달한다.
    ex01(10, 20);  // ex01() 메소드에 인수 10,20을 전달한다.
  }

}
