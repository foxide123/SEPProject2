package main.client.view.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientFindHandymanResultViewModel;
import main.shared.model.Handyman;

import java.io.IOException;
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
    final Long[] selectedHandymanCVR = {null};
    if(handymanList.isEmpty()){
      labelError.setText("No handyman found");
    }else{
      for(int i=0; i<handymanList.size(); i++){
        listView.getItems().add(handymanList.get(i).getCVR());
      }

      listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Long>(){

        @Override public void changed(
            ObservableValue<? extends Long> observableValue,
            Long s, Long t1)
        {
          selectedHandymanCVR[0] = (Long) listView.getSelectionModel().getSelectedItem();
          System.out.println(selectedHandymanCVR[0]);
          try
          {
            if (viewModel.findHandymanWithCVR(selectedHandymanCVR[0]) != null)
            {
              try
              {
                viewHandler.openView("SelectedHandyman");
              }
              catch (IOException e)
              {
                e.printStackTrace();
              }
            }
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
        }
      });

    }
  }
}
