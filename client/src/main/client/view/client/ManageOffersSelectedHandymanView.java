package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ManageOffersSelectedHandymanViewModel;

import java.io.IOException;

public class ManageOffersSelectedHandymanView
{
  @FXML Label CVR;
  @FXML Label firstName;
  @FXML Label lastName;
  @FXML Label description;
  @FXML Label city;
  @FXML Label zip;
  @FXML Label hourlyRate;
  @FXML Label skills;
  @FXML Label rating;
  @FXML Label email;
  @FXML Label phone;

  private ViewHandler viewHandler;
  private ManageOffersSelectedHandymanViewModel viewModel;

  public void init(ViewHandler viewHandler, ManageOffersSelectedHandymanViewModel viewModel){
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.CVR.textProperty().bindBidirectional(viewModel.getCVRProperty());
    this.firstName.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    this.lastName.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    this.description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    this.city.textProperty().bindBidirectional(viewModel.getCityProperty());
    this.zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    this.hourlyRate.textProperty().bindBidirectional(viewModel.getHourlyRateProperty());
    this.skills.textProperty().bindBidirectional(viewModel.getSkillsProperty());
    this.rating.textProperty().bindBidirectional(viewModel.getRatingProperty());
    this.email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    this.phone.textProperty().bindBidirectional(viewModel.getPhoneProperty());
  }

  public void onBack(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientManageOffers");
  }
}
