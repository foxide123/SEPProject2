package main.client.viewmodel.handyman;

import main.client.model.Model;
import main.shared.model.JobOffer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class HandymanManageJobOffersViewModel
{
  private Model model;

  public HandymanManageJobOffersViewModel(Model model){

    this.model = model;

  }

  public JobOffer getAppliedJobFromTitle(String jobTitle)
  {

    try
    {
      return model.getAppliedJobFromTitle(jobTitle);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList<JobOffer> getAppliedJobs() throws RemoteException
  {
    return model.getAppliedJobs();
  }
}
