package ex07_constructor;

public class MainWrapper {

  public static void main(String[] args) {
    
    // Computer myCom 객체 선언
    Computer myCom;
    
    //Computer myCom 객체 생성
    myCom = new Computer();  // public Computer(){} 생성자가 호출된다.
    
    myCom.setModel("mac");
    System.out.println("myCom: " + myCom.getModel());
    
    
    // Computer yourCom 객체 선언
    Computer yourCom;
    
    // Computer yourCom 객체 생성
    yourCom = new Computer("macbook");   // public Computer(String model){} 생성자가 호출된다. setter 의 역할도 같이 수행하는 생성자메소드 호출
    
    System.out.println("yourCom : " + yourCom.getModel());
    
  }

}
