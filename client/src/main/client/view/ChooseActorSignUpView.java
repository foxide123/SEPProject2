package main.client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.client.viewmodel.ChooseActorSignUpViewModel;

import java.io.IOException;

public class ChooseActorSignUpView
{

  private ViewHandler viewHandler;
  private ChooseActorSignUpViewModel viewModel;

  public void init(ViewHandler viewHandler, ChooseActorSignUpViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  @FXML private void onRegisterHandyman(ActionEvent event) throws IOException
  {
    viewHandler.openView("HandymanSignUp");
  }

  @FXML private void onRegisterClient(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientSignUp");
  }

  @FXML private void onSignIn(ActionEvent event) throws IOException
  {
    viewHandler.openView("ChooseActorLogIn");
  }

}
