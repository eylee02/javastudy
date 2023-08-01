package ex03_throw;

import java.util.Scanner;

public class MainWrapper {
  
  /*
   * throw
   * 1. 예외 객체를 직접 생성(new)해서 던질 때 사용한다.
   * 2. Java는 예외로 판단하지 않는 것들을 던질 때 사용한다.
   * 3. 개발자가 직접 예외를 처리할 때 사용한다.
   */

  public static void main(String[] args) {
    
    Scanner sc = null;  // 선언 (초기값 잡아줘야함)
    try {
    sc = new Scanner(System.in); // 생성
    System.out.println("나이를 입력하세요.");
    int age = sc.nextInt();
    if(age < 0 || age > 100) {
      throw new RuntimeException();  // 직접 RuntimeException을 발생시켜서 던진다. catch에서 받아서 처리
    }
    System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
    sc.close();   
    } catch(Exception e) {
      System.out.println("잘 모르겠어요.");
    } finally {
      sc.close();  // finally는 주로 자원 반납용으로 사용한다.
    }

  }

}
