package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientSignUpViewModel;
import main.client.viewmodel.client.FindWorkerViewModel;

import javax.swing.*;

public class ClientFindWorkerView extends SwitchTabsView
{
  @FXML private RadioButton rb_plumber;
  @FXML private RadioButton rb_electrician;
  @FXML private RadioButton rb_mason;
  @FXML private RadioButton rb_groundworker;
  @FXML private TextField tf_city;
  @FXML private TextField tf_zip;
  @FXML private TextField tf_hourlyRate;

  private FindWorkerViewModel viewModel;

  public void init(ViewHandler viewHandler, FindWorkerViewModel viewModel){
    super.init(viewHandler);
    this.viewModel = viewModel;
  }

  @FXML public void onSearch(ActionEvent event){

  }

}
