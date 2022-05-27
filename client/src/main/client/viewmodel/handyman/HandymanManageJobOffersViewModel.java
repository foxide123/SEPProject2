package main.client.viewmodel.handyman;

import main.client.model.Model;
import main.shared.model.JobOffer;

import java.util.ArrayList;

public class HandymanManageJobOffersViewModel
{
  private Model model;

  public HandymanManageJobOffersViewModel(Model model){

    this.model = model;

  }

  public JobOffer getJobOfferObject(String selectedJobOffer){

    return model.findJobOfferWithTitle(selectedJobOffer);
  }

  public ArrayList<JobOffer> getAppliedJobs(){
    return model.getAppliedJobs();
  }
}
