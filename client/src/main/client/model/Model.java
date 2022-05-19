package main.client.model;

import main.shared.model.Client;
import main.shared.model.Handyman;
import main.shared.model.JobOffer;

import java.beans.PropertyChangeListener;

public interface Model
{
  void logInClient(int CPR, String password) throws Exception;
  void logInHandyman(int CVR, String password) throws Exception;
  void signUpClient(Client client, String password) throws Exception;
  void signUpHandyman(Handyman handyman, String password) throws Exception;
  void updateHandyman(Handyman handyman) throws Exception;
  void createJob(JobOffer job) throws Exception;
  void addPropertyChangeListener(String eventName, PropertyChangeListener listener);
  void removePropertyChangeListener(String eventName, PropertyChangeListener listener);
}
