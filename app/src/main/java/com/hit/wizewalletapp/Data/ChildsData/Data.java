package com.hit.wizewalletapp.Data.ChildsData;

import com.hit.wizewalletapp.R;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<childs> getMembersList() {
        List<childs> MembersList = new ArrayList<>();

        childs Dan= new childs();
        Dan.setName("Dan");
        Dan.setBank("Bank - 1234");
        Dan.setImage(R.drawable.imageprofile);
        MembersList.add(Dan);

        childs Michael = new childs();
        Michael.setName("Michael");
        Michael.setBank("Bank - 1234");
        Michael.setImage(R.drawable.imageprofile);
        MembersList.add(Michael);

        childs Yarden = new childs();
        Yarden.setName("Yarden");
        Yarden.setBank("Bank - 1234");
        Yarden.setImage(R.drawable.imageprofile);
        MembersList.add(Yarden);

        childs Ben = new childs();
        Ben.setName("Ben");
        Ben.setBank("Bank - 1234");
        Ben.setImage(R.drawable.imageprofile);
        MembersList.add(Ben);

        childs Alon = new childs();
        Alon.setName("Alon");
        Alon.setBank("Bank - 1234");
        Alon.setImage(R.drawable.imageprofile);
        MembersList.add(Alon);

        childs Maor = new childs();
        Maor.setName("Maor");
        Maor.setBank("Bank - 1234");
        Maor.setImage(R.drawable.imageprofile);
        MembersList.add(Maor);


        return MembersList;
    }

}
