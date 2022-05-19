package main.shared.model;

import java.io.Serializable;

public class Address implements Serializable
{
  private String city;
  private String zip;


  public Address(String city, String zip) {
    setAddress(city,zip);
  }

  public void setAddress(String city, String zip){
    this.city = city;
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }
}
