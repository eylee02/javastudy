package connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB_Connect {

  public static Connection getConnection() {
    
    // Connection 객체 선언
    Connection con = null;
   
    // try-catch-resource문 사용
    // 입력스트림 선언&생성
    try (BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))) {
      
      // oracle.jdbc.OracleDriver 클래스 load
      Class.forName("oracle.jdbc.OracleDriver");
      
      // 프로퍼티파일을 객체로 로드
      Properties p = new Properties();
      p.load(reader);
      
      // Connection 객체 생성 & 프로퍼티객체의 프로퍼티 가져오기
      con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    // Connection 객체를 반환
    return con;
  }
  

  
  
  
}
