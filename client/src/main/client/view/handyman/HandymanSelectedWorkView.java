package main.client.view.handyman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanSelectedWorkViewModel;

import java.io.IOException;

public class HandymanSelectedWorkView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private HandymanSelectedWorkViewModel viewModel;

  @FXML Label jobTitle;
  @FXML Label description;
  @FXML Label budget;
  @FXML Label city;
  @FXML Label zip;
  @FXML Label cpr;
  @FXML Label jobTypes;
  @FXML Label errorLabel;

  public void init(ViewHandler viewHandler, HandymanSelectedWorkViewModel viewModel){
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
  }

  public void onBack(ActionEvent event) throws IOException
  {
    viewHandler.openView("HandymanFindWorkResult");
  }

  public void onApply(ActionEvent event){
    viewModel.apply();
  }

}
