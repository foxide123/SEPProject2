package main.client.view.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientFindHandymanResultViewModel;
import main.client.viewmodel.client.ClientFindHandymanViewModel;
import main.shared.model.Handyman;

import java.util.ArrayList;

public class ClientFindHandymanResultView extends SwitchTabsView
{
  @FXML private ListView listView;
  @FXML private Label labelError;
  private ViewHandler viewHandler;
  private ClientFindHandymanResultViewModel viewModel;

  public void init(ViewHandler viewHandler, ClientFindHandymanResultViewModel viewModel){
    super.init(viewHandler);
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    labelError.textProperty().bindBidirectional(viewModel.getLabelError());
    setListView();
  }

  public void setListView(){
    ArrayList<Handyman> handymanList = viewModel.getHandymanList();
    if(handymanList.isEmpty()){
      labelError.setText("No handyman found");
    }else{
      for(int i=0; i<handymanList.size(); i++){
        listView.getItems().add(handymanList.get(i).getCVR());
      }
    }
  }
}
