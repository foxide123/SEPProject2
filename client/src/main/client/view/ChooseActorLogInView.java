package main.client.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.client.viewmodel.ChooseActorLogInViewModel;

import java.io.IOException;

public class ChooseActorLogInView
{

  private ViewHandler viewHandler;
  private ChooseActorLogInViewModel viewModel;

  public void init(ViewHandler viewHandler, ChooseActorLogInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }


  @FXML private void onLogInHandyman(ActionEvent event) throws IOException
  {
    viewHandler.openView("HandymanLogIn");
  }
  @FXML private void onLogInClient(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientLogIn");
  }
  @FXML private void onLogInAdmin(ActionEvent event) throws IOException
  {
    viewHandler.openView("AdminLogIn");
  }

  @FXML private void onSignUp(ActionEvent event) throws IOException{
    viewHandler.openView("ChooseActorSignUp");
  }
}
