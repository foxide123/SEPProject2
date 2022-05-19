package main.client.viewmodel.handyman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;

public class HandymanLogInViewModel
{
  private Model model;
  private StringProperty CVR;
  private StringProperty password;
  private StringProperty errorLabel;

  public HandymanLogInViewModel(Model model){
    this.model = model;
    CVR = new SimpleStringProperty("");
    password = new SimpleStringProperty("");
    errorLabel = new SimpleStringProperty("");
  }

  public boolean logInHandyman() {
    try {
      model.logInHandyman(Integer.parseInt(CVR.get()), password.get());
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public StringProperty getCVRProperty() {
    return CVR;
  }

  public StringProperty getPasswordProperty() {
    return password;
  }

  public StringProperty getErrorLabelProperty(){return errorLabel;}
}
