package main.client.view.client;

import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientSignUpViewModel;
import main.client.viewmodel.client.FindWorkerViewModel;

public class FindWorkerView
{

  private ViewHandler viewHandler;
  private FindWorkerViewModel viewModel;

  public void init(ViewHandler viewHandler, FindWorkerViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }
}
