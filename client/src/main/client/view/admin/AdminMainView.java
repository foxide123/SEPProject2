package main.client.view.admin;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.admin.AdminLogInViewModel;
import main.client.viewmodel.admin.AdminMainViewModel;
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
  }

  /*
  public void setListView(){
    ArrayList<Handyman> handymanList = viewModel.getHandymanList();
    if(handymanList.isEmpty()){
      labelError.setText("No handyman found");
    }else{
      for(int i=0; i<handymanList.size(); i++){
        listView.getItems().add(handymanList.get(i).getCVR());
      }
    }
  }

   */

}
