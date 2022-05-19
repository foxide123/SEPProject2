package main.client.server;

import main.shared.model.Client;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.rmi.Remote;

public interface RemoteServer extends Remote
{
  Handyman logInHandyman(String CVR, String password) throws Exception;
  Client loginClient(String CPR, String password) throws Exception;

  void createClientAccount(Client client, String password) throws Exception;

  void createHandymanAccount(Handyman handyman, String password) throws Exception;

  void createJobOffer(JobOffer jobOffer) throws Exception;
}
