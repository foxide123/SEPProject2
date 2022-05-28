package main.shared.model;

import java.io.Serializable;

public class Apply implements Serializable
{
  private long CVR;
  private String jobTitle;

  private static final long serialVersionUID = 5L;

  public Apply(long CVR, String jobTitle){
    this.CVR = CVR;
    this.jobTitle = jobTitle;
  }

  public long getCVR(){
    return CVR;
  }

  public String getJobTitle(){
    return jobTitle;
  }
}
