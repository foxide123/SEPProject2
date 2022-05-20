package main.shared;

import main.shared.model.*;

import java.rmi.Remote;
import java.util.ArrayList;

public interface RemoteServerInterface extends Remote
{
  Handyman logInHandyman(int CVR, String password) throws Exception;
  Client loginClient(int CPR, String password) throws Exception;

  void createClientAccount(Client client, String password) throws Exception;

  void createHandymanAccount(Handyman handyman, String password) throws Exception;

   void updateHandyman(Handyman handyman) throws Exception;

   void updateClient(Client client) throws Exception;

  void createJobOffer(JobOffer jobOffer) throws Exception;

  ArrayList<Handyman> findHandyman(Address address, Skills skills, int hourlyRate) throws Exception;
}
