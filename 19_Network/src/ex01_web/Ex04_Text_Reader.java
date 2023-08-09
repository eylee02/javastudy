package ex01_web;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ex04_Text_Reader {

  public static void main(String[] args) {
    
    // 웹 상의 텍스트 파일 읽기 (XML)
    // 구글 : "기상청 rss" 검색 - 중기 예보 - 전국 
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    String spec = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
    
    

  }

}