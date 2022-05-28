package main.client.viewmodel;

import main.client.model.Model;
import main.client.viewmodel.admin.AdminLogInViewModel;
import main.client.viewmodel.admin.AdminMainViewModel;
import main.client.viewmodel.client.*;
import main.client.viewmodel.handyman.*;

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
  private final ClientFindHandymanViewModel findHandymanViewModel;
  private final ClientFindHandymanResultViewModel findHandymanResultViewModel;
  private final ClientCreateJobViewModel createJobViewModel;
  private final ClientManageOffersViewModel manageOffersViewModel;
  private final HandymanFindWorkViewModel handymanFindWorkViewModel;
  private final HandymanFindWorkResultViewModel handymanFindWorkResultViewModel;
  private final HandymanSelectedOfferViewModel handymanSelectedWorkViewModel;
  private final ClientSelectedOfferViewModel clientSelectedOfferViewModel;

  private final HandymanJobRecomandationViewModel handymanJobRecomandationViewModel;
  private final HandymanManageJobOffersViewModel handymanManageJobOffersViewModel;
  private final AdminMainViewModel adminMainViewModel;

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

    this.findHandymanViewModel = new ClientFindHandymanViewModel(model);
    this.findHandymanResultViewModel = new ClientFindHandymanResultViewModel(model);
    this.createJobViewModel = new ClientCreateJobViewModel(model);
    this.manageOffersViewModel = new ClientManageOffersViewModel(model);
    this.handymanFindWorkViewModel = new HandymanFindWorkViewModel(model);
    this.handymanFindWorkResultViewModel = new HandymanFindWorkResultViewModel(model);
    this.handymanSelectedWorkViewModel = new HandymanSelectedOfferViewModel(model);
    this.clientSelectedOfferViewModel = new ClientSelectedOfferViewModel(model);

    this.handymanJobRecomandationViewModel = new HandymanJobRecomandationViewModel(model);
    this.handymanManageJobOffersViewModel = new HandymanManageJobOffersViewModel(model);

    this.adminMainViewModel = new AdminMainViewModel(model);
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

  public ClientFindHandymanViewModel getFindHandymanViewModel(){return findHandymanViewModel;}
  public ClientFindHandymanResultViewModel getFindHandymanResultViewModel(){return findHandymanResultViewModel;}
  public ClientCreateJobViewModel getCreateJobViewModel(){return createJobViewModel;}
  public ClientManageOffersViewModel getManageOffersViewModel(){return manageOffersViewModel;}
  public HandymanFindWorkViewModel getFindWorkViewModel(){return handymanFindWorkViewModel;}
  public HandymanFindWorkResultViewModel getFindWorkResultViewModel(){return handymanFindWorkResultViewModel;}
  public HandymanJobRecomandationViewModel getHandymanJobRecomandationViewModel(){return handymanJobRecomandationViewModel;}
  public HandymanManageJobOffersViewModel getHandymanManageJobOffersViewModel(){return handymanManageJobOffersViewModel;}
  public HandymanSelectedOfferViewModel getHandymanSelectedWorkViewModel(){return handymanSelectedWorkViewModel;}
  public ClientSelectedOfferViewModel getClientSelectedOfferViewModel(){return clientSelectedOfferViewModel;}

  public AdminMainViewModel getAdminMainViewModel(){return adminMainViewModel;}
}
