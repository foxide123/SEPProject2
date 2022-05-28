package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.view.handyman.SwitchTabsView;
import main.client.viewmodel.client.ClientSelectedOfferViewModel;
import main.shared.model.Handyman;

import java.io.IOException;
import java.util.ArrayList;

public class ClientSelectedOfferView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private ClientSelectedOfferViewModel viewModel;

  private ArrayList<Handyman> handymanList;

  @FXML Label jobTitle;
  @FXML Label description;
  @FXML Label budget;
  @FXML Label city;
  @FXML Label zip;
  @FXML Label cpr;
  @FXML Label jobTypes;
  @FXML Label errorLabel;
  @FXML ListView listView;

  public void init(ViewHandler viewHandler, ClientSelectedOfferViewModel viewModel)
  {
    super.init(viewHandler);
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;

    this.jobTitle.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
    this.description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    this.budget.textProperty().bindBidirectional(viewModel.getBudgetProperty());
    this.city.textProperty().bindBidirectional(viewModel.getCityProperty());
    this.zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    this.cpr.textProperty().bindBidirectional(viewModel.getCprProperty());
    this.jobTypes.textProperty().bindBidirectional(viewModel.getJobTypesProperty());
    this.errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());

    try
    {
      this.handymanList = viewModel.getAppliedHandyman(jobTitle.getText());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    setValues();
  }

  public void setValues(){
    for(int i=0; i<handymanList.size(); i++){
      System.out.println("handymanList: " + handymanList.get(i).getFirstName());
      listView.getItems().add(handymanList.get(i).getFirstName() + handymanList.get(i).getLastName());
    }
  }

  public void onBack(ActionEvent event) throws IOException
  {
    viewHandler.openView("HandymanFindWorkResult");
  }

}
