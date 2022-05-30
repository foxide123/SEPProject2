package main.client.view.admin;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.admin.AdminMainViewModel;
import main.shared.model.Client;
import main.shared.model.Handyman;

import java.util.ArrayList;

public class AdminMainView
{

  private AdminMainViewModel viewModel;
  private ViewHandler viewHandler;

  @FXML private ListView accountListView;

  public void init(ViewHandler viewHandler, AdminMainViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    setListView();
  }

  public void setListView(){
    System.out.println("g");
    ArrayList<Handyman> handymanList = viewModel.getAllHandymanList();
    ArrayList<Client> clientList = viewModel.getAllClientList();

    if(handymanList.isEmpty() && clientList.isEmpty()){
      System.out.println("No users found");
    }else{
      for(int i=0; i<handymanList.size(); i++){
        accountListView.getItems().add(handymanList.get(i).getCVR() + "         type : handyman");
      }
      for(int i=0; i<clientList.size(); i++){
        accountListView.getItems().add(clientList.get(i).getCPR() + "         type : client");
      }
    }
  }
}
