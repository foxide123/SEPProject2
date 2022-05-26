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

  public void updateHandyman(Handyman handyman) throws Exception{
    server.updateHandyman(handyman);
    support.firePropertyChange("HandymanUpdated",null,handyman);
  }

  public void updateClient(Client client) throws Exception{
    server.updateClient(client);
    support.firePropertyChange("ClientUpdated",null,client);
  }

  public void createJob(JobOffer job) throws Exception {
    jobOffers.add(job);
    server.createJobOffer(job);
  }

  public ArrayList<JobOffer> getJobOffers(){
    return jobOffers;
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
