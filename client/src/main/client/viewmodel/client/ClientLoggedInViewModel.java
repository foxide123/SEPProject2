package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class ClientLoggedInViewModel
{
  private Model model;
  private PropertyChangeSupport support;
  @FXML private StringProperty firstName;
  @FXML private StringProperty lastName;
  @FXML private StringProperty cpr;
  @FXML private StringProperty zip;
  @FXML private StringProperty city;
  @FXML private StringProperty description;
  @FXML private StringProperty phone;
  @FXML private StringProperty email;
  @FXML private StringProperty newPassword;
  @FXML private StringProperty confirmPassword;

  public ClientLoggedInViewModel(Model model){
    this.model = model;
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.cpr = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.phone = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.newPassword = new SimpleStringProperty("");
    this.confirmPassword = new SimpleStringProperty("");
    model.addPropertyChangeListener("ClientLoggedIn", this::propertyChange);
  }

  public void onSave(){

  }

  public StringProperty getFirstNameProperty(){return firstName;}
  public StringProperty getLastNameProperty(){return lastName;}
  public StringProperty getCprProperty(){return cpr;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getDescriptionProperty(){return description;}
  public StringProperty getPhoneProperty(){return phone;}
  public StringProperty getEmailProperty(){return email;}
  public StringProperty getNewPassword(){return newPassword;}
  public StringProperty getConfirmPassword(){return confirmPassword;}

  public void propertyChange(PropertyChangeEvent evt)
  {
    Client client = (Client) evt.getNewValue();
    System.out.println("cpr: " + client.getCPR());
    System.out.println("email: " + client.getEmail());
    System.out.println("firstname: " + client.getFirstName());
    System.out.println("lastname: " + client.getLastName());
  }
}
