package com.factory.jayce.broadcastclient;

import android.speech.tts.TextToSpeech;
import android.util.Log;

import org.json.simple.parser.ParseException;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Created by Jayce on 3/20/2017.
 */

public class InputThread extends Thread {

    private static final String LOG = "log";
    MainActivity activity;
    InputStream in;
    String msg = null;
    String translated_msg = null;
    protected TextToSpeech tts;

    public InputThread(InputStream in, MainActivity activity) {
        this.in = in;
        this.activity = activity;
    }

    @Override
    public void run() {

        DataInputStream dis = new DataInputStream(in);


        while(true) {

            try {

                msg = dis.readUTF();

                if(msg != null) {

                    String received_output_lang = msg.substring(0,2);
                    switch(activity.input_lang) {
                        case "ko":
                            activity.tts.setLanguage(Locale.KOREAN);
                            break;
                        case "en":
                            activity.tts.setLanguage(Locale.ENGLISH);
                            break;
                        case "ru":
                            Locale locale = new Locale("ru");
                            activity.tts.setLanguage(locale);
                            break;
                        case "fr":
                            activity.tts.setLanguage(Locale.FRENCH);
                            break;
                    }
                    msg = msg.substring(2);

                    try {
                        translated_msg = activity.getJsonStringYandex(received_output_lang + "-" + activity.input_lang, msg.replaceAll(" ", "+"));
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                activity.speak(translated_msg);
                            }
                        }).start();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    msg = null;
                    /*activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            activity.display.append(translated_msg + "\n");
                            translated_msg = null;
                            msg = null;
                        }
                    });*/
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

            //Log.d(LOG, "SERVER said " + dis.readUTF());
        }

    }
}
