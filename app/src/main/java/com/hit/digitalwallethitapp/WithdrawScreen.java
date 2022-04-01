package com.hit.digitalwallethitapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.RadioButton;


public class WithdrawScreen extends AppCompatActivity {

    ImageView backArrow;
    RadioGroup2 radioGroup = new RadioGroup2();
    RadioButton[] radioButtons = new RadioButton[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_screen);

        backArrow = findViewById(R.id.img_arrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WithdrawScreen.this,MenuScreen.class);
                startActivity(intent);
            }
        });

        radioButtons[0] = (RadioButton) findViewById(R.id.radioButton_personalAcc);
        radioButtons[1] = (RadioButton) findViewById(R.id.radioButton_businessAcc);
        radioButtons[2] = (RadioButton) findViewById(R.id.radioButton_familyAcc);

        radioGroup.createRadioGroup(radioButtons);

    }

    class RadioGroup2 {

        private RadioButton rb [];
        private int firstCheckedItemId;
        public int countRadioButtons;

        public void createRadioGroup(RadioButton [] radioButtons){
            rb = radioButtons;
            firstCheckedItemId = getCheckedItemId();
            countRadioButtons = rb.length;
            onCheck();
        }

        private void onCheck(){
            for (RadioButton aRb : rb) {
                aRb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View radio) {
                        final RadioButton myRb = (RadioButton) radio;
                        for (RadioButton aRb : rb) {
                            if (aRb.getId() == myRb.getId()) {
                                aRb.setChecked(true);
                            } else aRb.setChecked(false);
                        }
                    }
                });
            }
        }

        public int getRadioButtonsCount(){
            return countRadioButtons;
        }

        public int getCheckedItemId (){
            int id = -1;
            for (RadioButton aRb : rb) {
                if(aRb.isChecked())
                    id = aRb.getId();
            }
            return id;
        }

        public RadioButton getCheckedItem (){
            RadioButton RB = null;
            for (RadioButton aRb : rb) {
                if(aRb.isChecked())
                    RB = aRb;
            }
            return RB;
        }

        public void resetButtons(){
            RadioButton iRb = getCheckedItem();
            if(iRb != null)
                iRb.setChecked(false);
            if(firstCheckedItemId != -1)
                getChildById(firstCheckedItemId).setChecked(true);
        }



        private RadioButton getChildById(int id){
            RadioButton iRb = null;
            for (RadioButton aRb : rb ) {
                if(aRb.getId() == id) {
                    iRb = aRb;
                    break;
                }
            }
            return iRb;
        }


        public RadioButton getChildAt (int position){
            return rb[position];
        }
    }
}