package main.client;

import javafx.application.Application;
import javafx.stage.Stage;
import main.client.model.Model;
import main.client.model.ModelManager;
import main.client.view.ViewHandler;
import main.client.viewmodel.ViewModelProvider;

public class RunApplication extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    Model m = new ModelManager();
    ViewModelProvider mvvm = new ViewModelProvider(m);
    ViewHandler view = new ViewHandler(mvvm);
    view.start(stage);
  }
}
