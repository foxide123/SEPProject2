package main.shared.model;

import java.util.ArrayList;
import java.io.Serializable;

public class JobOffer implements Serializable, JobOfferInterface {


    private String jobTitle;
    private String jobDescription;
    private int jobBudget;
    private Address location;
    private long cpr;
    private JobType jobType;


    private static final long serialVersionUID = 4;



    public JobOffer(String jobTitle, String jobDescription, int jobBudget, Address location, long cpr, JobType jobType) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobBudget = jobBudget;
        this.location = location;
        this.cpr = cpr;
        this.jobType = jobType;
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

    public int getJobBudget() {
        return jobBudget;
    }
    public void setJobBudget(int jobBudget) {
        this.jobBudget = jobBudget;
    }

    public Address getLocation() {
        return location;
    }
    public void setLocation(Address location) {
        this.location = location;
    }

    public JobType getJobType(){return jobType;}
    public void setJobType(JobType jobType){this.jobType = jobType;}

    public ArrayList<String> getJobTypeList(){return jobType.getJobTypes();}

    public long getCpr(){return cpr;}
}
