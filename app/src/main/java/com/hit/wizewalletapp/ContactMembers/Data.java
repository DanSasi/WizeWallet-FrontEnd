package com.hit.wizewalletapp.ContactMembers;

import com.hit.wizewalletapp.R;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<members> getMembersList() {
        List<members> MembersList = new ArrayList<>();

        members Dan= new members ();
        Dan.setName("Dan");
        Dan.setBank("Bank - 1234");
        Dan.setImage(R.drawable.imageprofile);
        MembersList.add(Dan);

        members  Michael = new members ();
        Michael.setName("Michael");
        Michael.setBank("Bank - 1234");
        Michael.setImage(R.drawable.imageprofile);
        MembersList.add(Michael);

        members  Yarden = new members ();
        Yarden.setName("Yarden");
        Yarden.setBank("Bank - 1234");
        Yarden.setImage(R.drawable.imageprofile);
        MembersList.add(Yarden);

        members  Ben = new members ();
        Ben.setName("Ben");
        Ben.setBank("Bank - 1234");
        Ben.setImage(R.drawable.imageprofile);
        MembersList.add(Ben);

        members  Alon = new members ();
        Alon.setName("Alon");
        Alon.setBank("Bank - 1234");
        Alon.setImage(R.drawable.imageprofile);
        MembersList.add(Alon);

        members  Maor = new members ();
        Maor.setName("Maor");
        Maor.setBank("Bank - 1234");
        Maor.setImage(R.drawable.imageprofile);
        MembersList.add(Maor);


        return MembersList;
    }

}
