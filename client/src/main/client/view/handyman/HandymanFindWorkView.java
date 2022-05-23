package main.client.view.handyman;

import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanFindWorkViewModel;
import main.client.viewmodel.handyman.HandymanLogInViewModel;

public class HandymanFindWorkView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private HandymanFindWorkViewModel viewModel;

  public void init(ViewHandler viewHandler, HandymanFindWorkViewModel viewModel){
    super.init(viewHandler);
    this.viewHandler = viewHandler;
  }
}






