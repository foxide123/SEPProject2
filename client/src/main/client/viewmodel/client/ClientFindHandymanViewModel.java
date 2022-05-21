package main.client.viewmodel.client;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.Handyman;
import main.shared.model.Skills;

import java.util.ArrayList;

public class ClientFindHandymanViewModel
{
  private Model model;
  @FXML private StringProperty city;
  @FXML private StringProperty zip;
  @FXML private DoubleProperty hourlyRate;
  @FXML private StringProperty hourlyRateLabel;

  public ClientFindHandymanViewModel(Model model){
    this.model = model;
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
    this.hourlyRate = new SimpleDoubleProperty();
    this.hourlyRateLabel = new SimpleStringProperty("budget");

    hourlyRate.addListener(
        new ChangeListener<Number>() {

          public void changed(ObservableValue<? extends Number >
              observable, Number oldValue, Number newValue)
          {

            hourlyRateLabel.setValue("value: " + hourlyRate.getValue());
          }
        });
  }

  public boolean onSearch(boolean plumber, boolean electrician, boolean mason, boolean groundworker)
      throws Exception
  {
    try{
       model.findHandyman(new Address(
              city.get(), zip.get()),
          new Skills(plumber, electrician, mason, groundworker),
          Integer.parseInt(String.valueOf(hourlyRate.get()))
      );
      return true;
    }catch (Exception e){
      return false;
    }
  }

  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
  public DoubleProperty getHourlyRateProperty(){return hourlyRate;}
  public StringProperty getHourlyRateLabelProperty(){return hourlyRateLabel;}
}
