package main.client.view.handyman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanSignUpViewModel;

import java.io.IOException;

public class HandymanSignUpView
{
  private ViewHandler viewHandler;
  private HandymanSignUpViewModel viewModel;
  @FXML private TextField tf_email;
  @FXML private TextField tf_password;
  @FXML private TextField tf_password_confirm;
  @FXML private TextField tf_cvr;
  @FXML private TextField tf_first_name;
  @FXML private TextField tf_last_name;
  @FXML private TextField tf_phone;
  @FXML private TextArea tf_description;
  @FXML private TextField tf_hourly_rate;
  @FXML private ChoiceBox choiceBox;
  @FXML private TextField tf_city;
  @FXML private TextField tf_zip;
  @FXML private RadioButton rb_plumber;
  @FXML private RadioButton rb_electrician;
  @FXML private RadioButton rb_mason;
  @FXML private RadioButton rb_groundworker;

  @FXML private RadioButton contactRadioButton;

  @FXML private Label label_error;


  ToggleGroup toggleGroup = new ToggleGroup();


  public void init(ViewHandler viewHandler, HandymanSignUpViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    tf_email.textProperty().bindBidirectional(viewModel.getEmailProperty());
    tf_password.textProperty().bindBidirectional(viewModel.getPasswordProperty());
    tf_password_confirm.textProperty().bindBidirectional(viewModel.getPasswordConfirmProperty());
    tf_cvr.textProperty().bindBidirectional(viewModel.getCVRProperty());
    tf_first_name.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    tf_last_name.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    tf_phone.textProperty().bindBidirectional(viewModel.getPhoneProperty());
    tf_description.textProperty().bindBidirectional(viewModel.getDescriptionProperty());
    tf_hourly_rate.textProperty().bindBidirectional(viewModel.getHourlyRateProperty());
    tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
    tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());

    label_error.textProperty().bindBidirectional(viewModel.getLabelErrorProperty());


/*
    rb_plumber.setToggleGroup(toggleGroup);
    rb_mason.setToggleGroup(toggleGroup);
    rb_groundworker.setToggleGroup(toggleGroup);
    rb_electrician.setToggleGroup(toggleGroup);
*/

    /*toggleGroup.selectedToggleProperty().addListener(
        new ChangeListener<Toggle>()
        {
          public void changed(ObservableValue<? extends Toggle> ob,
              Toggle o, Toggle n)
          {

            RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();

            if (rb != null) {
              String s = rb.getText();

              // change the label
              System.out.println(s);
            }
          }
        }
    );*/

  }



  @FXML private void onLogIn(ActionEvent event) throws
      IOException
  {
    viewHandler.openView("HandymanLogIn");
  }


  @FXML private void onSignUp(ActionEvent event) throws IOException
  {


    if (viewModel.createHandymanAccount(rb_plumber.isSelected(), rb_electrician.isSelected(),
        rb_mason.isSelected(), rb_groundworker.isSelected(), contactRadioButton.isSelected()))
    {
      viewHandler.openView("HandymanLoggedIn");
    }
    else{
      System.out.println("Didn't create hanydman account");
    }

  }

  @FXML private void onBack(ActionEvent event) throws IOException{
    viewHandler.openView("LogInRegister");
  }
}
