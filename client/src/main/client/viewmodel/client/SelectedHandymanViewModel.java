package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.Handyman;

import java.beans.PropertyChangeEvent;

public class SelectedHandymanViewModel
{
  private Model model;
  private StringProperty CVR;
  private StringProperty firstName;
  private StringProperty lastName;
  private StringProperty description;
  private StringProperty city;
  private StringProperty zip;
  private StringProperty hourlyRate;
  private StringProperty skills;
  private StringProperty rating;
  private StringProperty email;
  private StringProperty phone;

  public SelectedHandymanViewModel(Model model){
    this.model = model;
    this.CVR = new SimpleStringProperty("");
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.hourlyRate = new SimpleStringProperty("");
    this.skills = new SimpleStringProperty("");
    this.rating = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.phone = new SimpleStringProperty("");

    model.addPropertyChangeListener("AppliedHandyman", this::setValues);
  }

  public void setValues(PropertyChangeEvent event){
    Handyman handyman = (Handyman) event.getNewValue();


    this.CVR.setValue(String.valueOf(handyman.getCVR()));
    this.firstName.setValue(handyman.getFirstName());
    this.lastName.setValue(handyman.getLastName());
    this.description.setValue(handyman.getDescription());
    this.city.setValue(handyman.getAddress().getCity());
    this.zip.setValue(handyman.getAddress().getZip());
    this.hourlyRate.setValue(String.valueOf(handyman.getHourlyRate()));
    this.skills.setValue(String.valueOf(handyman.getSkillsList()));
    this.rating.setValue(handyman.getRating());

    if(handyman.getContactVisibility().equals("true")){
      this.email.setValue(handyman.getEmail());
      this.phone.setValue(handyman.getPhone());
    }else{
      this.email.setValue("-");
      this.phone.setValue("-");
    }
  }

  public StringProperty getCVRProperty(){return CVR;}
  public StringProperty getFirstNameProperty(){return firstName;}
  public StringProperty getLastNameProperty(){return lastName;}
  public StringProperty getDescriptionProperty(){return description;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
  public StringProperty getSkillsProperty(){return skills;}
  public StringProperty getRatingProperty(){return rating;}
  public StringProperty getEmailProperty(){return email;}
  public StringProperty getPhoneProperty(){return phone;}
}
