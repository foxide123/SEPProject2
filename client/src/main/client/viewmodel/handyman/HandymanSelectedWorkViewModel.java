package main.client.viewmodel.handyman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.JobOffer;

import java.beans.PropertyChangeEvent;

public class HandymanSelectedWorkViewModel
{
  private Model model;

  private StringProperty jobTitle;
  private StringProperty description;
  private StringProperty budget;
  private StringProperty city;
  private StringProperty zip;
  private StringProperty cpr;
  private StringProperty jobTypes;
  private StringProperty errorLabel;

  private JobOffer jobOffer;

  public HandymanSelectedWorkViewModel(Model model){
    this.model = model;
    this.jobTitle = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.budget = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.cpr = new SimpleStringProperty("");
    this.jobTypes = new SimpleStringProperty("");
    this.errorLabel = new SimpleStringProperty("");
    model.addPropertyChangeListener("JobOfferFound", this::setOfferValues);
  }

  private void setOfferValues(PropertyChangeEvent propertyChangeEvent)
  {
    jobOffer = (JobOffer) propertyChangeEvent.getNewValue();
    jobTitle.setValue(jobOffer.getJobTitle());
    description.setValue(jobOffer.getJobDescription());
    budget.set(String.valueOf(jobOffer.getJobBudget()));
    city.setValue(jobOffer.getLocation().getCity());
    zip.setValue(jobOffer.getLocation().getZip());
    cpr.setValue(String.valueOf(jobOffer.getCpr()));

    String type = "";
    for(int i=0; i<jobOffer.getJobTypeList().size(); i++){
      type += jobOffer.getJobTypeList().get(i) + " ";
    }
    jobTypes.setValue(type);
  }

  public void apply(){
    if(model.getAppliedJobs().contains(jobOffer)){
      errorLabel.set("You have already applied for the job!");
    }else{
      model.addToAppliedJobs(jobOffer);
    }
  }

  public StringProperty getJobTitleProperty(){return jobTitle;}
  public StringProperty getDescriptionProperty(){return description;}
  public StringProperty getBudgetProperty(){return budget;}
  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getCprProperty(){return cpr;}
  public StringProperty getJobTypesProperty(){return jobTypes;}
  public StringProperty getErrorLabelProperty(){return errorLabel;}
}
