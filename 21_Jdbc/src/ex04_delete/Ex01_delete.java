package ex04_delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connect.DB_Connect;


public class Ex01_delete {

  public static void main(String[] args) {
    
    // 삭제할 사용자 번호(USER_NO) 입력
    Scanner sc = new Scanner(System.in);
    System.out.println("삭제할 USER_NO >>>");
    int user_no = sc.nextInt();
    sc.close();
    
    // Connection 객체 선언 (DB 접속)
    Connection con = null;
    
    // PreparedStatement 객체 선언 (쿼리문 실행)
    PreparedStatement ps = null;
    
    try {
      // Connection 객체 생성 (DB_Connect 클래스의 getConnection 메소드로부터 받아오기) 
      con = DB_Connect.getConnection();
      
      // 쿼리문
      String sql = "";
      sql += "DELETE";
      sql += "  FROM USER_T";
      sql += " WHERE USER_NO = ?";
      
      // PreparedStatement 객체 생성
      ps = con.prepareStatement(sql);
      
      // 쿼리문에 변수 넣기
      ps.setInt(1, user_no);
      
      // 쿼리문 실행
      int deleteResult = ps.executeUpdate();
      
      // 결과
      System.out.println(deleteResult + "행이 삭제되었습니다.");

      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null) ps.close();
        if(con != null) con.close();
     } catch (Exception e) {
       e.printStackTrace();
     }
    }
    

  }

}
