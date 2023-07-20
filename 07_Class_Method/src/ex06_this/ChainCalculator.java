package ex06_this;

/*
 * this
 * 1. 필드나 메소드를 호출하는 객체의 참조값이다.
 * 2. 클래스 내부에서만 사용할 수 있는 키워드이다.
 * 3. 필드와 파라미터 이름이 동일한 경우 this를 붙여주면 구분이 가능해진다(필드값에 붙여준다)
 */

/**
 * <p>메소드를 연속해서 호출할 수 있는 메소드 체이닝(method chaining)이 가능한 계산기</p> 
 * <p>사칙연산 메소드를 연속해서 호출할 수 있다.</p>
 * @author 홍길동
 * @since 20230.07.20
 * @version 1.0
 */
public class ChainCalculator {
  
  /**
   * 필드 value는 사칙연산 결과를 저장하고 있다.
   */
  private double value;
  
  public void printThis() {
    System.out.println("현재 객체(printThis 메소드를 호출한 객체)의 참조값 : " + this);
  }
  
  // Setter
  public void setValue(double value) {
    this.value = value;
  }
  
  // Getter
  public double getValue() {
    return value;
  }
  
  public ChainCalculator on () {
    System.out.print(value); 
    return this;
  }
  
  public ChainCalculator addition(double a) {
    value += a;
    System.out.print("+" + a);
    return this;      // myCalc 객체를 반환한다.
  }
  
  public ChainCalculator subtraction(double a) {
    value -= a;
    System.out.print("-" + a );
    return this;
  }
  
  public ChainCalculator multiplication(double a) {
    value *= a;
    System.out.print("x" + a);
    return this;
  }
  
  public ChainCalculator division(double a) {
    value /= a;
    System.out.print("/" + a);
    return this;
  }
    
  public void done() {
    System.out.println("=" + value);
  }
  
}
