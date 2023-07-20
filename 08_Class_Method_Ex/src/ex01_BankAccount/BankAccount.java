package ex01_BankAccount;

/**
 * 입금, 출금, 계좌조회, 계좌이체 기능을 제공하는 클래스
 * @author 홍길동
 * @since 2023.07.19
 * @version 1.0 
 */
public class BankAccount {
  
  /**
   * long balance 이 필드는 계좌 잔액이다.<br>
   * 초깃값으로 0
   */
  private long balance;
  
  /**
   * String accNo 이 필드는 계좌 번호이다.<br>
   * 초깃값으로 null
   */
  private String accNo;
  
  /**
   * 계좌번호와 통장잔액을 조회하는 메소드
   */
  public void inquiry() {
    System.out.println("계좌번호 : " + accNo);
    System.out.println("통장잔액 : " + balance + "원");
  }    
  
  /**
   * 입금 메소드<br>
   * 파라미터가 0보다 작으면 동작하지 않는다
   * @param money 입금할 금액
   */
  public void deposit(long money) {
    if(money <= 0) {
      return;   // 메소드 종료
   }
    balance += money;
  }
  
  /**
   * 출금 메소드<br>
   * 파라미터가 0보다 작거나 같으면 출금된 금액이 없으므로 0을 반환한다.<br>
   * 파라미터가 통장잔액(balance)보다 크면 출금된 금액이 없으므로 0을 반환한다.
   * @param money 출금할 금액
   * @return 실제로 출금된 금액
   */
  public long withdrawal(long money) {
    long retVal = 0;  //return value 변수 지정
    if(money <= 0 || money > balance) {
      retVal = 0;
  } else {
    balance -= money;
    retVal = money;
  }
    return retVal;   // 출금된 경우 출금액을 반환한다
  }
  /**
   * 이체 메소드<br>
   * 다른 계좌로 이체하는 메소드로 기존의 입금 메소드와 출금 메소드를 활용한다.<br>
   * 내 계좌에서 출금을 먼저 수행하고, 출금된 금액만큼 다른 계좌로 입금한다.
   * @param acc   다른 계좌
   * @param money 이체할 금액
   */
  public void transfer(BankAccount acc, long money) {    
    acc.deposit(withdrawal(money));    // 출금 먼저한 후 계좌에 입금처리  
  }    
  
  
  // 세터 메소드
  public void setBalance(long balacnce) {
    this.balance = balacnce;
  }
  
  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }
  
  //게터 메소드
  public long getBalance() {
    return balance;
  }
  
  public String getAccNo() {
    return accNo;
  }
  

  
}
