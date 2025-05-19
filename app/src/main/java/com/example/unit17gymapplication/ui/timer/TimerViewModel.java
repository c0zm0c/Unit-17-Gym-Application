package com.example.unit17gymapplication.ui.timer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {

    private final MutableLiveData<String> time = new MutableLiveData<>("00:00");
    private Timer timer;
    private int seconds = 0;
    private boolean running = false;


    public MutableLiveData<String> getTime(){
        return time;
    }
    public void startTimer() {
        if (running) return;
        running = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                    int minutes = seconds / 60;
                    int secs = seconds % 60;
                    String formattedTime = String.format("%02d:%02d", minutes, secs);
                    time.postValue(formattedTime);
                }
            }
        }, 0, 1000);
    }
    public void pauseTimer() {
        running = false;
        timer.cancel();
    }
    public void resetTimer() {
        running = false;
        timer.cancel();
        seconds = 0;
        time.postValue("00:00");
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (timer !=null) {
            timer.cancel();
        }
    }


}