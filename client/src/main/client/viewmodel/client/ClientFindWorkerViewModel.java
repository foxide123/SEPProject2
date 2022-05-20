package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.Skills;

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
    model.findHandyman(new Address(city.get(), zip.get()), new Skills(plumber, electrician, mason, groundworker));
    return plumber;
  }

  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
}
