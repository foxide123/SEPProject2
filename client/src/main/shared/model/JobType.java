package main.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

public class JobType implements Serializable
{
    private boolean plumbing;
    private boolean electrical;
    private boolean masonry;
    private boolean groundWorking;

    private static final long serialVersionUID = 5626982982634456134L;

    public JobType(boolean plumbing, boolean electrical, boolean masonry, boolean groundWorking){
        setValues(plumbing,electrical,masonry,groundWorking);
    }

    public boolean getPlumbing(){return plumbing;}
    public boolean getElectrical(){return electrical;}
    public boolean getMasonry(){return masonry;}
    public boolean getGroundworking(){return groundWorking;}

    public ArrayList<String> getJobTypes(){
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

/*
    public static boolean containsAny(ArrayList<String> firstList, ArrayList<String> secondList){
        if(firstList.size() < secondList.size()){
            for(int i=0; i<firstList.size(); i++){
                System.out.println(firstList.get(i));
                if(secondList.contains(firstList.get(i))){
                    return true;
                }
            }
        }else{
            for(int i=0; i<secondList.size(); i++){
                System.out.println(secondList.get(i));
                if(firstList.contains(secondList.get(i))){
                    return true;
                }
            }
        }
        return false;
    }

 */
    public static boolean containsAny(ArrayList<String> firstList, ArrayList<String> secondList){
        if(firstList.size() < secondList.size()){
            for(Object aFirstList : secondList){
                if(secondList.contains(aFirstList)){
                    return true;
                }
            }
        }else{
            for(Object aSecondList: secondList){
                if(firstList.contains(aSecondList)){
                    return true;
                }
            }
        }
        return false;
    }


/*
    public static boolean containsAny(final Collection<?> coll1, final Collection<?> coll2) {
            if (coll1.size() < coll2.size()) {
                    for (final Object aColl1 : coll1) {
                           if (coll2.contains(aColl1)) {
                                return true;
                               }
                       }
            } else {
                    for (final Object aColl2 : coll2) {
                              if (coll1.contains(aColl2)) {
                                     return true;
                                 }
                        }
               }
            return false;
        }


 */
    public void setValues(boolean plumbing, boolean electrical, boolean masonry, boolean groundWorking){
        this.plumbing = plumbing;
        this.electrical = electrical;
        this.masonry = masonry;
        this.groundWorking = groundWorking;
    }

    public void setValuesFromList(ArrayList<String> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("plumbing")){
                plumbing=true;
            }
            if(list.get(i).equals("electrician")){
                electrical=true;
            }
            if(list.get(i).equals("masonry")){
                masonry=true;
            }
            if(list.get(i).equals("groundworking")){
                groundWorking=true;
            }
        }
    }

}
