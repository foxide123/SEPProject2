package main.client.view.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientManageOffersViewModel;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.util.ArrayList;

public class ClientManageOffersView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private ClientManageOffersViewModel viewModel;
  @FXML private ListView listView;
  @FXML private Label errorLabel;

  public void init(ViewHandler viewHandler, ClientManageOffersViewModel viewModel){
    super.init(viewHandler);
    this.viewModel = viewModel;
    setListView();
  }

  public void setListView(){
   /* ArrayList<JobOffer> jobOfferList = viewModel.getJobOfferList();
    if(jobOfferList.isEmpty()){
      errorLabel.setText("No offer found");
    }else{
      for(int i=0; i<jobOfferList.size(); i++){
        listView.getItems().add(jobOfferList.get(i).getJobTitle());
      }
    }

    */
  }

}
