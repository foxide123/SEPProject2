package main.client.viewmodel.client;

import main.client.model.Model;
import main.shared.model.JobOffer;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ClientManageOffersViewModel
{
  private Model model;

  public ClientManageOffersViewModel(Model model){
    this.model = model;
  }

  public ArrayList<JobOffer> getJobOfferList() throws RemoteException
  {
    return model.getJobOffers();
  }

  public JobOffer getClientSelectedOffer(String selectedJob)
      throws RemoteException
  {
    return model.getClientSelectedOffer(selectedJob);
  }
}
