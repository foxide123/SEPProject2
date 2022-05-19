package main.client.view.client;

import main.client.view.ViewHandler;
import main.client.viewmodel.client.ManageOffersViewModel;

public class ManageOffersView
{
  private ViewHandler viewHandler;
  private ManageOffersViewModel viewModel;

  public void init(ViewHandler viewHandler, ManageOffersViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }
}
