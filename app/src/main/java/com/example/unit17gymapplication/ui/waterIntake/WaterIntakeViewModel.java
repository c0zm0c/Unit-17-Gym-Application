package com.example.unit17gymapplication.ui.waterIntake;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WaterIntakeViewModel extends ViewModel {

    private final MutableLiveData<Integer> totalIntake = new MutableLiveData<>(0);

    public LiveData<Integer> getTotalIntake() {
        return totalIntake;
    }

    public void increment() {
        Integer current = totalIntake.getValue();
        if (current == null) current = 0;
        totalIntake.setValue(current + 100);

    }

    public void decrement() {
        Integer current = totalIntake.getValue();
        if (current == null) current = 0;
        totalIntake.setValue(current - 100);

    }

    public void reset() {
        totalIntake.setValue(0);
    }
}