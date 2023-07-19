package ex05_access_modifier;

public class MainWrapper {

  public static void main(String[] args) {
    
    User u = new User();    // User클래스를 객체선언
    
    u.setId("admin");       // User클래스의 setId 메소드에 값입력
    System.out.println(u.getId());  // getId 메소드 리턴값으로 출력
    
   u.setAge(30); 
   System.out.println(u.getAge());
  }

}
