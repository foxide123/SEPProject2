package main.client.view.handyman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanLogInViewModel;

import java.io.IOException;

public class HandymanLogInView
{
  @FXML private TextField tf_cvr;
  @FXML private TextField tf_password;
  @FXML private Label error_label;

  private ViewHandler viewHandler;
  private HandymanLogInViewModel viewModel;

  public void init(ViewHandler viewHandler, HandymanLogInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    tf_cvr.textProperty().bindBidirectional(viewModel.getCVRProperty());
    tf_password.textProperty().bindBidirectional(viewModel.getPasswordProperty());
    error_label.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());
  }


  @FXML private void onLogIn(ActionEvent event) throws IOException
  {
    if(viewModel.logInHandyman()){
      viewHandler.openView("HandymanLoggedIn");
    }
  }

  @FXML private void onBack(ActionEvent event) throws IOException{
    viewHandler.openView("LogInRegister");
  }


}
