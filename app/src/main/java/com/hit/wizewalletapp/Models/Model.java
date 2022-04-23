package com.hit.wizewalletapp.Models;

import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model {
    public static final Model instance = new Model();

    private Model(){
        ChildModel dan = new ChildModel(R.drawable.dan_photo,"2OO","Dan","0","1234");
        ChildModel michael = new ChildModel(R.drawable.michal_photo,"2OO","Michael","1","1234");
        ChildModel alon = new ChildModel(R.drawable.alon_photo,"2OO","Alon","2","1234");
        ChildModel maor = new ChildModel(R.drawable.maor_photo,"2OO","Maor","3","1234");
        ChildModel ben = new ChildModel(R.drawable.ben_photo,"2OO","Ben","4","1234");
        ChildModel yarden =new ChildModel(R.drawable.yarden_photo,"2OO","Yarden","5","1234");
        childModelsData.add(dan);
        childModelsData.add(michael);
        childModelsData.add(alon);
        childModelsData.add(maor);
        childModelsData.add(ben);
        childModelsData.add(yarden);
        for(int i=6;i<8;i++){
            ChildModel s = new ChildModel(R.drawable.dan_photo,"2OO","Dan",""+i,"1234");
            childModelsData.add(s);
        }
    }

    List<ChildModel> childModelsData = new LinkedList<ChildModel>();

    public List<ChildModel> getAllData(){
        return childModelsData;
    }

    public void addChild(ChildModel childModel){
        childModelsData.add(childModel);
    }

    public ChildModel getChildById(String childId) {
        for (ChildModel s: childModelsData
        ) {
            if (s.getId().equals(childId)){
                return s;
            }
        }
        return null;
    }


}
