package main.client.view.handyman;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanFindWorkResultViewModel;
import main.client.viewmodel.handyman.HandymanFindWorkViewModel;
import main.shared.model.JobOffer;

import java.util.ArrayList;

public class HandymanFindWorkResultView extends SwitchTabsView
{
    @FXML private ListView listView;
    @FXML private Label labelError;
    private ViewHandler viewHandler;
    private HandymanFindWorkResultViewModel viewModel;

    public void init(ViewHandler viewHandler, HandymanFindWorkResultViewModel viewModel){
        super.init(viewHandler);
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        labelError.textProperty().bindBidirectional(viewModel.getLabelError());
        setListView();
    }

    public void setListView(){
        ArrayList<JobOffer> jobOfferList = viewModel.getJobOfferList();
        if(jobOfferList.isEmpty()){
            labelError.setText("Nothing found");
        }else{
            for(int i=0; i<jobOfferList.size(); i++){
                listView.getItems().add(jobOfferList.get(i).getJobTitle());
            }
        }
    }
}
