package com.example.jvybi.producerlab1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.Thread;

public class MainActivity extends AppCompatActivity {
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView) findViewById(R.id.text1);

        Runnable r1 = new Producer(threadHandler);
        Runnable r2 = new Producer(thread2Handler);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    Handler threadHandler = new Handler() {
        public void handleMessage(android.os.Message message) {
            myText.setText(myText.getText() + "hello world\n");
        }
    };

    Handler thread2Handler = new Handler() {
        public void handleMessage(android.os.Message message) {
            myText.setText(myText.getText() + "goodbye world\n");
        }
    };

}
