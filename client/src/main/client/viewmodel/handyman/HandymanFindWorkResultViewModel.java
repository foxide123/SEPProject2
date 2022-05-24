package main.client.viewmodel.handyman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.util.ArrayList;

public class HandymanFindWorkResultViewModel
{
    private Model model;
    private StringProperty labelError;

    public HandymanFindWorkResultViewModel(Model model){
        this.model = model;
        this.labelError = new SimpleStringProperty("");
    }

    public ArrayList<JobOffer> getJobOfferList(){
        return model.handymanFindWorkResult();
    }

    public StringProperty getLabelError(){
        return labelError;
    }
}
