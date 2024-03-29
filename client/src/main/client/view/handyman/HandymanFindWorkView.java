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

    @FXML private RadioButton rb_plumber;
    @FXML private RadioButton rb_electrician;
    @FXML private RadioButton rb_mason;
    @FXML private RadioButton rb_groundworker;

    @FXML private TextField tf_city;
    @FXML private TextField tf_zip;

    @FXML private Slider hourlyRate;
    @FXML private Label hourlyRateLabel;

    private HandymanFindWorkViewModel viewModel;
    private ViewHandler viewHandler;

    public void init(ViewHandler viewHandler, HandymanFindWorkViewModel viewModel){
        super.init(viewHandler);
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        tf_city.textProperty().bindBidirectional(viewModel.getCityProperty());
        tf_zip.textProperty().bindBidirectional(viewModel.getZipProperty());
        //hourlyRate.blockIncrementProperty().bindBidirectional(viewModel.getHourlyRateProperty());
        //hourlyRateLabel.textProperty().bindBidirectional(viewModel.getHourlyRateLabelProperty());

        hourlyRate.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {

                        hourlyRateLabel.setText(String.valueOf((int) hourlyRate.getValue()));
                    }
                });
    }

    @FXML public void onSearch(ActionEvent event) throws Exception
    {
        if (viewModel.lookForWork(rb_plumber.isSelected(), rb_electrician.isSelected(),
                rb_mason.isSelected(), rb_groundworker.isSelected(),
            hourlyRateLabel.getText()))
        {
            viewHandler.openView("HandymanFindWorkResult");
        }
        else{
            System.out.println("Nothing found");
        }
    }

}

