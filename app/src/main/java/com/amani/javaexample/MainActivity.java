package com.amani.javaexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    EditText etOne;
    Button btOne;
    MyEventInterface myEventInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        etOne = findViewById(R.id.editText1);
        btOne = findViewById(R.id.button);
        myEventInterface = new MyEventInterface();

        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySubscriber(myEventInterface);
            }
        });
    }


    //subscribe to event bus
    @Subscribe()
    void mySubscriber(MyEventInterface myEventInterface){
        String msg = myEventInterface.getMsg();
        if(msg != null){
            etOne.setText(msg);
        }
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
