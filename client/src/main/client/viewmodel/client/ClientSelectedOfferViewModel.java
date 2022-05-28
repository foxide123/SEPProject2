package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ClientSelectedOfferViewModel
{
  private Model model;

  private StringProperty jobTitle;
  private StringProperty description;
  private StringProperty budget;
  private StringProperty city;
  private StringProperty zip;
  private StringProperty cpr;
  private StringProperty jobTypes;
  private StringProperty email;
  private StringProperty phone;
  private StringProperty errorLabel;

  private JobOffer jobOffer;

  public ClientSelectedOfferViewModel(Model model){
    this.model = model;
    this.jobTitle = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.budget = new SimpleStringProperty("");
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.cpr = new SimpleStringProperty("");
    this.jobTypes = new SimpleStringProperty("");
    this.errorLabel = new SimpleStringProperty("");
    model.addPropertyChangeListener("ClientSelectedOffer", this::setOfferValues);
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

    for(int i=0; i<jobOffer.getJobType().getJobTypes().size(); i++){
      type+= jobOffer.getJobType().getJobTypes().get(i);
    }
    jobTypes.setValue(type);


  }


  public ArrayList<Handyman> getAppliedHandyman(String jobTitle)
      throws Exception
  {
    return model.getAppliedHandyman(jobTitle);
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
