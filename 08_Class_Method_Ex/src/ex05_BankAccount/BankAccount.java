package ex05_BankAccount;

public class BankAccount {
  
  private Bank bank;
  private String accNo;
  private long balance;
  
  public BankAccount(Bank bank, String accNo, long balance) {
    this.bank = bank;
    this.accNo = accNo;
    this.balance = balance;
  }
  
  public BankAccount() {
  }
  
  // Setter
  public void setBank(Bank bank) {
    this.bank = bank;
  }
  
  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }
  
  public void setBalance(long balance) {
    this.balance = balance;
  }
  
  // Getter
  public Bank getBank() {
    return bank;
  }
  
  public String getAccNo() {
    return accNo;
  }
  
  public long getBalance() {
    return balance;
  }
  
  
  public void info() {
   System.out.println("계좌번호 : " + accNo + ", 통장잔액 : " + balance + "원");
   System.out.print("개설지점 : "); 
   bank.info();
  }
  // 입금
  public void deposit(long money) {
    if(money <= 0) {
      return;
    }
    balance += money;
  }
  // 출금
  public long withdrawal(long money) {
    long retValue = 0;
    if(money > 0 && money <= balance) {
      balance -= money;
      retValue = money;
    }
    return retValue;
  }  
  
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money));
  }
  

  
  
  

  }
  


