package main.shared.model;

import java.io.Serializable;

public class Address implements Serializable
{
  private String city;
  private String zip;

  private static final long serialVersionUID = 8304845500963165000L;

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

  public boolean equals(Object o) {

    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
    if (!(o instanceof Address)) {
      return false;
    }

    // typecast o to Complex so that we can compare data members
    Address address = (Address) o;

    // Compare the data members and return accordingly
    return this.getZip().equals(address.getZip()) && this.getCity().equals(address.getCity());
  }
}
