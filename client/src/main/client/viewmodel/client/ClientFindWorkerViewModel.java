package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.Handyman;
import main.shared.model.Skills;

import java.util.ArrayList;

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

  public ArrayList<Handyman> onSearch(boolean plumber, boolean electrician, boolean mason, boolean groundworker){
    return model.findHandyman(new Address(
        city.get(), zip.get()),
        new Skills(plumber, electrician, mason, groundworker),
        Integer.parseInt(hourlyRate.get())
    );
  }

  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public StringProperty getHourlyRateProperty(){return hourlyRate;}
}
