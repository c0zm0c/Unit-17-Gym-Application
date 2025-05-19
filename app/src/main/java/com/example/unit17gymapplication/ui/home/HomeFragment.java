package com.example.unit17gymapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.unit17gymapplication.databinding.FragmentHomeBinding;
import com.example.unit17gymapplication.ui.waterIntake.WaterIntakeViewModel;
import com.example.unit17gymapplication.ui.workout.WorkoutViewModel;
import com.example.unit17gymapplication.ui.timer.TimerViewModel;
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private WaterIntakeViewModel viewModel;

    private WorkoutViewModel workoutViewModel;
    private TimerViewModel timerViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel =
                new ViewModelProvider(requireActivity()).get(WaterIntakeViewModel.class);
        WaterIntakeViewModel viewModel =
                new ViewModelProvider(requireActivity()).get(WaterIntakeViewModel.class);
        workoutViewModel =
                new ViewModelProvider(requireActivity()).get(WorkoutViewModel.class);
        timerViewModel =
                new ViewModelProvider(requireActivity()).get(TimerViewModel.class);
        viewModel.getTotalIntake().observe(getViewLifecycleOwner(), count ->
                binding.textTotalWater.setText("Total Water Intake: " + count));

        workoutViewModel.getCount().observe(getViewLifecycleOwner(), count ->
                binding.textWorkoutCount.setText("Workout Count: " + count));

        timerViewModel.getTime().observe(getViewLifecycleOwner(), time ->
                binding.textTimer.setText("Timer: " + time));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}