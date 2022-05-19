package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientLogInViewModel;

import java.io.IOException;

public class ClientLogInView
{
  private ViewHandler viewHandler;
  private ClientLogInViewModel viewModel;

  @FXML private TextField tf_cpr;
  @FXML private TextField tf_password;
  @FXML private Label error_label;

  public void init(ViewHandler viewHandler, ClientLogInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    tf_cpr.textProperty().bindBidirectional(viewModel.getCPRProperty());
    tf_password.textProperty().bindBidirectional(viewModel.getPasswordProperty());
    error_label.textProperty().bindBidirectional(viewModel.getLabelErrorProperty());
  }


  @FXML private void onLogIn(ActionEvent event) throws IOException
  {
    if (viewModel.logInClient())
      viewHandler.openView("ClientLoggedIn");
  }

  @FXML private void onBack(ActionEvent event) throws IOException{
    viewHandler.openView("LogInRegister");
  }

  @FXML private void onSignUp(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientSignUp");
  }
}
