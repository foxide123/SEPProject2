package main.client.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;

public class ChooseActorSignUpViewModel
{
  private Model model;
  private StringProperty CVR;
  private StringProperty password;
  private StringProperty error;

  public ChooseActorSignUpViewModel(Model model){
    this.model = model;
    CVR = new SimpleStringProperty("");
    password = new SimpleStringProperty("");
    error = new SimpleStringProperty("");
  }
}
