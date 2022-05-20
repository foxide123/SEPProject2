package main.client.view.client;

        import main.client.view.ViewHandler;
        import main.client.viewmodel.client.ClientCreateJobViewModel;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;

        import java.util.ArrayList;

public class ClientCreateJobView  {
    private ClientCreateJobViewModel viewModel;
    private ViewHandler viewHandler;

    @FXML
    private TextField jobTitle;
    @FXML
    private TextField jobDescription;
    @FXML
    private TextField jobBudget;
    @FXML
    private TextField city;
    @FXML
    private TextField zipCode;
    @FXML
    private Label error;

    private ArrayList<String> jobSkills;



    public void init(ViewHandler viewHandler, ClientCreateJobViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

        jobTitle.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
        jobBudget.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
        jobDescription.textProperty().bindBidirectional(viewModel.getJobDescriptionProperty());
        city.textProperty().bindBidirectional(viewModel.getCityProperty());
        zipCode.textProperty().bindBidirectional(viewModel.getZipCodeProperty());


    }
}

