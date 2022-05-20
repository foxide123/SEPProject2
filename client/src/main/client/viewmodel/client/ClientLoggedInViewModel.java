package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.Client;
import main.shared.model.Handyman;
import main.shared.model.Skills;

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
  @FXML private StringProperty email;
  @FXML private StringProperty newPassword;
  @FXML private StringProperty confirmPassword;

  private Client tmpClient;

  public ClientLoggedInViewModel(Model model){
    this.model = model;
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.cpr = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.newPassword = new SimpleStringProperty("");
    this.confirmPassword = new SimpleStringProperty("");
    model.addPropertyChangeListener("ClientLoggedIn", this::setValues);
  }

  private void setValues(PropertyChangeEvent propertyChangeEvent)
  {
    tmpClient = (Client) propertyChangeEvent.getNewValue();


    cpr.setValue(String.valueOf(tmpClient.getCPR()));
    firstName.setValue(tmpClient.getFirstName());
    lastName.setValue(tmpClient.getLastName());
    city.set(tmpClient.getAddress().getCity());
    zip.set(tmpClient.getAddress().getZip());
    description.setValue(tmpClient.getDescription());
    email.setValue(tmpClient.getEmail());
  }

  public void onSave(){
    try{
      model.updateClient(new Client(
          Integer.parseInt(cpr.get()), firstName.get(), lastName.get(),
          email.get(), new Address(city.get(), zip.get()),description.get()
      ));
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public StringProperty getFirstNameProperty(){return firstName;}
  public StringProperty getLastNameProperty(){return lastName;}
  public StringProperty getCprProperty(){return cpr;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getDescriptionProperty(){return description;}
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