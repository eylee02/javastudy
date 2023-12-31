package ex03_update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connect.DB_Connect;
import dto.UserDto;

public class Ex01_update {

  public static void main(String[] args) {
    
    // 수정할 사용자 번호(USER_NO) 입력
    Scanner sc = new Scanner(System.in);
    System.out.println("수정할 USER_NO >>>");
    int user_no = sc.nextInt();
    sc.nextLine();
    System.out.println("수정할 USER_NAME >>>");
    String user_name = sc.next();
    sc.close();
    
    // UserDto 객체 생성
    UserDto user = new UserDto();
    user.setUser_no(user_no);
    user.setUser_name(user_name);
    
    Connection con = null;
    
    PreparedStatement ps = null;
    
    try {
      
      con = DB_Connect.getConnection();
      
      String sql = "";
      sql += "UPDATE USER_T";
      sql += "   SET USER_NAME = ?";
      sql += " WHERE USER_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      ps.setString(1, user.getUser_name());  // sql 문에서의 ? 순번으로 작성
      ps.setInt(2, user.getUser_no());
      
      int updateResult = ps.executeUpdate();
      
      System.out.println(updateResult + "행이 수정되었습니다.");
 
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
