package ex03_Bus;

public class MainWrapper {

  public static void main(String[] args) {
    
    Bus bus = new Bus();
    
    bus.getOn(1, new Person("가길동"));   // 첫 좌석
    bus.getOn(25, new Person("나길동"));  // 마지막 좌석
    bus.getOn(25, new Person("다길동"));  // 오류 메세지 출력
    bus.getOn(30, new Person("홍길동"));  // 오류 메세지 출력
    
    bus.getOff(1);
    bus.getOff(10);  // 오류 메세지 출력
    bus.getOff(30);  // 오류 메세지 출력
    
    bus.info();  // 전체 좌석 출력

  }

}
