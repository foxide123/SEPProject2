package main.client.viewmodel.client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.Client;
import main.shared.model.JobOffer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class CreateJobViewModel {

    private Model model;
    private StringProperty jobTitle;
    private StringProperty jobDescription;
    private StringProperty jobBudget;
    private StringProperty city;
    private StringProperty zipCode;
    private StringProperty errorLabel;
    private ArrayList<String> jobSkills;

    public CreateJobViewModel(Model model){
        this.model = model;
        jobTitle = new SimpleStringProperty("");
        jobDescription = new SimpleStringProperty("");
        jobBudget = new SimpleStringProperty("");
        city = new SimpleStringProperty("");
        zipCode = new SimpleStringProperty("");
        errorLabel = new SimpleStringProperty("");
        jobSkills = new ArrayList<>();

    }

    public StringProperty jobTitleProperty(){return jobTitle;}

    public StringProperty getJobDescription(){return jobDescription;}


    public boolean createJob() {
        try {
            model.createJob(new JobOffer(jobTitle.get(), jobDescription.get(), jobBudget.get(),
                    new Address( city.get(), zipCode.get())));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @FXML public StringProperty getJobTitleProperty(){return jobTitle;}
    @FXML public StringProperty getJobBudgetProperty(){return jobBudget;}
    @FXML public StringProperty getCityProperty(){return city;}
    @FXML public StringProperty getZipCodeProperty(){return zipCode;}
    @FXML public StringProperty getJobDescriptionProperty(){return jobDescription;}


}
