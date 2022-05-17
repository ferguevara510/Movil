package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.content.Context;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensormanager;
    private Sensor sensoracelerometro;
    TextView texto;
    View v;
    Timer lastTouchedTimer;
    MediaPlayer mMediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    texto = (TextView) findViewById(R.id.texto);
    v = (View) findViewById(R.id.layout);

    sensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);
    sensoracelerometro = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    List<Sensor> listasensores = sensormanager.getSensorList(Sensor.TYPE_ALL);
        for (int i=1; i < listasensores.size();i++){
            Log.d("Lista de sensores es:",listasensores.get(i).getName());
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x,y,z;
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];
        texto.setText("X= "+ x +" Y = "+ y+ " Z = "+ z);
        if(x > 6){
            v.setBackgroundColor(Color.RED);
            if (lastTouchedTimer == null) {
                lastTouchedTimer = new Timer();
                lastTouchedTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            AssetFileDescriptor afd = getAssets().openFd("Hola.mp3");
                            mMediaplayer = new MediaPlayer();
                            mMediaplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                            afd.close();
                            mMediaplayer.prepare();
                            mMediaplayer.setVolume(1f, 1f);
                            mMediaplayer.setLooping(false);
                            mMediaplayer.start();
                            mMediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    mMediaplayer.setLooping(true);
                                    mMediaplayer.stop();
                                    mMediaplayer.release();
                                    lastTouchedTimer =null;
                                }
                            });

                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 2);
            }
        }else{
            if (x < -6){
                v.setBackgroundColor(Color.BLUE);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensormanager.registerListener(this, sensoracelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensormanager.unregisterListener(this);
    }
}