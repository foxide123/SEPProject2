package main.client.viewmodel.handyman;

import javafx.beans.property.*;
import main.shared.model.Address;
import main.shared.model.Handyman;
import main.client.model.Model;
import main.shared.model.Skills;

public class HandymanSignUpViewModel
{
  private Model model;
  private StringProperty email;
  private StringProperty password;
  private StringProperty passwordConfirm;
  private StringProperty cvr;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty phone;
  private StringProperty description;
  private StringProperty hourlyRate;
  private StringProperty city;
  private StringProperty zip;

  private StringProperty errorLabel;


  public HandymanSignUpViewModel(Model model){
    this.model = model;
    this.email = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
    this.passwordConfirm = new SimpleStringProperty("");
    this.cvr = new SimpleStringProperty("");
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.phone = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.hourlyRate = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");

    this.errorLabel = new SimpleStringProperty("");
  }

  public boolean createHandymanAccount(boolean plumber, boolean electrician, boolean mason, boolean groundworker){
    try {
      if(passwordConfirm.get().equals(password.get())){
        model.signUpHandyman(
            new Handyman(Integer.parseInt(cvr.get()), firstName.get(), lastName.get(), email.get(), phone.get(), description.get(),
                new Address(city.get(),zip.get()), Integer.parseInt(hourlyRate.get()),
                new Skills(plumber, electrician, mason, groundworker), null),
            password.get()
        );
        errorLabel.set("Password doesn't match !");
        return true;
      }else{
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }



  public StringProperty getEmailProperty(){return email;}
  public StringProperty getPasswordProperty(){return password;}
  public StringProperty getPasswordConfirmProperty(){return passwordConfirm;}
  public StringProperty getCVRProperty(){return cvr;}
  public StringProperty getFirstNameProperty(){return firstName;}
  public StringProperty getLastNameProperty(){return lastName;}
  public StringProperty getPhoneProperty(){return phone;}
  public StringProperty getDescriptionProperty(){return description;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}

  public StringProperty getLabelErrorProperty(){return errorLabel;}


}
