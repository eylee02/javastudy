package ex02_Computer;

public class NoteBook extends Computer {
  
  
  private int battery;
  
  public NoteBook(String model, int battery) {
    super(model);      // Computer의 생성자 호출, 반드시 먼저 호출해야함!
    this.battery = battery;
  }
  
  public int getBattery() {
    return battery;
  }
  
  public void setBattery(int battery) {
    this.battery = battery;
  }
  

}
