package main.client.viewmodel.handyman;

import javafx.beans.property.*;
import main.client.model.Model;
import javafx.fxml.FXML;
import main.shared.model.Address;
import main.shared.model.Handyman;
import main.shared.model.Skills;

import java.beans.PropertyChangeEvent;

public class HandymanLoggedInViewModel
{
  private Model model;
  @FXML private StringProperty cvr;
  @FXML private StringProperty firstName;
  @FXML private StringProperty lastName;
  @FXML private StringProperty city;
  @FXML private StringProperty zip;
  @FXML private StringProperty phone;
  @FXML private StringProperty description;
  @FXML private StringProperty email;
  @FXML private StringProperty newPassword;
  @FXML private StringProperty confirmPassword;
  @FXML private StringProperty hourlyRate;
  @FXML private StringProperty error_label;

  @FXML private BooleanProperty plumber;
  @FXML private BooleanProperty electrician;
  @FXML private BooleanProperty mason;
  @FXML private BooleanProperty groundworker;

  private Handyman tmpHandyman;

  public HandymanLoggedInViewModel(Model model){
    this.model = model;
    this.cvr = new SimpleStringProperty("");
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.phone = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.newPassword = new SimpleStringProperty("");
    this.confirmPassword = new SimpleStringProperty("");
    this.hourlyRate = new SimpleStringProperty("");
    this.error_label = new SimpleStringProperty("");

    this.plumber = new SimpleBooleanProperty(false);
    this.electrician = new SimpleBooleanProperty(false);
    this.mason = new SimpleBooleanProperty(false);
    this.groundworker = new SimpleBooleanProperty(false);

    model.addPropertyChangeListener("HandymanLoggedIn", this::setValues);
    model.addPropertyChangeListener("HandymanSignedUp", this::setValues);
    model.addPropertyChangeListener("HandymanUpdated", this::setValues);
  }

  private void setValues(PropertyChangeEvent propertyChangeEvent)
  {
    tmpHandyman = (Handyman) propertyChangeEvent.getNewValue();


    cvr.setValue(String.valueOf(tmpHandyman.getCVR()));
    firstName.setValue(tmpHandyman.getFirstName());
    lastName.setValue(tmpHandyman.getLastName());
    city.set(tmpHandyman.getAddress().getCity());
    zip.set(tmpHandyman.getAddress().getZip());
    phone.setValue(tmpHandyman.getPhone());
    description.setValue(tmpHandyman.getDescription());
    email.setValue(tmpHandyman.getEmail());
    hourlyRate.setValue(String.valueOf(tmpHandyman.getHourlyRate()));

      if(tmpHandyman.getSkills().getPlumberBoolean() == true){
        plumber.set(true);
      }
      if(tmpHandyman.getSkills().getElectricianBoolean() == true){
        electrician.set(true);
      }
      if(tmpHandyman.getSkills().getMasonBoolean() == true){
        mason.set(true);
      }
      if(tmpHandyman.getSkills().getGroundWorkerBoolean() == true){
        groundworker.set(true);
      }

  }

  public void onSave(boolean plumber, boolean electrician, boolean mason, boolean groundworker){

    try{
      model.updateHandyman(new Handyman(
          Integer.parseInt(cvr.get()), firstName.get(), lastName.get(),
          email.get(), phone.get(), description.get(),
          new Address(city.get(), zip.get()),
          Integer.parseInt(hourlyRate.get()), new Skills(plumber, electrician, mason, groundworker),
          tmpHandyman.getRating()

      ));
    }catch(Exception e){
      e.printStackTrace();
    }
  }




  public StringProperty getCVRProperty(){return cvr;}
  public StringProperty getFirstNameProperty(){return firstName;}
  public StringProperty getLastNameProperty(){return lastName;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getPhoneProperty(){return phone;}
  public StringProperty getDescriptionProperty(){return description;}
  public StringProperty getEmailProperty(){return email;}
  public StringProperty getNewPasswordProperty(){return newPassword;}
  public StringProperty getConfirmPasswordProperty(){return confirmPassword;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
  public StringProperty getErrorLabelProperty(){return error_label;}

  public BooleanProperty getRBPlumberProperty(){return plumber;}
  public BooleanProperty getRBMasonProperty(){return mason;}
  public BooleanProperty getRBElectricianProperty(){return electrician;}
  public BooleanProperty getRBGroundworkerProperty(){return groundworker;}

}
