package ex03_Soldier;

public class Soldier {

  private Gun gun;
  
  // 생성자 메소드
  public Soldier(int bullet) {   
    gun = new Gun(bullet);     
  }
  
  public Soldier(Gun gun) {
    this.gun = gun;  
  }
  
  
  
  public void reload(int bullet) {
    gun.reload(bullet);
  }
  
  public void shoot() {
    gun.shoot();
  }
  
  
  
  
}
