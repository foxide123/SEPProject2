package main.client.model;

import main.shared.model.*;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Model
{
  Client getClient();
  Handyman getHandyman();
  void logInClient(int CPR, String password) throws Exception;
  void logInHandyman(int CVR, String password) throws Exception;
  void signUpClient(Client client, String password) throws Exception;
  void signUpHandyman(Handyman handyman, String password) throws Exception;
  void updateHandyman(Handyman handyman) throws Exception;
  void updateClient(Client client) throws Exception;
  void createJob(JobOffer job) throws Exception;
  ArrayList<JobOffer> getJobOffers() throws RemoteException;
  void findHandyman(Address address, Skills skills, int hourlyRate)
      throws Exception;
  ArrayList<Handyman> findHandymanResult();
  void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
  void removePropertyChangeListener(String eventName, PropertyChangeListener listener);
  ArrayList<JobOffer> handymanFindWorkResult();
  void findWork(Address address, JobType type, int minBudget)
      throws Exception;
  public ArrayList<JobOffer> findJobResult();
  JobOffer findJobOfferWithTitle(String title);
  JobOffer getClientSelectedOffer(String title) throws RemoteException;
  void addToAppliedJobs(JobOffer jobOffer) throws Exception;
  ArrayList<Handyman> getAppliedHandymanList(String jobTitle) throws Exception;
  void setSelectedAppliedHandyman(Handyman handyman);
  ArrayList<JobOffer> getAppliedJobs();

}
