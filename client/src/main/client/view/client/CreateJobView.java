package main.client.view.client;

        import main.client.view.ViewHandler;
        import main.client.viewmodel.client.CreateJobViewModel;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;

        import java.util.ArrayList;

public class CreateJobView  {
    private CreateJobViewModel viewModel;

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



    public void init(ViewHandler viewHandler, CreateJobViewModel viewModel){
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;

        jobTitle.textProperty().bindBidirectional(viewModel.jobTitleProperty());
        jobDescription.textProperty().bindBidirectional(viewModel.);
    }
}

