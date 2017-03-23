package com.factory.jayce.broadcastclient;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jayce on 3/20/2017.
 */

public class OutputThread extends Thread {

    private static final String LOG = "log";
    OutputStream out;
    MainActivity activity;

    public OutputThread(OutputStream out, MainActivity activity) {
        this.out = out;
        this.activity = activity;
    }

    @Override
    public void run() {

        DataOutputStream dos = new DataOutputStream(out);

        while(true) {
            if (activity.voice_message != null){
                try {
                    dos.writeUTF(activity.output_lang + activity.voice_message);
                    dos.flush();
                    activity.voice_message = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
