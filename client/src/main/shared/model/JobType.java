package main.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class JobType implements Serializable
{
    private boolean plumbing;
    private boolean electrical;
    private boolean masonry;
    private boolean groundWorking;

    public JobType(boolean plumbing, boolean electrical, boolean masonry, boolean groundWorking){
        setValues(plumbing,electrical,masonry,groundWorking);
    }

    public ArrayList<String> getJobType(){
        ArrayList<String> tmpList = new ArrayList<>();
        if(plumbing==true){
            tmpList.add("plumbing");
        }
        if(electrical==true){
            tmpList.add("electrical");
        }
        if(masonry==true){
            tmpList.add("masonry");
        }
        if(groundWorking==true){
            tmpList.add("groundworking");
        }
        return tmpList;
    }

    public void setValues(boolean plumbing, boolean electrical, boolean masonry, boolean groundWorking){
        this.plumbing = plumbing;
        this.electrical = electrical;
        this.masonry = masonry;
        this.groundWorking = groundWorking;}

}
