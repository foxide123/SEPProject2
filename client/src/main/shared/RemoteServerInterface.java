package main.shared;

import main.shared.model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteServerInterface extends Remote
{
  Handyman logInHandyman(int CVR, String password) throws Exception;
  Client loginClient(int CPR, String password) throws Exception;

  void createClientAccount(Client client, String password) throws Exception;

  void createHandymanAccount(Handyman handyman, String password) throws Exception;

   void updateHandyman(Handyman handyman, String password) throws Exception;

   void updateClient(Client client, String password) throws Exception;

  void createJobOffer(JobOffer jobOffer) throws Exception;

  void addApplied(JobOffer jobOffer, long cvr) throws Exception;

  ArrayList<JobOffer> getAppliedJobs(long CVR) throws RemoteException;

  ArrayList<Handyman> getAppliedHandyman(String jobTitle) throws RemoteException;

  ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception;
  ArrayList<JobOffer> findWork(Address address, JobType type, int minBudget) throws Exception;

  ArrayList<JobOffer> clientManageOffers(long CPR) throws RemoteException;
}

