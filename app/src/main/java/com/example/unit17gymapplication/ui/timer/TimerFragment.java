package com.example.unit17gymapplication.ui.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.widget.Button;


import com.example.unit17gymapplication.databinding.FragmentTimerBinding;

public class TimerFragment extends Fragment {

    private FragmentTimerBinding binding;
    private TimerViewModel timerViewModel;
    private boolean isRunning = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTimerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        timerViewModel =
                new ViewModelProvider(requireActivity()).get(TimerViewModel.class);

        timerViewModel.getTime().observe(getViewLifecycleOwner(), time -> {
            binding.textTimer.setText(time);
        });

    binding.buttonStartPause.setOnClickListener(v -> {
        if (!isRunning) {
            timerViewModel.startTimer();
            isRunning = true;
            binding.buttonStartPause.setText("Pause");
        } else {
            timerViewModel.pauseTimer();
            isRunning = false;
            binding.buttonStartPause.setText("Start");
        }
    });

    binding.buttonReset.setOnClickListener(v -> {
        timerViewModel.resetTimer();
        isRunning = false;
        binding.buttonStartPause.setText("Start");

    });

    return root; }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}