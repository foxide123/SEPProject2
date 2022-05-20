package main.client.view;

import main.client.view.client.*;
import main.client.view.handyman.*;
import main.client.view.admin.AdminLogInView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import main.client.viewmodel.ViewModelProvider;
import main.client.viewmodel.handyman.HandymanFindWorkViewModel;

import java.io.IOException;

public class ViewHandler
{
  private Stage localStage;
  private ViewModelProvider mvViewModel;

  public ViewHandler(ViewModelProvider mvViewModel){
    this.mvViewModel = mvViewModel;
  }

  public void start(Stage stage) throws Exception{
    this.localStage = stage;
    openView("LogInRegister");
  }

  public void openView(String viewToOpen) throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    if("LogInRegister".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/LogInRegister.fxml"));
      root = loader.load();
      LogInRegisterView view = loader.getController();
      view.init(this, mvViewModel.getLogInRegisterViewModel());
      localStage.setTitle("LogInRegister");
    }
    else if("ChooseActorLogIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/ChooseActor_LogIn.fxml"));
      root = loader.load();
      ChooseActorLogInView view = loader.getController();
      view.init(this, mvViewModel.getChooseActorLogInViewModel());
      localStage.setTitle("ChooseActorLogIn");
    }
    else if("ChooseActorSignUp".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/ChooseActor_SignUp.fxml"));
      root = loader.load();
      ChooseActorSignUpView view = loader.getController();
      view.init(this, mvViewModel.getChooseActorSignUpViewModel());
      localStage.setTitle("ChooseActorSignUp");
    }
    else if("ClientLogIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/ClientLogIn.fxml"));
      root = loader.load();
      ClientLogInView view = loader.getController();
      view.init(this, mvViewModel.getClientLogInViewModel());
      localStage.setTitle("ClientLogIn");
    }
    else if("HandymanLogIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/HandymanLogIn.fxml"));
      root = loader.load();
      HandymanLogInView view = loader.getController();
      view.init(this, mvViewModel.getHandymanLogInViewModel());
      localStage.setTitle("HandymanLogIn");
    }
    else if("AdminLogIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/AdminLogIn.fxml"));
      root = loader.load();
      AdminLogInView view = loader.getController();
      view.init(this, mvViewModel.getAdminLogInViewModel());
      localStage.setTitle("HandymanLogIn");
    }
    else if("HandymanSignUp".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/HandymanSignUp.fxml"));
      root = loader.load();
      HandymanSignUpView view = loader.getController();
      view.init(this, mvViewModel.getHandymanSignUpViewModel());
      localStage.setTitle("HandymanSignUp");

    }else if("ClientSignUp".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/ClientSignUp.fxml"));
      root = loader.load();
      ClientSignUpView view = loader.getController();
      view.init(this, mvViewModel.getClientSignUpViewModel());
      localStage.setTitle("ClientSignUp");
    }
    else if("ClientLoggedIn".equals(viewToOpen) || "ManageProfile".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/ClientLoggedIn.fxml"));
      root = loader.load();
      ClientLoggedInView view = loader.getController();
      view.init(this, mvViewModel.getClientLoggedInViewModel());
      localStage.setTitle("ClientLoggedIn");
    }
    else if("HandymanLoggedIn".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/HandymanLoggedIn.fxml"));
      root = loader.load();
      HandymanLoggedInView view = loader.getController();
      view.init(this, mvViewModel.getHandymanLoggedInViewModel());
      localStage.setTitle("HandymanLoggedIn");
    }
    else if("ClientFindWorker".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/client_search.fxml"));
      root = loader.load();
      ClientFindWorkerView view = loader.getController();
      view.init(this, mvViewModel.getFindWorkerViewModel());
      localStage.setTitle("FindWorker");
    }

    else if("ClientCreateOffer".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/client_create_offer.fxml"));
      root = loader.load();
      ClientCreateJobView view = loader.getController();
      view.init(this, mvViewModel.getCreateJobViewModel());
      localStage.setTitle("CreateOffer");
    }
    else if("ClientCreateJob".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/client_create_offer.fxml"));
      root = loader.load();
      ClientCreateJobView view = loader.getController();
      view.init(this, mvViewModel.getCreateJobViewModel());
      localStage.setTitle("CreateJob");
    }
    else if("ClientManageOffers".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/client_manage_offer.fxml"));
      root = loader.load();
      ClientManageOffersView view = loader.getController();
      view.init(this, mvViewModel.getManageOffersViewModel());
      localStage.setTitle("ManageOffers");
    }
    else if("HandymanFindWork".equals(viewToOpen))
    {
      loader.setLocation(getClass().getResource("/resources/handyman_find_work_result.fxml"));
      root = loader.load();
      HandymanFindWorkView view = loader.getController();
      view.init(this, mvViewModel.getHandymanFindWorkViewModel());
      localStage.setTitle("FindWork");
    }
    else if("HandymanJobRecommendation".equals(viewToOpen)){
      loader.setLocation(getClass().getResource("/resources/handyman_job_recomandation.fxml"));
      root = loader.load();
      HandymanJobRecomandationView view = loader.getController();
      view.init(this, mvViewModel.getHandymanJobRecomandationViewModel());
      localStage.setTitle("FindWork");
    }
    //you can only show one main.client.view per stage
    scene = new Scene(root);
    localStage.setScene(scene);
    localStage.show();
  }
}
