package com.hit.wizewalletapp.Main.Parent_Folder.Models.Model;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.LinkedList;
import java.util.List;

public class BalanceParentModel {
    int photo;
    String date, topic, balance, description;

    public BalanceParentModel(int photo, String date, String topic, String balance, String description) {
        this.photo = photo;
        this.date = date;
        this.topic = topic;
        this.balance = balance;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static class ChildListModel {

        public static final ChildListModel instance = new ChildListModel();

            private ChildListModel(){
                ChildModel dan = new ChildModel(R.drawable.dan_photo,"2OO","Dan","313369423","1234");
                ChildModel michael = new ChildModel(R.drawable.michal_photo,"2OO","Michael","2","1234");
                ChildModel alon = new ChildModel(R.drawable.alon_photo,"2OO","Alon","2","1234");
                ChildModel maor = new ChildModel(R.drawable.maor_photo,"2OO","Maor","3","1234");
                ChildModel ben = new ChildModel(R.drawable.ben_photo,"2OO","Ben","4","1234");
                ChildModel yarden =new ChildModel(R.drawable.yarden_photo,"2OO","Yarden","209329416","1234");
                childModelsData.add(dan);
                childModelsData.add(michael);
                childModelsData.add(alon);
                childModelsData.add(maor);
                childModelsData.add(ben);
                childModelsData.add(yarden);

            }

            List<ChildModel> childModelsData = new LinkedList<ChildModel>();

            public List<ChildModel> getAllData(){
                return childModelsData;
            }



            public ChildModel getChildById(String childId) {
                for (ChildModel s: childModelsData) {
                    if (s.getId().equals(childId)){
                        return s;
                    }
                }
                return null;
            }

            public void addChild(ChildModel childModel) {
                childModelsData.add(childModel);
            }


        }
}
