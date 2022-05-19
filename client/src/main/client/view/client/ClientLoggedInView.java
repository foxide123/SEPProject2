package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.client.model.Model;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientLoggedInViewModel;

import java.io.IOException;

public class ClientLoggedInView
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
  @FXML private TextField tf_phone;
  @FXML private TextField tf_email;
  @FXML private TextField tf_newPassword;
  @FXML private TextField tf_confirmPassword;


  public void init(ViewHandler viewHandler, ClientLoggedInViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    tf_firstName.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    tf_lastName.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    tf_CPR.textProperty().bindBidirectional(viewModel.getCprProperty());
    tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
    tf_description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    tf_phone.textProperty().bindBidirectional(viewModel.getPhoneProperty());
    tf_email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    tf_newPassword.textProperty().bindBidirectional(viewModel.getNewPassword());
    tf_confirmPassword.textProperty().bindBidirectional(viewModel.getConfirmPassword());

  }

  @FXML public void onSave(ActionEvent event){
    viewModel.onSave();
  }

  @FXML public void onManageProfile(ActionEvent event) throws IOException
  {
    viewHandler.openView("ManageProfile");
  }

  @FXML public void onFindWorker(ActionEvent event) throws IOException
  {
    viewHandler.openView("FindWorker");
  }

  @FXML public void onCreateOffer(ActionEvent event) throws IOException
  {
    viewHandler.openView("CreateOffer");
  }

  @FXML public void onManageOffers(ActionEvent event) throws IOException
  {
    viewHandler.openView("ManageOffers");
  }




}
