package naver.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;



public class NaverApiSearchBook {
  
  private void generateImage(String spec) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    
    try {
      
      // 파라미터 String spec에는 다운로드 받을 이미지 파일의 URL이 전달된다.
      // 해당 URL의 이미지 파일을 다운로드 받는다.
      url = new URL(spec);      
      con = (HttpURLConnection)url.openConnection();
      
      bin = new BufferedInputStream(con.getInputStream());
      
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      String fileName = spec.substring(spec.lastIndexOf("/") + 1);  // 파일이름을 이미지주소에서 추출
      File file = new File(dir, fileName);
      
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      byte[] b = new byte[1024];      
      int readByte = 0;      
      while((readByte = bin.read(b)) != -1) {   // 이미지파일의 String값을 다 byte[]로 읽어서 저장시킨다
        bout.write(b, 0, readByte);    
      }
      
      System.out.println(file.getPath() +  "파일 다운로드 완료");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public void getSearchList() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      // 책 검색 OpenAPI를 사용해서 응답 결과 중 이미지(image) 결과만 추출하여
      // generateImage 메소드에 전달한다.
      // 10번의 generateImage 메소드 호출이 필요하다.
      String clientId = "RTJMyHb54a63lvLzPh7A";
      String clientSecret = "0xR9yv0oo3";
      
      Scanner sc = new Scanner(System.in);
      System.out.println("책 관련 검색어를 입력하세요 >>>");
      String query = sc.nextLine();
      query = URLEncoder.encode(query, "UTF-8");  // 쿼리 입력값을 인코딩먼저함
      sc.close();
      
      String spec = "https://openapi.naver.com/v1/search/book.json?query=" + query;      
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
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
      
      JSONObject obj = new JSONObject(sb.toString());
      JSONArray items = obj.getJSONArray("items");
      for(int i = 0, length = items.length(); i < length; i++) {
        JSONObject item = items.getJSONObject(i);
        String image = item.getString("image");  // 이미지의 주소를 문자열 image에 저장
        generateImage(image);  // generatImage 메소드의 파라미터로 image 문자열 보내기
      }
  
      
    } catch (Exception e) {
      
      // 예외 발생 시 로그파일을 만든다.  (파일먼저 생성 후 오류메세지 발생 시 파일에 기록하고 작성되었다는 메세지 출력
      File dir = new File("C:/download/log");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "log.txt");
      
      try (PrintWriter out = new PrintWriter(new FileWriter(file, true))) {
      
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a h:mm:ss");
      String time = dtf.format(now);
      
      String message = e.getMessage();
      
      out.println(time + "," + message);  // 시간정보와 오류메세지를 출력
     
        System.out.println(file.getPath() + "파일에 로그가 작성되었습니다.");
        
      } catch(IOException e2) {
        e2.printStackTrace();
      }
      } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
}