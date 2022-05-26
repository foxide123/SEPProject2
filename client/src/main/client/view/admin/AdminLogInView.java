package main.client.view.admin;

import main.client.view.ViewHandler;
import main.client.viewmodel.admin.AdminLogInViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminLogInView
{
  private ViewHandler viewHandler;
  private AdminLogInViewModel viewModel;

  @FXML private TextField tf_username;
  @FXML private TextField tf_password;
  @FXML private Label error_label;

  public void init(ViewHandler viewHandler, AdminLogInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  @FXML private void onBack() throws IOException
  {
    viewHandler.openView("LogInRegister");
  }

  @FXML private void onLogIn() throws IOException{
    viewHandler.openView("AdminMain");
  }
}
