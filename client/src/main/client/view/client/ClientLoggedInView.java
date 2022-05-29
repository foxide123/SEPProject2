package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.client.model.Model;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientLoggedInViewModel;

public class ClientLoggedInView extends SwitchTabsView
{
  private Model model;
  private ClientLoggedInViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML private TextField tf_firstName;
  @FXML private TextField tf_lastName;
  @FXML private TextField tf_CPR;
  @FXML private TextField tf_zip;
  @FXML private TextField tf_city;
  @FXML private TextArea tf_description;
  @FXML private TextField tf_email;
  @FXML private TextField tf_newPassword;
  @FXML private TextField tf_confirmPassword;

  @FXML Label errorLabel;


  public void init(ViewHandler viewHandler, ClientLoggedInViewModel viewModel){
    super.init(viewHandler);
    this.viewModel = viewModel;

    tf_firstName.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    tf_lastName.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    tf_CPR.textProperty().bindBidirectional(viewModel.getCprProperty());
    tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
    tf_description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    tf_email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    tf_newPassword.textProperty().bindBidirectional(viewModel.getNewPassword());
    tf_confirmPassword.textProperty().bindBidirectional(viewModel.getConfirmPassword());

    errorLabel.textProperty().bindBidirectional(viewModel.getErrorLabel());

  }

  @FXML public void onSave(ActionEvent event){
    viewModel.onSave();
  }





}
