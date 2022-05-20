package main.client.viewmodel;

import main.client.model.Model;
import main.client.viewmodel.client.*;
import main.client.viewmodel.handyman.*;
import main.client.viewmodel.admin.AdminLogInViewModel;

public class ViewModelProvider
{
  private final ClientLogInViewModel clientLogInViewModel;
  private final HandymanLogInViewModel handymanLogInViewModel;
  private final AdminLogInViewModel adminLogInViewModel;
  private final LogInRegisterViewModel logInRegisterViewModel;
  private final ChooseActorLogInViewModel chooseActorLogInViewModel;
  private final ChooseActorSignUpViewModel chooseActorSignUpViewModel;
  private final HandymanSignUpViewModel handymanSignUpViewModel;
  private final ClientSignUpViewModel clientSignUpViewModel;
  private final ClientLoggedInViewModel clientLoggedInViewModel;
  private final HandymanLoggedInViewModel handymanLoggedInViewModel;
  private final ClientFindWorkerViewModel findWorkerViewModel;
  private final ClientCreateJobViewModel createJobViewModel;
  private final ClientManageOffersViewModel manageOffersViewModel;
  private final HandymanFindWorkViewModel handymanFindWorkViewModel;
  private final HandymanJobRecomandationViewModel handymanJobRecomandationViewModel;

  public ViewModelProvider(Model model) {
    this.clientLogInViewModel = new ClientLogInViewModel(model);
    this.handymanLogInViewModel = new HandymanLogInViewModel(model);
    this.adminLogInViewModel = new AdminLogInViewModel(model);

    this.logInRegisterViewModel = new LogInRegisterViewModel(model);
    this.chooseActorLogInViewModel = new ChooseActorLogInViewModel(model);
    this.chooseActorSignUpViewModel = new ChooseActorSignUpViewModel(model);

    this.handymanSignUpViewModel = new HandymanSignUpViewModel(model);
    this.clientSignUpViewModel = new ClientSignUpViewModel(model);

    this.clientLoggedInViewModel = new ClientLoggedInViewModel(model);
    this.handymanLoggedInViewModel = new HandymanLoggedInViewModel(model);

    this.findWorkerViewModel = new ClientFindWorkerViewModel(model);
    this.createJobViewModel = new ClientCreateJobViewModel(model);
    this.manageOffersViewModel = new ClientManageOffersViewModel(model);
    this.handymanFindWorkViewModel = new HandymanFindWorkViewModel(model);
    this.handymanJobRecomandationViewModel = new HandymanJobRecomandationViewModel(model);

  }

  public ClientLogInViewModel getClientLogInViewModel(){return clientLogInViewModel;}
  public HandymanLogInViewModel getHandymanLogInViewModel(){return handymanLogInViewModel;}
  public AdminLogInViewModel getAdminLogInViewModel(){return adminLogInViewModel;}

  public LogInRegisterViewModel getLogInRegisterViewModel(){return logInRegisterViewModel;}

  public ChooseActorLogInViewModel getChooseActorLogInViewModel(){return chooseActorLogInViewModel;}

  public ChooseActorSignUpViewModel getChooseActorSignUpViewModel(){return chooseActorSignUpViewModel;}

  public HandymanSignUpViewModel getHandymanSignUpViewModel(){return handymanSignUpViewModel;}

  public ClientSignUpViewModel getClientSignUpViewModel(){return clientSignUpViewModel;}

  public ClientLoggedInViewModel getClientLoggedInViewModel(){return clientLoggedInViewModel;}
  public HandymanLoggedInViewModel getHandymanLoggedInViewModel(){return handymanLoggedInViewModel;}

  public ClientFindWorkerViewModel getFindWorkerViewModel(){return findWorkerViewModel;}
  public ClientCreateJobViewModel getCreateJobViewModel(){return createJobViewModel;}
  public ClientManageOffersViewModel getManageOffersViewModel(){return manageOffersViewModel;}
  public HandymanFindWorkViewModel getHandymanFindWorkViewModel(){return handymanFindWorkViewModel;}
  public HandymanJobRecomandationViewModel getHandymanJobRecomandationViewModel(){return handymanJobRecomandationViewModel;}
}
