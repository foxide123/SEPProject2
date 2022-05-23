package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientSignUpViewModel;

import java.io.IOException;

public class ClientSignUpView
{
  private ViewHandler viewHandler;
  private ClientSignUpViewModel viewModel;
  @FXML private TextField tf_cpr;
  @FXML private TextField tf_password;
  @FXML private TextField tf_email;
  @FXML private TextField tf_first_name;
  @FXML private TextField tf_last_name;
  @FXML private TextField tf_city;
  @FXML private TextField tf_zip;
  @FXML private TextArea tf_description;
  //@FXML private ChoiceBox choiceBox;

  //private String toggleName;
  //ToggleGroup toggleGroup = new ToggleGroup();

  public void init(ViewHandler viewHandler, ClientSignUpViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    tf_cpr.textProperty().bindBidirectional(viewModel.getCPRProperty());
    tf_password.textProperty().bindBidirectional(viewModel.getPasswordProperty());
    tf_email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    tf_first_name.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    tf_last_name.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
    tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    tf_description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());

    /*
    radioButtonShow.setToggleGroup(toggleGroup);
    radioButtonHide.setToggleGroup(toggleGroup);

    radioButtonShow.setSelected(true);

    choiceBox.getItems().addAll("Horsens", "Copenhagen", "Aarhus", "Odense");

    //set default value
    choiceBox.setValue("Horsens");
 */
  }

  @FXML private void onSignUp(ActionEvent event) throws IOException
  {
    if (viewModel.createClientAccount())
    {
      System.out.println("ClientRegistered");
      viewHandler.openView("ClientLoggedIn");
    }else{
      System.out.println("Error");
    }
  }

  @FXML private void onBack(ActionEvent event) throws IOException{
    viewHandler.openView("LogInRegister");
  }
/*
  @FXML private void onSignUp(ActionEvent event){
    toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
    viewModel.signUpUser(tf_email.getText(), tf_password.getText(),toggleName);
  }
*/
}
