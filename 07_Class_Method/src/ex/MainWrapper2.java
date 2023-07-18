package ex;

public class MainWrapper2 {
  
  // 인수를 파라미터로 보낼때는 값이 복사되는 것 똑같은메모리가 아님
  // ex01 메소드에서 a,b값을 증가시켜도 main의 a,b값은 변하지 않음
  
  public static void ex01(int a, int b) {  
    System.out.println(a + ", " + b);
    a++;
    b++;
    System.out.println("ex01의 a =" + a);
    System.out.println("ex01의 b =" + b);
  }    

  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    ex01(a, b);   // 10, 20 출력
    System.out.println("main의 a=" + a);
    System.out.println("main의 b=" + b);    
  }

}
