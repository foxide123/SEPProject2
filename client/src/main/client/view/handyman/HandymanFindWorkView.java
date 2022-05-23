package main.client.view.handyman;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanFindWorkViewModel;

public class HandymanFindWorkView extends SwitchTabsView {
    @FXML
    private RadioButton plumbing_ct;
    @FXML private RadioButton electricity_ct;
    @FXML private RadioButton masonry_ct;
    @FXML private RadioButton groundworking_ct;
    @FXML private TextField city_ad;
    @FXML private TextField zip_ad;
    @FXML private Slider minBudget;
    @FXML private Label minBudgetLabel;

    private HandymanFindWorkViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, HandymanFindWorkViewModel viewModel){
        super.init(viewHandler);
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        city_ad.textProperty().bindBidirectional(viewModel.getCityProperty());
        zip_ad.textProperty().bindBidirectional(viewModel.getZipProperty());
        minBudget.blockIncrementProperty().bindBidirectional(viewModel.getHourlyRateProperty());
        minBudgetLabel.textProperty().bindBidirectional(viewModel.getHourlyRateLabelProperty());

        minBudget.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {

                        minBudgetLabel.setText("value: " + minBudget.getValue());
                    }
                });
    }

    @FXML public void lookForWork(ActionEvent event) throws Exception
    {
        if (viewModel.lookForWork(plumbing_ct.isSelected(), electricity_ct.isSelected(),
                masonry_ct.isSelected(), groundworking_ct.isSelected()))
        {
            viewHandler.openView("FindWorkResult");
        }
        else{
            System.out.println("Nothing found");
        }
    }

}

