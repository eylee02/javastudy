package ex03_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainWrapper {
  
  /*
   * Set
   * 1. 인덱스가 없다. 저장 순서가 없다.
   * 2. 중복 저장이 되지 않는다. 여러번 입력을 해도 한번만 저장됨
   */
  
  public static void ex01() {
    
    // Set 인터페이스 타입 선언
    Set<String> season;
    
    // HashSet 클래스 객체 생성
    season  = new HashSet<String>();
    
    // 요소 추가하기
    season.add("봄");
    season.add("여름");
    season.add("가을");
    season.add("겨울");
    season.add("봄");
    
    // 전체 확인
    System.out.println(season);
    
    
  }

  public static void ex02() {

    
    // HashSet 생성 & 생성
    Set<String> hobbies = new HashSet<String>();
    
    // 요소 저장하기
    hobbies.add("독서");
    hobbies.add("요리");
    hobbies.add("운동");
    hobbies.add("체스");
    
    // for문 활용하기 (인덱스가 없으므로 향상 for문)
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }

    
  }
  
  public static void ex03() {
    
    // HashSet 선언 & 생성
    Set<String> flower = new HashSet<String>();
    
    // 요소 저장하기
    flower.add("국화");
    flower.add("장미");
    flower.add("개나리");
    flower.add("수국");
    
    // 반복자 Iterator를 이용한 Set 순회
    Iterator<String> arm = flower.iterator();
    
    /*System.out.println(arm.hasNext());
    System.out.println(arm.next());
    
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
    
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
    
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
    
    System.out.println(arm.hasNext());
    */
    
    // arm.hasNext() 결과값은 값이 있으면 true, 아니면 false
    while(arm.hasNext()) {
      System.out.println(arm.next());
    } 
    
  }
  
  public static void ex04() {
    
    // 동일한 객체 2개  *equals 메소드를 Person클래스에 생성해두지 않으면
    // p1,p2를 다른 객체로 인식하여 같은값이여도 두번 저장이된다
    // Set은 동일한 값이면 한번만 저장
    Person p1 = new Person("홍길동" , 30);
    Person p2 = new Person("홍길동" , 30);
    
    // HashSet 선언 & 생성
    Set<Person> people = new HashSet<Person>();
    
    // 요소 추가
    people.add(p1);
    people.add(p2);
    
    // 확인
    System.out.println(people);
    
    // equals 추가 전 결과값
    // [[Person [name=홍길동, age=30], [Person [name=홍길동, age=30]]
    // equals 추가 후 결과값
    // [Person [name=홍길동, age=30]]
  }
  
  public static void ex05() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 교집합
    set1.retainAll(set2);  // 교집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [3, 4, 5]
    
  }
  
  public static void ex06() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 합집합
    set1.addAll(set2);  // 합집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2, 3, 4, 5, 6, 7]
    
  }
  
  public static void ex07() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 차집합
    set1.removeAll(set2);  // 차집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2]
    
  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    ex04();
    //ex05();
    //ex06();
    //ex07();
  }

}
