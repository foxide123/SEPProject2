package main.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Skills implements Serializable
{
  private boolean plumber;
  private boolean electrician;
  private boolean mason;
  private boolean groundWorker;

  public Skills(boolean plumber, boolean electrician, boolean mason, boolean groundWorker){
    this.plumber = plumber;
    this.electrician = electrician;
    this.mason = mason;
    this.groundWorker = groundWorker;
  }

  public void setSkills(ArrayList<String> skills){
    for(int i=0; i<skills.size();i++){
      if(skills.get(i).equals("plumber")){
        plumber = true;
      }
      if(skills.get(i).equals("electrician")){
        electrician = true;
      }
      if(skills.get(i).equals("mason")){
        mason = true;
      }
      if(skills.get(i).equals("groundworker")){
        groundWorker = true;
      }
    }
  }

  public ArrayList<String> getSkills(){
    ArrayList<String> tmpList = new ArrayList<>();
    if(plumber==true){
      tmpList.add("plumber");
    }
    if(electrician==true){
      tmpList.add("electrician");
    }
    if(mason==true){
      tmpList.add("mason");
    }
    if(groundWorker==true){
      tmpList.add("groundworker");
    }
    return tmpList;
  }

}
