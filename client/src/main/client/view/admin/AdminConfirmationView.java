package main.client.view.admin;

import javafx.fxml.FXML;
import main.client.view.ViewHandler;
import main.client.viewmodel.admin.AdminConfirmationViewModel;

import java.rmi.RemoteException;

public class AdminConfirmationView
{
  private ViewHandler viewHandler;
  private AdminConfirmationViewModel viewModel;

  public void init(ViewHandler viewHandler, AdminConfirmationViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }
  public void confirmDelete()
      throws RemoteException, Exception
  {
    viewModel.confirmDeletion(AdminMainView.getSelectedAccount());
  }
  @FXML private void confirmDeleteButton() throws Exception
  {
    confirmDelete();
    viewHandler.openView("AdminMain");
  }
}
