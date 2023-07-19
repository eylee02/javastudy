package ex05_access_modifier;

public class User {

  // field 
  private String id;
  private int age;
  
  // method
  public void setId(String a) {
    id = a;
  }
  
  public String getId() {
    return id;
  }
  
  public void setAge(int b) {
    age = b;
  }
  
  public int getAge() {
    return age;
  }
    
}
