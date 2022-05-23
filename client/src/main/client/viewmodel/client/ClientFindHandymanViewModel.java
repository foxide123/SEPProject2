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

  public ClientFindHandymanViewModel(Model model){
    this.model = model;
    this.city = new SimpleStringProperty("");
    this.zip = new SimpleStringProperty("");
  }

  public boolean onSearch(boolean plumber, boolean electrician, boolean mason,
      boolean groundworker, String hourlyRate)
      throws Exception
  {
    System.out.println("city: " + city.get());
    System.out.println("zip: " + zip.get());
    System.out.println("plumber: " + plumber);
    System.out.println("electrician: " + electrician);
    System.out.println("mason: " + mason);
    System.out.println("groundworker: " + groundworker);
    System.out.println("hourlyRate: " + hourlyRate);

    try{
       model.findHandyman(new Address(
              city.get(), zip.get()),
          new Skills(plumber, electrician, mason, groundworker),
          Integer.parseInt(hourlyRate)
      );
      return true;
    }catch (Exception e){
      return false;
    }
  }

  public StringProperty getCityProperty(){return city;}
  public StringProperty getZipProperty(){return zip;}
}
