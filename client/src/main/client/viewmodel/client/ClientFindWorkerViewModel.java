package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;

public class ClientFindWorkerViewModel
{
  private Model model;
  @FXML private StringProperty city;
  @FXML private StringProperty zip;
  @FXML private StringProperty hourlyRate;

  public ClientFindWorkerViewModel(Model model){
    this.model = model;
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.hourlyRate = new SimpleStringProperty("");
  }

  public boolean onSearch(boolean plumber, boolean electrician, boolean mason, boolean groundworker){

    return plumber;
  }

  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
}
