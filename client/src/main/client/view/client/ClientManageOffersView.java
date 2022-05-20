package main.client.view.client;

import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientManageOffersViewModel;

public class ClientManageOffersView
{
  private ViewHandler viewHandler;
  private ClientManageOffersViewModel viewModel;

  public void init(ViewHandler viewHandler, ClientManageOffersViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }
}
