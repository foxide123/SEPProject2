package main.client.model;


import main.client.server.Server;
import main.shared.model.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private PropertyChangeSupport support;
  private Server server;

  private Handyman handyman;
  private Client client;
  private ArrayList<Handyman> findHandymanResultList;
  private ArrayList<JobOffer> findWorkResultList;
  private ArrayList<JobOffer> jobOffers;
  private ArrayList<Handyman> appliedHandymanList;
  private Handyman appliedHandyman;

  private ArrayList<JobOffer> clientManageOfferList;
  private JobOffer clientSelectedOffer;


  private ArrayList<Handyman> handymanAccounts;
  private ArrayList<Client> clientAccounts;

  public ModelManager() throws NotBoundException, RemoteException
  {
    this.support = new PropertyChangeSupport(this);
    this.findHandymanResultList = new ArrayList<>();
    this.findWorkResultList = new ArrayList<>();
    this.jobOffers = new ArrayList<>();
    server = new Server();
  }

  public Client getClient()
  {
    return client;
  }

  public Handyman getHandyman()
  {
    return handyman;
  }

  public void findHandyman(Address address, Skills skills, int hourlyRate)
      throws Exception
  {
    findHandymanResultList = server.findHandyman(address,skills,hourlyRate);
  }

  public ArrayList<Handyman> findHandymanResult(){
    return findHandymanResultList;
  }

  public void findWork(Address address, JobType type, int minBudget)
          throws Exception
  {
    findWorkResultList = server.findWork(address,type,minBudget);
  }

  // dono
  //public ArrayList<Handyman> getHandymanAccounts(){

  //}

  //might need to delete

  public ArrayList<JobOffer> findJobResult(){
    return findWorkResultList;
  }

  public JobOffer findJobOfferWithTitle(String title){
    for(int i=0; i<findWorkResultList.size(); i++){
      System.out.println("title: " + title);
      System.out.println("title: " + i + ", " + findWorkResultList.get(i).getJobTitle());
      if(findWorkResultList.get(i).getJobTitle().equals(title)){
        support.firePropertyChange("JobOfferFound",null,findWorkResultList.get(i));
        return findWorkResultList.get(i);
      }
    }
    return null;
  }

  public JobOffer getClientSelectedOffer(String title) throws RemoteException
  {
    for(int i=0; i<clientManageOfferList.size(); i++){
      if(clientManageOfferList.get(i).getJobTitle().equals(title)){
        support.firePropertyChange("ClientSelectedOffer", null, clientManageOfferList.get(i));
        return clientManageOfferList.get(i);
      }
    }
    return null;
  }

  public void addToAppliedJobs(JobOffer jobOffer) throws Exception
  {
    server.addApplied(jobOffer, getHandyman().getCVR());
  }

  public ArrayList<JobOffer> getAppliedJobs() throws RemoteException
  {
    return server.getAppliedJobs(getHandyman().getCVR());
  }

  public void handymanDeleteApplied(String jobTitle) throws RemoteException
  {
    server.handymanDeleteApplied(jobTitle, getHandyman().getCVR());
  }

  public JobOffer getAppliedJobFromTitle(String jobTitle) throws RemoteException
  {
    ArrayList<JobOffer> tmpList;
    tmpList = server.getAppliedJobs(getHandyman().getCVR());
    for(int i=0; i<tmpList.size(); i++){
      if(tmpList.get(i).getJobTitle().equals(jobTitle)){
        support.firePropertyChange("JobOfferFound", null, tmpList.get(i));
        return tmpList.get(i);
      }
    }
    return null;
  }

  public ArrayList<Handyman> getAppliedHandymanList(String jobTitle) throws Exception
  {
    appliedHandymanList = server.getAppliedHandyman(jobTitle);
    return appliedHandymanList;
  }

  public void setSelectedAppliedHandyman(Handyman handyman){
    appliedHandyman = handyman;
    support.firePropertyChange("AppliedHandyman",null,appliedHandyman);
  }


  public void logInClient(int CPR, String password) throws Exception
  {
    if(CPR ==0 || password.isEmpty()){
      throw new Exception("Fill in CPR / password");
    }
    /*
    if(CPR.isEmpty() || password.isEmpty()){
      throw new Exception("Fill in CPR / password");
    }
     */
    client = server.loginClient(CPR, password);

    support.firePropertyChange("ClientLoggedIn", null,client);
  }

  public void logInHandyman(int CVR, String password) throws Exception
  {

    if(CVR==0 || password.isEmpty()){
      throw new Exception("Fill in CPR / password");
    }
    handyman = server.logInHandyman(CVR, password);
    support.firePropertyChange("HandymanLoggedIn", null, handyman);
  }

  public void signUpClient(Client client, String password) throws Exception
  {
    server.createClientAccount(client, password);
    support.firePropertyChange("ClientSignedUp", null,client);
  }

  public void signUpHandyman(Handyman handyman, String password)
      throws Exception
  {
    server.createHandymanAccount(handyman, password);
    support.firePropertyChange("HandymanSignedUp", null, handyman);
  }

  public void updateHandyman(Handyman handyman, String password) throws Exception{
    server.updateHandyman(handyman, password);
    support.firePropertyChange("HandymanUpdated",null,handyman);
  }

  public void updateClient(Client client, String password) throws Exception{
    server.updateClient(client, password);
    support.firePropertyChange("ClientUpdated",null,client);
  }

  public void createJob(JobOffer job) throws Exception {
    jobOffers.add(job);
    server.createJobOffer(job);
  }

  public ArrayList<JobOffer> getJobOffers() throws RemoteException
  {
    clientManageOfferList = server.clientManageOffers(getClient().getCPR());
    return clientManageOfferList;
  }

  public void addPropertyChangeListener(
      String eventName,  PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override
  public ArrayList<JobOffer> handymanFindWorkResult() {
    return jobOffers;
  }
}
