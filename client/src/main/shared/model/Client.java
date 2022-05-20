package main.shared.model;

import java.io.Serializable;

public class Client implements Serializable
{
  private  long CPR;
  private  String firstName;
  private  String lastName;
  private  String email;
  private Address address;
  private String description;

  private static final long serialVersionUID = 1L;

  public Client(long CPR, String firstName, String lastName, String email, Address address, String description) {
    this.CPR = CPR;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.description = description;
  }

  public long getCPR() {
    return CPR;
  }
  public void setCPR(int CPR) {
    this.CPR = CPR;
  }

  public  String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public  String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email){this.email = email;}
  public  String getEmail(){return email;}

  public Address getAddress(){return address;}

  public void setAddress(Address address){
    this.address = address;
  }

  public String getDescription(){return description;}
  public void setDescription(String description){this.description = description;}




  public boolean equals(Object obj) {
    if (!(obj instanceof Client))
      return false;
    Client other = (Client) obj;
    return CPR==other.CPR;
  }
}
