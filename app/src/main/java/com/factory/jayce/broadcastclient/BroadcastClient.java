package com.factory.jayce.broadcastclient;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class BroadcastClient extends Thread{

    private static final String LOG = "log";
    private String SERVER_IP;
    MainActivity activity;

    Socket socket = null;

    public BroadcastClient(MainActivity activity, String SERVER_IP) {
        this.activity = activity;
        this.SERVER_IP = SERVER_IP;
    }

    @Override
    public void run() {
        try {

            socket = new Socket(InetAddress.getByName(SERVER_IP), 3333);
            Log.d(LOG, "### Client is running ###");

            new InputThread(socket.getInputStream(), activity).start();
            new OutputThread(socket.getOutputStream(), activity).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
