package main.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Handyman implements Serializable
{
  private long CVR;
  private String firstName;
  private String lastName;
  private String description;
  private String email;
  private String phone;
  private Address address;
  private int hourlyRate;
  private Skills skills;
  private String rating;

  private static final long serialVersionUID = 2L;

  public Handyman(long CVR, String firstName, String lastName, String email,
      String phone, String description, Address address,
      int hourlyRate, Skills skills, String rating)
  {
    this.CVR = CVR;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.description = description;
    this.address = address;
    this.hourlyRate = hourlyRate;
    this.skills = skills;
    this.rating = rating;
  }

  public void setAddress(Address tmpAddress){
    this.address = tmpAddress;
  }

  public Skills getSkills(){
    return skills;
  }

  public ArrayList<String> getSkillsList(){return skills.getSkills();}

  public void setSkills(Skills skills){
    this.skills=skills;
  }

  public void setSkillsFromList(ArrayList<String> list){this.skills.setSkills(list);}


  public void setCVR(int CVR) {
    this.CVR = CVR;
  }
  public long getCVR() {
    return CVR;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public void setEmail(String email){this.email = email;}
  public String getEmail(){return email;}

  public void setPhone(String phone){this.phone = phone;}
  public String getPhone(){return phone;}

  public void setDescription(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }

  public Address getAddress(){return address;}

  public void setHourlyRate(int hourlyRate){this.hourlyRate = hourlyRate;}
  public int getHourlyRate(){return hourlyRate;}

  public void setRating(String rating){this.rating = rating;}
  public String getRating(){return rating;}


  public boolean equals(Object obj) {
    if (!(obj instanceof Handyman))
      return false;
    Handyman other = (Handyman) obj;
    return CVR==other.CVR;
  }
}
