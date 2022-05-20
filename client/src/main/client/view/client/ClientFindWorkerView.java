package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.client.ClientFindWorkerViewModel;

import java.io.IOException;

public class ClientFindWorkerView extends SwitchTabsView
{
  @FXML private RadioButton rb_plumber;
  @FXML private RadioButton rb_electrician;
  @FXML private RadioButton rb_mason;
  @FXML private RadioButton rb_groundworker;
  @FXML private TextField tf_city;
  @FXML private TextField tf_zip;
  @FXML private TextField tf_hourlyRate;

  private ClientFindWorkerViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ClientFindWorkerViewModel viewModel){
    super.init(viewHandler);
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
    tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());
    tf_hourlyRate.textProperty().bindBidirectional(viewModel.getHourlyRateProperty());
  }

  @FXML public void onSearch(ActionEvent event) throws IOException
  {
    if (viewModel.onSearch(rb_plumber.isSelected(), rb_electrician.isSelected(),
        rb_mason.isSelected(), rb_groundworker.isSelected()))
    {
      viewHandler.openView("HandymanLoggedIn");
    }
    else{
      System.out.println("Didn't create hanydman account");
    }
  }

}
