package main.client.viewmodel.handyman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.JobOffer;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class HandymanFindWorkResultViewModel
{
    private Model model;
    private PropertyChangeSupport support;
    private StringProperty labelError;

    public HandymanFindWorkResultViewModel(Model model){
        this.model = model;
        this.labelError = new SimpleStringProperty("");
    }

    public ArrayList<JobOffer> getJobOfferList(){
        return model.findJobResult();
    }

    public JobOffer getJobOfferObject(String selectedJobOffer){

        return model.findJobOfferWithTitle(selectedJobOffer);
    }

    public StringProperty getLabelError(){
        return labelError;
    }
}
