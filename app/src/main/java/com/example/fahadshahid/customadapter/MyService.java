package com.example.fahadshahid.customadapter;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = "MyService";
    private boolean isRunning  = false;
    private Looper looper;
    private MyServiceHandler myServiceHandler;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

        return null;
    }

    @Override
    public void onCreate() {
        HandlerThread handlerthread = new HandlerThread("MyThread");
        handlerthread.start();
        looper = handlerthread.getLooper();
        myServiceHandler = new MyServiceHandler(looper);
        isRunning = true;
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Message msg = myServiceHandler.obtainMessage();
        msg.arg1 = startId;
        myServiceHandler.sendMessage(msg);
        Toast.makeText(this, "MyService Started.", Toast.LENGTH_SHORT).show();
        //If service is killed while starting, it restarts.
        return START_STICKY;

        /*Thread t = new Thread(){
            @Override
            public void run(){
                for (int i=0; i<20; i++){
                    try {
                        sleep(1000);
                        Log.d("MTAG", "onCreate: Service is started");
                        Toast.makeText(MyService.this, "Service is Started", Toast.LENGTH_SHORT).show();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();*/



        //return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        isRunning = false;
        Toast.makeText(this, "MyService Completed or Stopped.", Toast.LENGTH_SHORT).show();
        /*Toast.makeText(this, "Service is Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();*/
    }
    private final class MyServiceHandler extends Handler {
        public MyServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    try {
                        Log.i(TAG, "MyService running...");
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        Log.i(TAG, e.getMessage());
                    }
                    if(!isRunning){
                        break;
                    }
                }
            }
            //stops the service for the start id.
            stopSelfResult(msg.arg1);
        }
    }
}
