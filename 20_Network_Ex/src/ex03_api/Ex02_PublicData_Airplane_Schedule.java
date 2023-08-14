package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ex02_PublicData_Airplane_Schedule {
  
  /*
   * 한국공항공사_항공기 운항정보 - 국제선 운항 스케줄
   * 1. 요청주소 : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
   * 2. 요청변수 (Request Parameter)
   *    1) serviceKey       : 필수, 인코딩된 인증키
   *    2) pageNo           : 필수, 1
   *    3) schDate          : 선택, 검색일자, 20151005
   *    4) schDeptCityCode  : 선택, 출발도시코드(GMP)
   *    5) schArrvCityCode  : 선택, 도착도시코드(HND)
   */
  public static void ex01() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;  // 응답데이터를 읽는 입력스트림
    
    try {
      
      String spec = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
      String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
      String pageNo = "1";
      String schDate = new SimpleDateFormat("YYYYMMDD").format(new Date());  // 현재날짜를 YYYYMMDD 형식으로 반영
      String schDeptCityCode = "ICN";
      String schArrvCityCode = "JFK";
      
      StringBuilder sb = new StringBuilder();
      sb.append(spec);
      sb.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
      sb.append("&pageNo=" + URLEncoder.encode(pageNo, "UTF-8"));
      sb.append("&schDate=" + URLEncoder.encode(schDate, "UTF-8"));
      sb.append("&schDeptCityCode=" + URLEncoder.encode(schDeptCityCode, "UTF-8"));
      sb.append("&schArrvCityCode=" + URLEncoder.encode(schArrvCityCode, "UTF-8"));
      
      url = new URL(sb.toString());
      con = (HttpURLConnection) url.openConnection();
      
      con.setRequestMethod("GET");   // 생략 가능
      
      int responseCode = con.getResponseCode();
      if(responseCode == HttpURLConnection.HTTP_OK) {
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  // code가 200일 때
      } else {
        reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));  // code가 200 이외 일 때
      }
      
      StringBuilder responseBody = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        responseBody.append(line + "\n");
      }
      
      File dir = new File("C:/storage");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      
     File file = new File(dir, "국제선운항스케줄.xml");
     
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
       writer.write(responseBody.toString());
       writer.flush();
     } catch (Exception e) {
       e.printStackTrace();
     }
     
     System.out.println(file.getPath() + " 파일 생성 완료");

    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch(Exception e) {
        e.printStackTrace();
      }
    } 
  }
  
  /*
   * org.w3c.dom.Document : XML문서
   * org.w3c.dom.Node     : 구성요소(Element의 부모)
   * org.w3c.dom.Element  : 구성요소(Node의 자식)
   */
  public static void ex02() {
    
    try {
      
      // File
      File dir = new File("C:/storage");
      File file = new File(dir, "국제선운항스케줄.xml");
      
      // Document
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  // factory 먼저
      DocumentBuilder builder = factory.newDocumentBuilder();                 // builder는 factory 만든 후 
      Document document = builder.parse(file);                                // document가 맨마지막
      
      // root (최상위 요소)
      Element root = document.getDocumentElement();      
      //System.out.println(root.getNodeName());    결과값 response
      
      // root 자식 노드들 (<header>, <body>)
      NodeList nodes = root.getChildNodes();  // 반환타입이 NodeList
      
      // root 1번째 자식 노드
      Node header = nodes.item(0);
      System.out.println(header.getNodeName());  // 결과값 header
      
      // root 2번째 자식 노드
      Node body = nodes.item(1);
      System.out.println(body.getNodeName());   // 결과값 body
      
      // body의 자식 노드들 (<items>, <numOfRows>, <pageNo>, <totalCount>)
      NodeList bodychild = body.getChildNodes();
  
      // body의 1번째 자식 노드      item에 저장된 값 출력
      Node items = bodychild.item(0);
      System.out.println(items.getNodeName() + " : ");
      for(int i = 0; i < items.getChildNodes().getLength(); i++) {
        Node item = items.getChildNodes().item(i);
        System.out.println("  " + item.getNodeName() + " : ");
        for(int j = 0; j < item.getChildNodes().getLength(); j++) {
          Node itemChild = item.getChildNodes().item(j);
          System.out.println("    " + itemChild.getNodeName() + " : " + itemChild.getTextContent());
        }
      }
      
      // body의 2번째 자식 노드
      Node numOfRows = bodychild.item(1);             // <numOfRows>10</numOfRows>
      System.out.println(numOfRows.getNodeName());    // numOfRows
      System.out.println(numOfRows.getTextContent()); // 10  태그내부의 TextContent
      
      // body의 3번째 자식 노드
      Node pageNo = bodychild.item(2);                // <pageNo>1</pageNo>
      System.out.println(pageNo.getNodeName());       // pageNo
      System.out.println(pageNo.getTextContent());    // 1
      
      // body의 4번째 자식 노드                      
      Node totalCount = bodychild.item(3);             // <totalCount>4</totalCount>  
      System.out.println(totalCount.getNodeName());    // totalCount
      System.out.println(totalCount.getTextContent()); // 4
   
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  /*
   * org.json.XML : json 라이브러리에서 지원하는 XML 클래스 (XML -> JSON)
   */
  public static void ex03() {
    
    // File
    File dir = new File("C:/storage");
    File file = new File(dir, "국제선운항스케줄.xml");
    
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      
      
      // XML -> JSOM
      JSONObject obj = XML.toJSONObject(reader);
 
      // <response>                    response: {
      //   <body>                        body: {
      //    <items>                        items: { 
      //       <item> ... </item>            item:  [{ },{ },{ },{ },]
      //       <item> ... </item>            
      //       <item> ... </item>            
      //       <item> ... </item>            
      //    </items>
      
      JSONArray items = obj.getJSONObject("response")
                           .getJSONObject("body")
                           .getJSONObject("items")
                           .getJSONArray("item");
      
      for(int i = 0; i < items.length(); i++) {
        // JSONObject obj2 = items.getJSONObject(i);
        // Map<String, Object> item = obj2.toMap();
        Map<String, Object> item = items.getJSONObject(i).toMap();
        for(Entry<String, Object> entry : item.entrySet()) {
          System.out.println(entry.getKey() + ":" + entry.getValue());
        }
      }     
            
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    ex03();

  }

}
