package ex01_generic;

public class MainWrapper {

  public static void main(String[] args) {
    
    // String을 저장하는 box1
    Box<String> box1 = new Box<String>();
    box1.setItem("hello world");
    System.out.println(box1.getItem());
    
    // int를 저장하는 box2
    // 오직 "참조타입"만 Generic 처리에서 사용할 수 있다.
    // int의 참조타입인 Integer를 사용한다.
    // 참조타입 01_Varialble 프로젝트 ex01에 정리해둠
    Box<Integer> box2 = new Box<Integer>();
    box2.setItem(10);
    System.out.println(box2.getItem());
    
    // Person을 저장하는 box3
    Box<Person> box3 = new Box<Person>();
    box3.setItem(new Person("고길동"));
    System.out.println(box3.getItem());
    
    
    
    
  }

}
