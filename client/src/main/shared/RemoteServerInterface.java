package main.shared;

import main.shared.model.Client;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.rmi.Remote;

public interface RemoteServerInterface extends Remote
{
  Handyman logInHandyman(int CVR, String password) throws Exception;
  Client loginClient(int CPR, String password) throws Exception;

  void createClientAccount(Client client, String password) throws Exception;

  void createHandymanAccount(Handyman handyman, String password) throws Exception;

   void updateHandyman(Handyman handyman) throws Exception;

  void createJobOffer(JobOffer jobOffer) throws Exception;
}
