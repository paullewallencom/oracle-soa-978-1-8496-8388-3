package soa.cookbook.model;

import java.io.Serializable;

public class Employee implements Serializable{
  public Employee() {
    super();
  }
  
  public Employee(String name, long eNum, Address address, String phone) {
    this.name = name;
    this.eNum = eNum;
    this.address = address;
    this.phone = phone;
  }
  
  private String name;
  private long eNum;
  private Address address;
  private String phone;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }

  public void setENum(long eNum) {
    this.eNum = eNum;
  }

  public long getENum() {
    return eNum;
  }
}
