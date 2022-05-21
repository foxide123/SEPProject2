package main.client.model;

import main.shared.model.*;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model
{
  Client getClient();
  Handyman getHandyman();
  void logInClient(int CPR, String password) throws Exception;
  void logInHandyman(int CVR, String password) throws Exception;
  void signUpClient(Client client, String password) throws Exception;
  void signUpHandyman(Handyman handyman, String password) throws Exception;
  void updateHandyman(Handyman handyman) throws Exception;
  void updateClient(Client client) throws Exception;
  void createJob(JobOffer job) throws Exception;
  void findHandyman(Address address, Skills skills, int hourlyRate)
      throws Exception;
  ArrayList<Handyman> findHandymanResult();
  void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
  void removePropertyChangeListener(String eventName, PropertyChangeListener listener);
}
