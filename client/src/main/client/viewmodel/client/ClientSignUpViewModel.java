package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.shared.model.Address;
import main.shared.model.Client;
import main.client.model.Model;

public class ClientSignUpViewModel
{
  private Model model;
  @FXML private StringProperty cpr;
  @FXML private StringProperty password;
  @FXML private StringProperty email;
  @FXML private StringProperty firstName;
  @FXML private StringProperty lastName;
  @FXML private StringProperty city;
  @FXML private StringProperty zip;
  @FXML private StringProperty description;

  public ClientSignUpViewModel(Model model){
    this.model = model;
    this.cpr = new SimpleStringProperty("");
    this.password = new SimpleStringProperty("");
    this.email = new SimpleStringProperty("");
    this.firstName = new SimpleStringProperty("");
    this.lastName = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
  }

  public boolean createClientAccount(){
    try {
      model.signUpClient(
          new Client(
              Integer.parseInt(cpr.get()), firstName.get(), lastName.get(), email.get(),
              new Address(city.get(),zip.get()), description.get()
          ),
          password.get());
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @FXML public StringProperty getCPRProperty(){return cpr;}
  @FXML public StringProperty getPasswordProperty(){return password;}
  @FXML public StringProperty getEmailProperty(){return email;}
  @FXML public StringProperty getFirstNameProperty(){return firstName;}
  @FXML public StringProperty getLastNameProperty(){return lastName;}
  @FXML public StringProperty getCityProperty(){return city;}
  @FXML public StringProperty getZipProperty(){return zip;}
  @FXML public StringProperty getDescriptionProperty(){return description;}
}
