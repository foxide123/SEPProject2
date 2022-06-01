package main.client.viewmodel.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;

public class AdminLogInViewModel
{
  private Model model;
  private StringProperty username;
  private StringProperty password;

  public AdminLogInViewModel(Model model) {
    username = new SimpleStringProperty("");
    password = new SimpleStringProperty("");
    this.model = model;
  }

  public boolean logInAdmin() {
    try {
      System.out.println(username + "(viewModel)" + password);
      model.logInAdmin(username.get(), password.get());
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public StringProperty getUsernameProperty() {
    return username;
  }

  public StringProperty getPasswordProperty() {
    return password;
  }

}
