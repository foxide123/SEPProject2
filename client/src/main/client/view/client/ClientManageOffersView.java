package main.client.view.client;

import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientManageOffersViewModel;

public class ClientManageOffersView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private ClientManageOffersViewModel viewModel;

  public void init(ViewHandler viewHandler, ClientManageOffersViewModel viewModel){
    super.init(viewHandler);
    this.viewModel = viewModel;
  }
}
