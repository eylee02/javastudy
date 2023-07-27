package ex02_List;

import java.util.ArrayList;
import java.util.List;     // java.util 패키지의 List 클래스

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
  
  public static void main(String[] args) {
    //ex01();
    ex02();
  }

}
