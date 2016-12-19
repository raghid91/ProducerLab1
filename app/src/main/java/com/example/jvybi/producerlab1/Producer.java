package com.example.jvybi.producerlab1;

/**
 * Created by jvybi on 11/7/2016.
 */

import android.os.Handler;
import android.widget.TextView;

import java.lang.Thread;

public class Producer implements Runnable {
    Handler handle;

    Producer(Handler m) {handle = m;}

    @Override
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                //System.out.println("("+i+") "+msg);
                //aTextView.setText(aTextView.getText()+ msg + "\n");
                handle.sendEmptyMessage(0);
                Thread.sleep(100);
            }
        } catch(InterruptedException e) {        }
    }
}
