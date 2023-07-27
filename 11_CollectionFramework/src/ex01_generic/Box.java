package ex01_generic;

public class Box<T> {  // T는 String타입
  
  private T item;

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
    
}
