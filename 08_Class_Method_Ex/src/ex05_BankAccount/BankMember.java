package ex05_BankAccount;

public class BankMember {
  
  private String memberName;
  private BankAccount accNo;
  
  
  public BankMember(String memberName, BankAccount accNo) {
    this.memberName = memberName;
    this.accNo = accNo;        
  }

  public String getMemberName() {
    return memberName;
  }
  
  public BankAccount getAccNo() {
    return accNo;
  }
  
  public void info() {
    System.out.println("고객명 : " + memberName);
    accNo.info();   
    
  }
}
