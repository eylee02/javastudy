package ex07_Car;

public class Driver {
  
  private String name;
  private int career;
  private boolean bestDriver;  // 기준 career가 10년 이상이면 true
  
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getCareer() {
    return career;
  }
  
  public void setCareer(int career) {
    this.career = career;
    setBestDriver(career >= 10);
  }
  
  public boolean isBestDriver() {   // boolean 타입의 getter는 is로 작성한다.
    return bestDriver;
  }
  
  private void setBestDriver(boolean bestDriver) {
    this.bestDriver = bestDriver;
  }

}
