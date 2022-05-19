package main.client.viewmodel.client;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
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

/*
    public boolean createJob() {
        try {
            model.createJob(new JobOffer(jobTitle.get(), jobDescription.get(), jobBudget.get(), workersNeeded.get(), LocalDateTime.of(startDate.get(), LocalTime.of(startHour.get(), startMinutes.get())),
                    LocalDateTime.of(endDate.get(), LocalTime.of(endHour.get(), endMinutes.get())), new Address(country.get(), city.get(), street.get(), postCode.get()), "pending", model.getEmployer()));
            return true;
        } catch (Exception e) {
            error.set(e.getMessage());
            return false;
        }
    }
    */

}
