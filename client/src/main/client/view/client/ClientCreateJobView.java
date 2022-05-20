package main.client.view.client;

        import javafx.event.ActionEvent;
        import javafx.scene.control.TextArea;
        import main.client.view.ViewHandler;
        import main.client.viewmodel.client.ClientCreateJobViewModel;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import main.shared.model.JobType;

        import java.io.IOException;
        import java.util.ArrayList;

public class ClientCreateJobView  extends SwitchTabsView{
    private ClientCreateJobViewModel viewModel;
    private ViewHandler viewHandler;

    @FXML
    private TextField jobTitle;
    @FXML
    private TextArea jobDescription;
    @FXML
    private TextField jobBudget;
    @FXML
    private TextField city;
    @FXML
    private TextField zipCode;
    @FXML
    private Label error;

    private ArrayList<String> jobType;



    public void init(ViewHandler viewHandler, ClientCreateJobViewModel viewModel) {
      super.init(viewHandler);
        this.viewModel = viewModel;

        jobTitle.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
        jobBudget.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
        jobDescription.textProperty().bindBidirectional(viewModel.getJobDescriptionProperty());
        city.textProperty().bindBidirectional(viewModel.getCityProperty());
        zipCode.textProperty().bindBidirectional(viewModel.getZipCodeProperty());


    }
    @FXML
    public void createJob(ActionEvent event) throws IOException {
        if (viewModel.createJob())
            viewHandler.openView("client_create_offer");
    }


}

