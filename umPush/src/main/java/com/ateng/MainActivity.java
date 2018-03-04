package com.ateng;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.umeng.message.IUmengCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        PushAgent pushAgent=PushAgent.getInstance(this);
        pushAgent.enable(new IUmengCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "sssss", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });//开启推送
        pushAgent.onAppStart();
        UmengMessageHandler u = new UmengMessageHandler(){
            @Override
            public void dealWithCustomMessage(Context context, UMessage uMessage) {
//                super.dealWithCustomMessage(context, uMessage);
                Toast.makeText(MainActivity.this, ""+uMessage.custom, Toast.LENGTH_SHORT).show();
            }
        };
        pushAgent.setMessageHandler(u);
    }
}
