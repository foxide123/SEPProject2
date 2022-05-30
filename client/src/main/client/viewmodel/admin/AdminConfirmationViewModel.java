package main.client.viewmodel.admin;

import main.client.model.Model;

import java.rmi.RemoteException;

public class AdminConfirmationViewModel
{
  private Model model;

  public AdminConfirmationViewModel(Model model){
    this.model = model;
  }

  public void confirmDeletion(String id)
      throws RemoteException, Exception
  {
    model.deleteAccount(id);
  }

}
