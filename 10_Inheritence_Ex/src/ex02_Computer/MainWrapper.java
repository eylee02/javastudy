package ex02_Computer;

public class MainWrapper {

  public static void main(String[] args) {
    
    NoteBook notebook = new NoteBook("gram", 70);
    System.out.println(notebook.getModel());  // gram
    System.out.println(notebook.getBattery());  // 70
    

  }

}
