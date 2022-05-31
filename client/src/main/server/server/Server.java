package main.server.server;

import main.shared.RemoteServerInterface;
import main.shared.model.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteServerInterface
{
  private Database database;

  public Server() throws RemoteException
  {
    //UnicastRemoteObject.exportObject(this, 0);
    database = new Database();
  }

  @Override public Handyman logInHandyman(int CVR, String password)
      throws Exception
  {
    Handyman handyman = null;
    try {
      handyman = database.loginHandyman(CVR, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if(handyman == null){
      System.out.println("handyman is null");
    }else{
      return handyman;
    }
    return null;
  }

  @Override public Client loginClient(int CPR, String password)
      throws Exception
  {
    Client client = null;
    try {
      client = database.loginClient(CPR, password);
    } catch (Exception e) {
      throw new RemoteException(e.getMessage());
    }
    if(client == null){
      System.out.println("client is null");
    }else{
      return client;
    }
    return null;
  }

  @Override public void createClientAccount(Client client, String password)
      throws Exception
  {
    System.out.println("inside main.client.main.server-main.client.main.server createClientAccount");
    try {
      database.createClientAccount(client,password);
    } catch (Exception e) {
      throw new RemoteException(e.getMessage());
    }
  }

  @Override public void createHandymanAccount(Handyman handyman,
      String password) throws Exception
  {
    try {
      database.createHandymanAccount(handyman,password);
      database.insertSkills(handyman);
    } catch (Exception e) {
      throw new RemoteException(e.getMessage());
    }
  }

  public void updateHandyman(Handyman handyman, String password) throws Exception{
    try{
      database.updateHandyman(handyman, password);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception{
    System.out.println("b");
    return database.findHandyman(address,skills,hourlyRate);
  }
  /*
  public ArrayList<Handyman> getHandymanAccount(){
    return database.f
  }

   */

  public void deleteAccount(String id) throws Exception{
    //System.out.println("b");
    try
    {
      database.deleteAccount(id);
    }
    catch (Exception e)
    {
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<Handyman> findAllHandyman() throws Exception{
    //System.out.println("b");
    return database.findAllHandyman();
  }

  public ArrayList<Client> findAllClient() throws Exception{
    //System.out.println("b");
    return database.findAllClient();
  }

  public Handyman findHandymanWithCVR(long CVR) throws Exception
  {
    return database.findHandymanWithCVR(CVR);
  }

  @Override
  public ArrayList<JobOffer> findWork(Address address, JobType type, int minBudget) throws Exception {
    try{
       return database.findWork(address,type,minBudget);
    }catch (Exception e) {
      throw new RemoteException(e.getMessage());
    }

  }

  public void updateClient(Client client, String password) throws Exception{
    try{
      database.updateClient(client, password);
    }catch(Exception e){
      e.printStackTrace();
      throw new RemoteException(e.getMessage());
    }
  }

  public void createJobOffer(JobOffer jobOffer) throws Exception {
    try{
      System.out.println("jobType: " + jobOffer.getJobTypeList().get(0));
      System.out.println(jobOffer.getLocation().getCity());
      System.out.println(jobOffer.getLocation().getZip());
      database.createJob(jobOffer);
      database.insertJobType(jobOffer);
    } catch (Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public void addApplied(JobOffer jobOffer, long cvr) throws RemoteException
  {
    try{
      database.addApplied(jobOffer, cvr);
    } catch (Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<JobOffer> getAppliedJobs(long CVR) throws RemoteException
  {
    try{
      return database.getAppliedJobs(CVR);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public void handymanDeleteApplied(String jobTitle, long CVR) throws RemoteException
  {
    try{
      database.handymanDeleteApplied(jobTitle, CVR);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<Handyman> getAppliedHandyman(String jobTitle) throws RemoteException{
    try{
      return database.getAppliedHandyman(jobTitle);
    } catch (Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<JobOffer> clientManageOffers(long CPR) throws RemoteException
  {
    try{
      return database.clientManageOffers(CPR);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public JobType getJobType(String jobTitle)
  {
      return database.getJobType(jobTitle);
  }
}
