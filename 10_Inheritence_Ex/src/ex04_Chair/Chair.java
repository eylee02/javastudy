package ex04_Chair;

public class Chair {
  
  // Person, Student, Alba 객체를 모두 저장할 수 있다. (upcasting)
  private Person person;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {  // upcasting이 수행되는 시점 new Student(...)
    this.person = person;
  }    
      
}
