package main.client.view.client;

        import javafx.event.ActionEvent;
        import javafx.scene.control.*;
        import main.client.view.ViewHandler;
        import main.client.viewmodel.client.ClientCreateJobViewModel;
        import javafx.fxml.FXML;
        import main.shared.model.JobType;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Optional;

public class ClientCreateJobView  extends SwitchTabsView{
    private ClientCreateJobViewModel viewModel;
    private ViewHandler viewHandler;


  @FXML private RadioButton rb_plumber;
  @FXML private RadioButton rb_electrician;
  @FXML private RadioButton rb_mason;
  @FXML private RadioButton rb_groundworker;

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
        this.viewHandler = viewHandler;

        jobTitle.textProperty().bindBidirectional(viewModel.getJobTitleProperty());
        jobBudget.textProperty().bindBidirectional(viewModel.getJobBudgetProperty());
        jobDescription.textProperty().bindBidirectional(viewModel.getJobDescriptionProperty());
        city.textProperty().bindBidirectional(viewModel.getCityProperty());
        zipCode.textProperty().bindBidirectional(viewModel.getZipCodeProperty());


    }

    @FXML
    public void createJob(ActionEvent event) throws IOException {
      JobType jobType = new JobType(rb_plumber.isSelected(), rb_electrician.isSelected(),
          rb_mason.isSelected(), rb_groundworker.isSelected());

        if (viewModel.createJob(jobType)){
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Confirmation Dialog");
          alert.setHeaderText("Look, a Confirmation Dialog");
          alert.setContentText("You have successfully created job offer");


          alert.showAndWait();
        }
    }


}

