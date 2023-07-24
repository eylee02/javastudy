package ex04_override;

/*
 * 메소드 오버라이드(method override)
 * 1. 슈퍼 클래스의 메소드를 서브 클래스가 다시 만드는 것을 말한다. (메소드 덮어쓰기)
 * 2. 오버라이드 하는 메소드는 @Override Annotation을 추가하는 것이 좋다. (권장이지만 필수도 하자.) 
 * 3. 반드시 동일한 모습으로 오버라이드 해야 한다.
 */

/*
 * 메소드 오버로딩은 같은이름의 메소드를 여러개 생성할수있지만 파라미터는 모두 달라야한다
 * 메소드 오버라이딩은 슈퍼클래스의 메소드를 서브클래스에서 재생성하는것으로 이름,파라미터 타입모두 같아야한다.
 */

public class CafeLatte extends Espresso{
  
  @Override   // 오버라이드 한 메소드 , 문법 체크를 해 준다.
  public void taste() {
    System.out.println("라떼 맛");    
  }

}
