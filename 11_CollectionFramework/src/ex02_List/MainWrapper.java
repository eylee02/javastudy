package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;     // java.util 패키지의 List 클래스

/*
 *  ┌--------------┐
 *  │     List     │ List 인터페이스
 *  │--------------│
 *  │   add();     │
 *  │   get();     │
 *  │   size();    │
 *  │   set();     │
 *  │   remove();  │
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │   ArrayList  │ ArrayList 클래스
 *  │--------------│
 *  │   add(){}    │ 요소 추가하기
 *  │   get(){}    │ 요소 가져오기
 *  │   size(){}   │ 요소 개수 반환하기
 *  │   set(){}    │ 요소 수정하기
 *  │   remove(){} │ 요소 삭제하기
 *  └--------------┘
 */

public class MainWrapper {
  
  public static void ex01() {
    
    // ArrayList의 인터페이스 List 타입 선언
    List<String> season; 
    
    // ArrayList 생성
    season = new ArrayList<String>();
    
    // 배열 요소 추가하기
    season.add("여름");  // index 0에 저장됨
    season.add("가을");  // index 1에 저장됨
    season.add("겨울");  // index 2에 저장됨
    season.add(0, "봄"); // index 0에 저장됨 기존배열은 하나씩뒤로 ArrayList클래스의 메소드add
    
    // 배열 요소 확인하기
    System.out.println(season.get(0));
    System.out.println(season.get(1));
    System.out.println(season.get(2));
    System.out.println(season.get(3));
  }

  public static void ex02() {
    
    // ArrayList의 선언 & 생성
    List<String> hobbies = new ArrayList<String>();
    
    // 배열 요소 추가하기
    hobbies.add("산책");
    hobbies.add("여행");
    hobbies.add("독서");
    
    // 배열의 길이 확인 (저장된 요소의 갯수)
    System.out.println(hobbies.size());
    
    // 배열 길이 관련 (마지막 요소 꺼내기) <배열의 길이값 - 1 = 마지막요소>
    System.out.println(hobbies.get(hobbies.size() - 1));
    
    // 배열 for문 적용하기
    for(int i = 0; i < hobbies.size(); i++) {
      System.out.println(hobbies.get(i));
    }
    
    // 배열 for문 적용하기 (리팩토링 : hobbies.size() 메소드가 여러번 호출되는 문제 해결) <초기값설정 때 변수 2개(i, length)를 설정>
    for(int i = 0, length = hobbies.size(); i < length; i++) {
      System.out.println(hobbies.get(i));     
    }    
    
  }  
  
  public static void ex03() {
    
    // ArrayList의 선언 & 생성
    List<String> flower = new ArrayList<String>();
    
    // 요소 추가하기
    flower.add("장미");
    flower.add("튤립");
    flower.add("백합"); 
    
    // 요소 수정하기
    flower.set(0, "백일홍");  // 인덱스 0의 요소를 "백일홍"으로 수정
    
    // 요소 삭제하기
    flower.remove(1);  // 인덱스 1의 요소를 삭제
    
    // 요소 확인
    for(int i = 0, length = flower.size(); i < length; i++) {
      System.out.println(flower.get(i));

    }
  }
    
  public static void ex04() {
    
    // 배열을 ArrayList로 바꾸기
    Integer[] a = {10, 20, 30, 40, 50};
    List<Integer> numbers = Arrays.asList(a);
    
    // 주의! 초기화된 ArrayList는 길이를 변경(수정,삭제)할 수 없다.
    // numbers.add(60);   불가능
    // numbers.remove(0); 불가능    
    
   // for문
    for(int i = 0, length = numbers.size(); i < length; i++) {
      System.out.println(numbers.get(i));
    }
           
  }
  
  public static void ex05() {
    
    // ArrayList 초기화
    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
    
    // for문
    for(int i = 0, length = numbers.size(); i < length; i++) {
      System.out.println(numbers.get(i));
    }    
    
  }
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //ex04();
    ex05();
  }

}
