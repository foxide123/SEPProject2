package main.client.view.handyman;

import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanFindWorkViewModel;
import main.client.viewmodel.handyman.HandymanJobOffersViewModel;

public class HandymanJobOffersView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private HandymanJobOffersViewModel viewModel;

  public void init(ViewHandler viewHandler, HandymanJobOffersViewModel viewModel){
    super.init(viewHandler);
    this.viewHandler = viewHandler;
  }
}
