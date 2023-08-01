package ex02_Soldier;

public class Soldier {

  private Gun gun;
  
  // 생성자 메소드
  public Soldier(int bullet) {   
    gun = new Gun(bullet);     
  }
  
  public Soldier(Gun gun) {
    this.gun = gun;  
  }
  
  public void reload(int bullet) throws RuntimeException {
    gun.reload(bullet);
  }
  
  public void shoot() throws RuntimeException {
    gun.shoot();
  }
  
  
  
  
}
