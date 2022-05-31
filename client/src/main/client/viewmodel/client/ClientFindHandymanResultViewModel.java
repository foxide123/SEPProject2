package main.client.viewmodel.client;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.client.model.Model;
import main.shared.model.Handyman;

import java.util.ArrayList;

public class ClientFindHandymanResultViewModel
{
  private Model model;
  private StringProperty labelError;

  public ClientFindHandymanResultViewModel(Model model){
    this.model = model;
    this.labelError = new SimpleStringProperty("");
  }

  public ArrayList<Handyman> getHandymanList(){
    return model.findHandymanResult();
  }

  public Handyman findHandymanWithCVR(long CVR) throws Exception
  {
    return model.findHandymanWithCVR(CVR);
  }


  public StringProperty getLabelError(){
    return labelError;
  }
}
