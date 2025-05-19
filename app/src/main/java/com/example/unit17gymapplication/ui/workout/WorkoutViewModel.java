package com.example.unit17gymapplication.ui.workout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WorkoutViewModel extends ViewModel {

    private final MutableLiveData<Integer> count = new MutableLiveData<>(0);

    public LiveData<Integer> getCount() {
        return count;
    }

    public void increment() {
        count.setValue(count.getValue() + 1);
    }

    public void decrement() {
        count.setValue(count.getValue() - 1);
    }

    public Object reset() {
        count.setValue(0);
        return null;

    }
}