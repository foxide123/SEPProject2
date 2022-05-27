package main.client.view.handyman;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanManageJobOffersViewModel;
import main.shared.model.JobOffer;

import java.io.IOException;
import java.util.ArrayList;

public class HandymanManageJobOffersView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private HandymanManageJobOffersViewModel viewModel;
  @FXML private ListView listView;
  @FXML private Label labelError;

  public void init(ViewHandler viewHandler, HandymanManageJobOffersViewModel viewModel)
  {
    super.init(viewHandler);
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;

    setListValues();
  }

  public void setListValues(){
    ArrayList<JobOffer> appliedList = viewModel.getAppliedJobs();
    final String[] selectedJobOffer = {null};


    if(appliedList.isEmpty()){
       labelError.setText("Nothing found");
    }else{

      for(int i=0; i<appliedList.size(); i++){
        listView.getItems().add(appliedList.get(i).getJobTitle());

      }

      listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

        @Override public void changed(
            ObservableValue<? extends String> observableValue,
            String s, String t1)
        {
          selectedJobOffer[0] = (String) listView.getSelectionModel().getSelectedItem();
          if (viewModel.getJobOfferObject(selectedJobOffer[0]) != null)
          {
            try
            {
              viewHandler.openView("SelectedWork");
            }
            catch (IOException e)
            {
              e.printStackTrace();
            }
          }
        }
      });

    }
  }

}
