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

  public void updateHandyman(Handyman handyman) throws Exception{
    server.updateHandyman(handyman);
  }

  public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception{
    return server.findHandyman(address, skills, hourlyRate);
  }

  @Override public ArrayList<JobOffer> findWork(Address address, JobType type,
      double minBudget) throws Exception
  {
    return server.findWork(address,type, minBudget);
  }

  public void updateClient(Client client) throws Exception{
    server.updateClient(client);
  }

  public void createJobOffer(JobOffer jobOffer) throws Exception{
    server.createJobOffer(jobOffer);
  }
}
