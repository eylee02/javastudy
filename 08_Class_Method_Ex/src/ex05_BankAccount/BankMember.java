package ex05_BankAccount;

public class BankMember {
  
  private String memberName;
  private BankAccount acc;
  
  
  public BankMember(String memberName, BankAccount acc) {
    this.memberName = memberName;
    this.acc = acc;        
  }
  
  public BankMember() {
    
  }
  
  // Setter
  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }
  
  public void setAcc(BankAccount acc) {
    this.acc = acc;
  }
  
  // Getter
  public String getMemberName() {
    return memberName;
  }
  
  public BankAccount getAcc() {
    return acc;
  }
  
  public void info() {
    System.out.println("고객명 : " + memberName);
    acc.info();      
  }
  
  
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  public long withdrawal(long money) {
    return acc.withdrawal(money);
  }
  
  public void transfer(BankMember member, long money) {
    member.deposit(withdrawal(money));
  }
  
  

  
}
