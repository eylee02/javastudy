package ex07_Object;

import java.util.Objects;

/*
 * 패키지명[java.lang] 클래스명[Object]
 * java.lang.Object 클래스
 * 1. 모든 클래스의 최상위 슈퍼 클래스이다.
 * 2. 별도의 슈퍼 클래스를 명시하지 않은 클래스들은(extends가 없는 클래스) 모두 Object 클래스의 서브 클래스이다.
 * 3. 모든 것을 저장할 수 있는 Java의 만능 타입이다.
 * 4. Object 타입으로 저장하면 Object 클래스의 메소드만 호출할 수 있다. 이를 해결하기 위해서 "반드시" 캐스팅을 해야 한다.
 */

/*
 *  ┌--------------┐
 *  │    Object    │ 슈퍼 클래스
 *  │--------------│
 *  │  equals()    │ 두 객체의 참조값을 비교해서 같으면 true, 아니면 false를 반환한다.
 *  │  getClass()  │ 어떤 클래스인지 반환
 *  │  hashCode()  │ int 타입의 해시코드값, Object 클래스는 객체의 참조값을 해시코드값으로 사용함 
 *  │  toString()  │ "클래스이름@참조값" 형식의 문자열을 반환 (결과값예시 ex07_Object.Person@33a49db)
 *  │  notify()    │ 스레드(thread) 관련 메소드
 *  │  wait()      │ 스레드(thread) 관련 메소드
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │    Person    │ 서브 클래스
 *  │--------------│
 *  │  @Override   │ 모든 객체 비교는 equals 메소드를 사용
 *  │  equals()    │ 이름과 나이가 같으면 true, 아니면 false 반환한다. (하드코딩하지 않고, 자동완성한다.)
 *  │              │
 *  │  @Override   │ 모든 객체 출력은 toString 메소드를 사용
 *  │  toString()  │ 이름과 나이를 확인할 수 있는 문자열 반환 (하드코딩하지 않고, 자동완성한다.)
 *  └--------------┘ 
 */

public class Person {
  
  private String name;
  private int age;
  
  // new Person
  public Person() {
    
  }  
  // new Person("홍길동", 20)
  public Person(String name, int age) {
    this.name = name;
    this.age = age;   
  }
  
  
  
  // Source 메뉴로 자동 Override
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)  // p1.equals(p1)
      return true;
    if (obj == null)  // p1.equals(null)
      return false;
    if (getClass() != obj.getClass())  // p1.equals(s1)  클래스가다른경우
      return false;
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }
  
  // toString 자동 오버라이드 
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }    

}
