package main.client.viewmodel.admin;

import main.client.model.Model;
import main.shared.model.Handyman;
import main.shared.model.Client;

import java.util.ArrayList;

public class AdminMainViewModel
{
  private Model model;

  public AdminMainViewModel(Model model){this.model = model;}

  public ArrayList<Handyman> getAllHandymanList(){
    //System.out.println("d");
    try
    {
      return model.findAllHandyman();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<Client> getAllClientList(){
    System.out.println("d");
    try
    {
      return model.findAllClient();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
