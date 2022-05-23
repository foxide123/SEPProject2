package main.client.view.handyman;

import main.client.view.ViewHandler;
//import main.client.viewmodel.handyman.HandymanFindWorkViewModel;
import main.client.viewmodel.handyman.HandymanJobRecomandationViewModel;

public class HandymanJobRecomandationView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  //private HandymanFindWorkViewModel viewModel;

  public void init(ViewHandler viewHandler, HandymanJobRecomandationViewModel viewModel){
    super.init(viewHandler);
    this.viewHandler = viewHandler;
  }

}
