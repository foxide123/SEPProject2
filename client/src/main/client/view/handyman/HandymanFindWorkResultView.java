package main.client.view.handyman;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import main.client.view.ViewHandler;
import main.client.viewmodel.handyman.HandymanFindWorkResultViewModel;
import main.shared.model.JobOffer;

import java.io.IOException;
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
                System.out.println("job title: " + jobOfferList.get(i).getJobTitle());
                System.out.println("location: " + jobOfferList.get(i).getLocation().getCity());
                listView.getItems().add(jobOfferList.get(i).getJobTitle());

            }


            getJobOfferObject();
        }
    }

    public JobOffer getJobOfferObject(){
        final String[] selectedJobOffer = new String[1];
        try{


            listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

                @Override public void changed(
                    ObservableValue<? extends String> observableValue,
                    String s, String t1)
                {
                    selectedJobOffer[0] = (String) listView.getSelectionModel().getSelectedItem();
                    if (viewModel.getJobOfferObject(selectedJobOffer[0]) != null)
                    {
                        try
                        {
                            viewHandler.openView("FindWorkSelectedWork");
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
