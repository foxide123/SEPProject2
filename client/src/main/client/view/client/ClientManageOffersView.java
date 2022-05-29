package main.client.view.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientManageOffersViewModel;
import main.shared.model.JobOffer;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientManageOffersView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private ClientManageOffersViewModel viewModel;
  @FXML private ListView listView;
  @FXML private Label errorLabel;

  public void init(ViewHandler viewHandler, ClientManageOffersViewModel viewModel)
      throws RemoteException
  {
    super.init(viewHandler);
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    setListView();
  }

  public void setListView() throws RemoteException
  {
    ArrayList<JobOffer> jobOfferList = viewModel.getJobOfferList();
    final String[] selectedJobOffer = {null};

    if(jobOfferList.isEmpty()){
      errorLabel.setText("No offer found");
    }else{
      for(int i=0; i<jobOfferList.size(); i++){
        listView.getItems().add(jobOfferList.get(i).getJobTitle());
      }

      listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

        @Override public void changed(
            ObservableValue<? extends String> observableValue,
            String s, String t1)
        {
          selectedJobOffer[0] = (String) listView.getSelectionModel().getSelectedItem();
            try
            {
              if(viewModel.getClientSelectedOffer(selectedJobOffer[0]) != null){
                viewHandler.openView("ClientSelectedWork");
              }
            }
            catch (IOException e)
            {
              e.printStackTrace();
            }
        }
      });

    }
  }

}
