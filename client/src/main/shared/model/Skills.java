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

  public boolean getElectricianBoolean(){
    return electrician;
  }

  public boolean getMasonBoolean(){
    return mason;
  }

  public boolean getGroundWorkerBoolean(){return groundWorker;}

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

  public boolean equalsAtLeastOne(Object o) {

    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
    if (!(o instanceof Skills)) {
      return false;
    }

    // typecast o to Complex so that we can compare data members
    Skills s = (Skills) o;

    // Compare the data members and return accordingly
    return s.getElectricianBoolean()==this.getElectricianBoolean()
        || s.getGroundWorkerBoolean()==this.getGroundWorkerBoolean()
        || s.getMasonBoolean()==this.getMasonBoolean()
        || s.getPlumberBoolean() == this.getPlumberBoolean();
  }

}
