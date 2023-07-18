package ex;

import java.util.Arrays;

public class MainWrapper3 {
  
  // 참조 타입은 인수에서 파라미터로 값을 복사 한 후 파라미터에서 값을 수정하게되면 인수도 수정된 값이 조회된다
  // 데이터상의 주소를 참조하기 때문
  
  public static void ex01(int[] a) {        // int[] a = 0x10000000
    System.out.println(Arrays.toString(a));
    a[0] = 100;
    System.out.println("ex01의 배열 a=" + Arrays.toString(a));   // ex01의 배열 a=[100, 20, 30]
  }

  public static void main(String[] args) {
    int[] a = {10,20,30};
    ex01(a);  // ex01(0x10000000)
    System.out.println("main의 배열 a=" + Arrays.toString(a));  // main의 배열 a=[100, 20, 30]
    
  }

}
