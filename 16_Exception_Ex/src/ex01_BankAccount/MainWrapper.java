package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {
    
    try {
    BankAccount acc = new BankAccount(10000, "1234");
    BankAccount acc2 = new BankAccount(20000, "5678");
    //   acc.deposit(-1);  -1원 입금 불가
    //long money = acc.withdrawal(50000);
   // System.out.println("출금액: " + money);
    acc.deposit(10000);
    acc2.withdrawal(5000);
    acc.transfer(acc2, 1);
    acc.inquiry();
    acc2.inquiry();
    } catch(RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

}
