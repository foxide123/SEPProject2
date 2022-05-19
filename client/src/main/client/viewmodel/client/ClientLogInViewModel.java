package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;

public class ClientLogInViewModel
{
  private Model model;
  private StringProperty CPR;
  private StringProperty password;
  private StringProperty errorLabel;

  public ClientLogInViewModel(Model model) {
    this.model = model;
    CPR = new SimpleStringProperty("");
    password = new SimpleStringProperty("");
    errorLabel = new SimpleStringProperty("");
  }

  public boolean logInClient() {
    try {
      model.logInClient(Integer.parseInt(CPR.get()), password.get());
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public StringProperty getCPRProperty() {
    return CPR;
  }

  public StringProperty getPasswordProperty() {
    return password;
  }

  public StringProperty getLabelErrorProperty(){return errorLabel;}
}
