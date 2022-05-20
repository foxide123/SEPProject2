package main.shared.model;

import java.util.ArrayList;
import java.io.Serializable;

public class JobOffer implements Serializable, JobOfferInterface {


    private String jobTitle;
    private String jobDescription;
    private String jobBudget;
    private Address location;
    private Client client;
    private ArrayList<Handyman> aplicants;
    private JobType type;


    private static final long serialVersionUID = 4;



    public JobOffer(String jobTitle, String jobDescription, String jobBudget, Address location, long cpr) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobBudget = jobBudget;
        this.location = location;
        this.client = client;
        aplicants = new ArrayList<Handyman>();
        this.type = type;


    }



    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobBudget() {
        return jobBudget;
    }

    public void setJobBudget(String jobBudget) {
        this.jobBudget = jobBudget;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Handyman> getAplicants() {
        return aplicants;
    }
    public ArrayList<String> getJobType(){
        return type.getJobType();}


    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }


}
