package com.amani.javaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class Main2Activity extends AppCompatActivity {
    EditText etSecond;
    Button buttonTwo;

    //its observable or publisher
    MyEventInterface myEventInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        etSecond = findViewById(R.id.editText2);

        buttonTwo = findViewById(R.id.buttonPublisher);
        buttonTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myEventInterface = new MyEventInterface();
                myEventInterface.setMsg(etSecond.getText().toString());
                EventBus.getDefault().post(myEventInterface);
                finish();
            }
        });


    }
}
