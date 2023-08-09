package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex04_Naver_Captcha {
  
  private static final String CLIENT_ID="n23Sahbp0fmkWfStEsou";
  private static final String CLIENT_SECRET="JJjndHwS_u";
  
  // main에서 호출하기위해 static 작성  나중에 사용할때는 없이사용
  private static String getKey() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      String spec = "https://openapi.naver.com/v1/captcha/nkey?code=0";
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");
      }
      
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      
      System.out.println(sb.toString());
      
      JSONObject obj = new JSONObject(sb.toString());
      result = obj.getString("key");
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
      return result;
  }

  private static String getImage() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    String key = null;   
    
    try {
    
    key = getKey();   
    String spec = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
    
    url = new URL(spec);
    con = (HttpURLConnection)url.openConnection();
    
    con.setRequestMethod("GET");
    con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
    con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
    int responseCode = con.getResponseCode();
    if(responseCode != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(responseCode + " 발생");
    }
    
    bin = new BufferedInputStream(con.getInputStream());
    
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    File file = new File(dir, System.currentTimeMillis() + ".jpg");  // 타임스탬프로 파일이름 저장(중복발생방지)
    bout = new BufferedOutputStream(new FileOutputStream(file));
    
    byte[] b = new byte[1024];
    int readByte = 0;
    while((readByte = bin.read(b)) != -1) {  // 읽은내용은 b에 저장
      bout.write(b, 0, readByte);
    }
    
    System.out.println(file.getPath() + "파일 생성 완료");
    
    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
    return key;
  }
  
  private static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
    String key = getImage();  // 이미지실행먼저
    
    Scanner sc = new Scanner(System.in);
    System.out.println("입력 >> ");
    String value = sc.next();
    
    String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
    
    url = new URL(spec);
    con = (HttpURLConnection)url.openConnection();
    
    con.setRequestMethod("GET");
    
    con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
    con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
    int responseCode = con.getResponseCode();
    if(responseCode != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(responseCode + " 발생"); 
    }
    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
    
    StringBuilder sb = new StringBuilder();
    String line = null;
    while((line = reader.readLine()) != null) {
      sb.append(line);
    }
    
    JSONObject obj = new JSONObject(sb.toString());   // String을 json으로 변환
    System.out.println("응답시간: " + obj.getDouble("responseTime"));
    if(obj.getBoolean("result")) {  // result 값은 true가 기본값 (네이버 응답예에있음)
      System.out.println("맞습니다.");      
    } else {
      System.out.println("틀렸습니다.");
    }

    } catch(Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect(); 
      } catch(Exception e) {
        e.printStackTrace();
      }
    }    
    
  }

  public static void main(String[] args) {
    //getImage();
    validInput();
    
  }

}
