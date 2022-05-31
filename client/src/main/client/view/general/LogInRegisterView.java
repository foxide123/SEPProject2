package main.client.view.general;

import javafx.event.ActionEvent;
import main.client.view.ViewHandler;
import main.client.viewmodel.LogInRegisterViewModel;

import java.io.IOException;

public class LogInRegisterView
{
  private ViewHandler viewHandler;
  private LogInRegisterViewModel viewModel;

  public void init(ViewHandler viewHandler, LogInRegisterViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  public void onLogIn(ActionEvent event) throws IOException
  {
    viewHandler.openView("ChooseActorLogIn");
  }

  public void onRegister(ActionEvent event) throws IOException
  {
    viewHandler.openView("ChooseActorSignUp");
  }
}
