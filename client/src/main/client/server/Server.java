package main.client.server;

import main.shared.model.*;
import main.shared.RemoteServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RemoteServerInterface
{
  private RemoteServerInterface server;

  public Server() throws NotBoundException, RemoteException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RemoteServerInterface) registry.lookup("Server");
  }

   public Handyman logInHandyman(int CVR, String password)
      throws Exception
  {
    return server.logInHandyman(CVR, password);
  }

   public Client loginClient(int CPR, String password)
      throws Exception
  {
    return server.loginClient(CPR, password);
  }

  public void createClientAccount(Client client, String password)
      throws Exception
  {
    System.out.println("inside main.client-main.client.main.server createClientAccount");
    server.createClientAccount(client, password);
  }

  public void createHandymanAccount(Handyman handyman,
      String password) throws Exception
  {
    server.createHandymanAccount(handyman,password);
  }

  public void updateHandyman(Handyman handyman, String password) throws Exception{
    server.updateHandyman(handyman, password);
  }

  public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception{
    return server.findHandyman(address, skills, hourlyRate);
  }

  public ArrayList<Handyman> findAllHandyman() throws Exception{
    return server.findAllHandyman();
  }

  public ArrayList<Client> findAllClient() throws Exception{
    System.out.println("i");
    return server.findAllClient();
  }

  public Handyman findHandymanWithCVR(long CVR) throws Exception
  {
    return server.findHandymanWithCVR(CVR);
  }

  @Override public ArrayList<JobOffer> findWork(Address address, JobType type,
      int minBudget) throws Exception
  {
    return server.findWork(address,type, minBudget);
  }

  public void updateClient(Client client, String password) throws Exception{
    server.updateClient(client, password);
  }

  public void createJobOffer(JobOffer jobOffer) throws Exception{
    server.createJobOffer(jobOffer);
  }

  public void addApplied(JobOffer jobOffer, long cvr) throws Exception{
    server.addApplied(jobOffer, cvr);
  }

  public ArrayList<JobOffer> getAppliedJobs(long CVR) throws RemoteException
  {
    try{
      return server.getAppliedJobs(CVR);
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public void handymanDeleteApplied(String jobTitle, long CVR)
      throws RemoteException
  {
    server.handymanDeleteApplied(jobTitle, CVR);
  }

  public ArrayList<Handyman> getAppliedHandyman(String jobTitle) throws RemoteException{
    return server.getAppliedHandyman(jobTitle);
  }

  public ArrayList<JobOffer> clientManageOffers(long CPR) throws RemoteException
  {
    return server.clientManageOffers(CPR);
  }

  public void deleteAccount(String id)
      throws Exception
  {
    server.deleteAccount(id);
  }

  public JobType getJobType(String jobTitle) throws RemoteException
  {
    return server.getJobType(jobTitle);
  }
}
