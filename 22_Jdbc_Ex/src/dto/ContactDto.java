package dto;

public class ContactDto {
  
  private int contact_no;
  private String name;
  private String tel;
  private String email;
  private String address;
  private String created_at;
  
  public ContactDto() {
    // TODO Auto-generated constructor stub
  }

  public ContactDto(int contact_no, String name, String email, String tel, String address, String created_at) {
    super();
    this.contact_no = contact_no;
    this.name = name;
    this.tel = tel;
    this.email = email;
    this.address = address;
    this.created_at = created_at;
  }

  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getContact_no() {
    return contact_no;
  }

  public void setContact_no(int contact_no) {
    this.contact_no = contact_no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  @Override
  public String toString() {
    return "ContactDto [contact_no=" + contact_no + ", name=" + name + ", tel=" + tel + ", email=" + email
        + ", address=" + address + ", created_at=" + created_at + "]";
  }

  
  


}