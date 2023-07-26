package ex10_Walkable;

public class Animals {
  
  private String name;
  
  public Animals(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Animals [name=" + name + "]";
  }
  
  

}
