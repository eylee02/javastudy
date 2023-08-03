package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainWrapper {
  
  /*
   * java.io.OutPutStream 클래스
   * 1. 바이트 기반의 출력 스트림이다.
   * 2. 출력 단위
   *    1) int
   *    2) byte[]    바이트배열
   * 3. 출력스트림은 여러번 실행해도 덮어쓰기가된다.
   */
  
  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("c:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    
    // 파일출력스트림 선언
    FileOutputStream fout = null;
    
    try {
      
     //파일출력스트림 생성 (반드시 예외 처리가 필요한 코드)
    fout = new FileOutputStream(file);
    
    // 출력할 데이터 (파일로 보낼 데이터)
    int c = 'A';              //int
    String s = "pple";
    byte[] b = s.getBytes();  // byte[] : String을 byte[]로 변환
    
    // 출력(파일로 데이터 보내기)
    fout.write(c);
    fout.write(b);
    
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fout != null) {
          fout.close();  // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트" );
    
  }
  
  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 "안녕하세요" 보내기, 파일 크기 확인
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    File file = new File(dir, "ex02.dat");
    
    FileOutputStream fout = null;
    
    try { 
      fout = new FileOutputStream(file);
      
      String s = "안녕하세요";
      byte[] b = s.getBytes("UTF-8");
      
      fout.write(b);
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(fout != null ) {
          fout.close(); 
        } 
      } catch(IOException e) {
        e.printStackTrace();
      }
      System.out.println(file.getPath() + "파일 크기: " + file.length() + "바이트");
    }   
  }
  
  public static void ex03() {
    
    /*
     * java.io.BufferedOutPutStream 클래스
     * 1. 내부 버퍼를 가지고 있는 출력스트림이다.
     * 2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    // 2줄로 안녕하세요 \n 반갑습니다
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "ex03.dat");
    
    // 버퍼출력스트림 선언
    BufferedOutputStream bout = null;
    
    try {
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      String s1 = "안녕하세요";
      String s2 = "\n반갑습니다";    
           
      bout.write(s1.getBytes("UTF-8"));  // byte 배열을 따로 만들지않고 데이터보내기에서 처리
      bout.write(s2.getBytes("UTF-8"));
      //bout.write(s2.getBytes(StandardCharsets.UTF-8));  getBytes("UTF-8")과 동일하다.
      
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
      if(bout != null) {
        bout.close();
      }
      } catch(IOException e) {
        e.printStackTrace();
      }
      System.out.println(file.getPath() + "파일 크기 : " + file.length() + "바이트");
    }
    
  }
  


  public static void main(String[] args) {
    ex03();
    
    
  }

}
