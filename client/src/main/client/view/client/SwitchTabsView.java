package main.client.view.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import main.client.view.ViewHandler;

import java.io.IOException;

public class SwitchTabsView
{

  private ViewHandler viewHandler;


  public void init(ViewHandler viewHandler){
    this.viewHandler = viewHandler;
  }

  @FXML public void onManageProfile(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientLoggedIn");
  }

  @FXML public void onFindHandyman(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientFindHandyman");
  }

  @FXML public void onCreateOffer(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientCreateOffer");
  }

  @FXML public void onManageOffers(ActionEvent event) throws IOException
  {
    viewHandler.openView("ClientManageOffers");
  }

  //todo log out




  public void reset() {

  }
}
