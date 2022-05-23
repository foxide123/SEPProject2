package main.client.view.handyman;

import javafx.scene.control.RadioButton;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanLoggedInViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HandymanLoggedInView extends SwitchTabsView
{
  private ViewHandler viewHandler;
  private HandymanLoggedInViewModel viewModel;
  @FXML private TextField cvr;
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField city;
  @FXML private TextField zip;
  @FXML private TextField phone;
  @FXML private TextArea description;
  @FXML private TextField email;
  @FXML private TextField newPassword;
  @FXML private TextField confirmPassword;
  @FXML private TextField hourlyRate;
  @FXML private Label errorLabel;

  @FXML private RadioButton rb_plumber;
  @FXML private RadioButton rb_electrician;
  @FXML private RadioButton rb_mason;
  @FXML private RadioButton rb_groundworker;

  public void init(ViewHandler viewHandler, HandymanLoggedInViewModel viewModel){
    this.viewModel = viewModel;
    super.init(viewHandler);
    cvr.textProperty().bindBidirectional(viewModel.getCVRProperty());
    firstName.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    lastName.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    city.textProperty().bindBidirectional(viewModel.getCityProperty());
    zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    phone.textProperty().bindBidirectional(viewModel.getPhoneProperty());
    description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    newPassword.textProperty().bindBidirectional(viewModel.getNewPasswordProperty());
    confirmPassword.textProperty().bindBidirectional(viewModel.getConfirmPasswordProperty());
    hourlyRate.textProperty().bindBidirectional(viewModel.getHourlyRateProperty());
    errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabelProperty());

    rb_plumber.selectedProperty().bindBidirectional(viewModel.getRBPlumberProperty());
    rb_electrician.selectedProperty().bindBidirectional(viewModel.getRBElectricianProperty());
    rb_mason.selectedProperty().bindBidirectional(viewModel.getRBMasonProperty());
    rb_groundworker.selectedProperty().bindBidirectional(viewModel.getRBGroundworkerProperty());
  }

  @FXML public void onSave(ActionEvent event){
    viewModel.onSave(rb_plumber.isSelected(), rb_electrician.isSelected(),
        rb_mason.isSelected(), rb_groundworker.isSelected());
  }

}
