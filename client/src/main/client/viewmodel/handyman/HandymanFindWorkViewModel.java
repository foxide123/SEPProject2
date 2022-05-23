package main.client.viewmodel.handyman;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import main.client.model.Model;
import main.shared.model.Address;
import main.shared.model.JobOffer;
import main.shared.model.JobType;

import java.util.ArrayList;

public class HandymanFindWorkViewModel
{
    private Model model;
    @FXML private StringProperty city;
    @FXML private StringProperty zip;
    @FXML private DoubleProperty minBudget;
    @FXML private StringProperty minBudgetLabel;

    public HandymanFindWorkViewModel(Model model){
        this.model = model;
        this.city = new SimpleStringProperty("");
        this.zip = new SimpleStringProperty("");
        this.minBudget = new SimpleDoubleProperty();
        this.minBudgetLabel = new SimpleStringProperty("budget");

        minBudget.addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {

                        minBudgetLabel.setValue("value: " + minBudget.getValue());
                    }
                });
    }

    public boolean lookForWork(boolean plumbing, boolean electrical, boolean masonry, boolean groundworking)
            throws Exception
    {
        try{
            model.findWork(new Address(
                            city.get(), zip.get()),
                    new JobType(plumbing, electrical, masonry, groundworking),
                    Integer.parseInt(String.valueOf(minBudget.get()))
            );
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public StringProperty getCityProperty(){return city;}
    public StringProperty getZipProperty(){return zip;}
    public DoubleProperty getHourlyRateProperty(){return minBudget;}
    public StringProperty getHourlyRateLabelProperty(){return minBudgetLabel;}
}
