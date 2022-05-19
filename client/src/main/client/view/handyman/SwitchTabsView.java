package main.client.view.handyman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import main.client.model.ModelManager;
import main.client.view.ViewHandler;

import java.io.IOException;

public class SwitchTabsView
{

  private ViewHandler viewHandler;
  private Region root;


  public void init(ViewHandler viewHandler, Region root){
    this.viewHandler = viewHandler;
    this.root = root;
  }

  @FXML
  public void onProfile() throws IOException
  {
    viewHandler.openView("HandymanLoggedIn");
  }

  @FXML
  public void onFindWork() throws IOException
  {
    viewHandler.openView("HandymanFindWork");
  }

  @FXML
  public void onRecommendation() throws IOException
  {
    viewHandler.openView("HandymanJobRecommendation");
  }

  @FXML
  public void onMyJobOffers() throws IOException
  {
    viewHandler.openView("HandymanManageOffers");
  }

  //todo log out




  public void reset() {

  }

  public Region getRoot() {
    return root;
  }
}
