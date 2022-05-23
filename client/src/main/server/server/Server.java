package main.server.server;

import main.shared.model.*;
import main.shared.RemoteServerInterface;

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
      throw new RemoteException(e.getMessage());
    }
    return handyman;
  }

  @Override public Client loginClient(int CPR, String password)
      throws Exception
  {
    System.out.println(CPR);
    System.out.println(password);
    Client client = null;
    try {
      client = database.loginClient(CPR, password);
    } catch (Exception e) {
      throw new RemoteException(e.getMessage());
    }
    if(client == null){
      System.out.println("main.client is null");
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

  public void updateHandyman(Handyman handyman) throws Exception{
    try{
      database.updateHandyman(handyman);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception{
    System.out.println(database.getSkills(54321).getElectricianBoolean());
    System.out.println(database.getSkills(54321).getMasonBoolean());
    System.out.println(database.getSkills(54321).getPlumberBoolean());
    System.out.println(database.getSkills(54321).getGroundWorkerBoolean());
    return database.findHandyman(address,skills,hourlyRate);
  }

  public void updateClient(Client client) throws Exception{
    try{
      database.updateClient(client);
    }catch(Exception e){
      throw new RemoteException(e.getMessage());
    }
  }

  public void createJobOffer(JobOffer jobOffer) throws Exception {
    try{database.createJob(jobOffer);
    } catch (Exception e){
      throw new RemoteException(e.getMessage());
    }

  }
}
