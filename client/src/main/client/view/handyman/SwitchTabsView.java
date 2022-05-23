package main.client.view.handyman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import main.client.model.ModelManager;
import main.client.view.ViewHandler;

import java.io.IOException;

public class SwitchTabsView {

  private ViewHandler viewHandler;


  public void init(ViewHandler viewHandler) {
    this.viewHandler = viewHandler;

  }

  @FXML
  public void onProfile() throws IOException {
    viewHandler.openView("HandymanLoggedIn");
  }

  @FXML
  public void onFindWork() throws IOException {
    viewHandler.openView("HandymanFindWork");
  }

  @FXML
  public void onRecommendation() throws IOException {
    viewHandler.openView("HandymanJobRecommendation");
  }

  @FXML
  public void onMyJobOffers() throws IOException {
    viewHandler.openView("HandymanManageOffers");
  }

  //todo log out
}




