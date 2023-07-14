package ex02_loop;

public class MainWrapper {

  public static void ex01() {
    // 구구단 출력하기
    // 2 x 1 = 2
    // 2 x 2 = 4
    // ...
    // 2 x 9 = 17
    int dan = 9;  // 이 곳에 원하는 구구단을 넣으면 된다.
     
     for(int n = 1; n <= 9; n++ ) {
       System.out.println(dan + "x" + n + "=" + dan * n);
     }
  }
  
  public static void ex02() {
    // 100000 넘을 때까지 60원씩 모금하면서 과정 출력하기
    // 1회 모금액 60원, 현재 모금액 60원
    // 2회 모금액 60원, 현재 모금액 120원
    // 3회 모금액 60원, 현재 모금액 180원
    // ...
    // 1667회 모금액 60원, 현재 모금액 100020원
    int goal = 100000;  // 목표 모금액
    int money = 60;  // 1회당 모금액
    int total = 0;  // 모금액 합계
      // 회차
    
    
    for(int nth = 1; nth * money <= 100000; nth++) {
      System.out.println(nth + "회 모금액" + money + "원, " + "현재 모금액" + nth * money  + "원");
    }
       
    
  }
  
  public static void ex03() {
    // 전체 구구단 출력하기 - 1
    // 2 x 1 = 2
    // ...
    // 9 x 9 = 81
    for(int n = 2; n <= 9; n++) {
      for(int m = 1; m <= 9; m++) {
        System.out.println(n + "x" + m + "=" + n*m);
      }
    }
  }
  
  public static void ex04() {
    // 전체 구구단 출력하기 - 2
    // 2x1=2  3x1=3  4x1=4  ... 9x1=9
    // ...
    // 2x9=18 3x9=27 4x9=36 ... 9x9=81
    
    // 참고할코드
    //System.out.print("2x1=2");  // 2x1=2를 출력한 뒤 줄을 바꾸지 않는다.
    
    for(int n = 2; n <= 9; n++) {
      for(int m = 1; m <= 9; m++)
        System.out.print(n + "x" + m + "=" + n*m + "  ");
        System.out.println();
    }
  }
  
  public static void ex05() {
    // 삼각별 출력하기 - 1 (2중 loop)
    // *
    // **
    // ***
    // ****
    // *****
    
    // 참고할 코드
    //System.out.print("*");  // *를 출력한 뒤 줄을 바꾸지 않는다.
    //System.out.println();   // 줄 바꾸기        
    
    for(int i = 1; i < 6; i++) {
      for(int j = 0; j < i; j++) {
        System.out.print("*");
        
         }System.out.println(""); 
    }
    
  }
  
  public static void ex06() {
    // 삼각별 출력하기 - 2 (2중 loop)
    // *****
    // ****
    // ***
    // **
    // *
    

  } 
  public static void ex07() {
    // 삼각별 출력하기 - 3 (2중 loop)
    //     *
    //    ***
    //   *****
    //  *******
    // *********
    
  }
  
  public static void ex08() {
    // 삼각별 출력하기 - 4 (2중 loop)
    // *********
    //  *******
    //   *****
    //    ***
    //     *
    
  }  
  
  public static void main(String[] args) {
   
    //ex01();
    //ex03();
    //ex04();
    //ex05();
    
    ex02();
  }

}
