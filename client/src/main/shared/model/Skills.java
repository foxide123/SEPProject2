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

  public boolean getPlumberBoolean(){
    return plumber;
  }
  public void setPlumber(boolean value){this.plumber = value;}

  public boolean getElectricianBoolean(){
    return electrician;
  }
  public void setElectrician(boolean value){this.electrician = value;}

  public boolean getMasonBoolean(){
    return mason;
  }
  public void setMason(boolean value){this.mason = value;}

  public boolean getGroundWorkerBoolean(){return groundWorker;}
  public void setGroundWorker(boolean value){this.groundWorker = value;}

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

  public boolean equalsAtLeastOne(ArrayList<String> skillsFromDatabase)
  {
    for(int i=0; i<skillsFromDatabase.size(); i++){
      if(skillsFromDatabase.get(i).equals("plumber")){
        plumber = true;
        return true;
      }
      if(skillsFromDatabase.get(i).equals("electrician")){
        electrician = true;
        return true;
      }
      if(skillsFromDatabase.get(i).equals("groundworker")){
        groundWorker = true;
        return true;
      }
      if(skillsFromDatabase.get(i).equals("mason")){
        mason = true;
        return true;
      }
    }
    return false;
  }

}
