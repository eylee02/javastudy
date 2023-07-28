package ex06_BinaryNumber;

import java.util.ArrayList;
import java.util.List;

public class BinaryNumber {
  
  /* 10진수 */ @SuppressWarnings("unused") private int number; 
  /* 2진수 */  private List<Integer> binary; 
  
  /// new BinaryNumber(32)  2진수 : 100000
  public BinaryNumber(int number) {
    // binary.get(0) : 0
    // binary.get(1) : 0
    // binary.get(2) : 0
    // binary.get(3) : 0
    // binary.get(4) : 0
    // binary.get(5) : 1
    this.number = number;
    binary = new ArrayList<Integer>();  // binary필드값 배열선언&생성
    if(number == 0) { 
      binary.add(0);      
    } else {
    while(number > 0) {
      binary.add(number % 2); // binary 배열에 2로나눈 나머지값을 차례로 입력
      number /= 2;  
    }
    }
  }
  
  // BinaryNumber bn = new BinaryNumber(32);
  // System.out.println(bn); // 1000000
  @Override
  public String toString() {
    String result = "";
    for(int i = binary.size() - 1; i >= 0; i--) {  // 출력된 값을 맨뒤부터 차례로 출력
      result += binary.get(i);
    }
    return result;
  }
  
}
