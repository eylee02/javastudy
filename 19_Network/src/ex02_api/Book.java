package ex02_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class Book {

  public static void main(String[] args) {
    
    
    /*
     * 네이버개발자센터 - 검색(책)
     * 1. 요청주소 : https://openapi.naver.com/v1/search/book.json
     * 2. 요청변수 : 
     *    1) query(String) : 필수, 인코딩된 검색어
     *    2) display(integer) : 선택, 기본값10, 최댓값 100
     *    3) start(integer) : 선택, 기본값1, 최댓값 100
     *    4) sort(String) : 선택, sim (sim 또는 date)
     */
    
    URL url =null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
   try { 
    
    String spec = "https://openapi.naver.com/v1/search/book.json";
    String query = "인어공주";
    Integer display = 10;
    Integer start = 1;
    String sort = "sim";
    String clientId = "RTJMyHb54a63lvLzPh7A";
    String clientSecret = "0xR9yv0oo3";
    
    StringBuilder sbUrl = new StringBuilder();
    sbUrl.append(spec);
    sbUrl.append("?query=").append(URLEncoder.encode(query, "UTF-8"));
    sbUrl.append("&display=").append(display);
    sbUrl.append("&start=").append(start);
    sbUrl.append("&sort=").append(sort);
    
    url = new URL(sbUrl.toString());
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
      System.out.println((i + 1) + "번째 책 검색 결과");
      System.out.println("책 제목: " + item.getString("title"));
      System.out.println("링크: " + item.getString("link"));
      System.out.println("표지: " + item.getString("image"));
      System.out.println("저자: " + item.getString("author"));
      System.out.println("출판사: " + item.getString("publisher"));    

    }
    } catch (Exception e) {
      System.out.println(e.getMessage());
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
