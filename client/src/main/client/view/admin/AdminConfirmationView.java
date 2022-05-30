package main.client.view.admin;

import javafx.fxml.FXML;
import main.client.view.ViewHandler;
import main.client.viewmodel.admin.AdminConfirmationViewModel;

import java.io.IOException;

public class AdminConfirmationView
{
  private ViewHandler viewHandler;
  private AdminConfirmationViewModel viewModel;

  public void init(ViewHandler viewHandler, AdminConfirmationViewModel viewModel){
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }
  @FXML private void confirmDelete() throws IOException
  {
    viewHandler.openView("AdminMain");

  }
}
