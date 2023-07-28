package ex07_ScoreHandler;

import java.util.HashMap;
import java.util.Map;

public class MainWrapper {

  public static void main(String[] args) {
    
    ScoreHandler handler = new ScoreHandler();
    
    
    Map<String, Object> student1 = new HashMap<String, Object>();
    student1.put("name", "미희");
    student1.put("score", 100);
    handler.addScore(student1);
    
    Map<String, Object> student2 = new HashMap<String, Object>();
    student2.put("name", "영숙");
    student2.put("score", 90);
    handler.addScore(student2);
    
    Map<String, Object> student3 = new HashMap<String, Object>();
    student3.put("name", "순자");
    student3.put("score", 80);
    handler.addScore(student3);
    
    Map<String, Number> map = handler.get();

    
    System.out.println("최댓값 : " + map.get("max"));
    System.out.println("최솟값 : " + map.get("min"));
    System.out.println("합계값 : " + map.get("total"));
    System.out.println("평균값 : " + map.get("average"));
    
    
    

  }

}
