package com.example.unit17gymapplication.ui.workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.unit17gymapplication.databinding.FragmentWorkoutBinding;

public class WorkoutFragment extends Fragment {

    private FragmentWorkoutBinding binding;
    private WorkoutViewModel workoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        workoutViewModel =
                new ViewModelProvider(requireActivity()).get(WorkoutViewModel.class);


        workoutViewModel.getCount().observe(getViewLifecycleOwner(), count ->
                binding.textWorkoutCount.setText(String.valueOf(count))
        );

        binding.buttonIncrement.setOnClickListener(v -> workoutViewModel.increment());
        binding.buttonDecrement.setOnClickListener(v -> workoutViewModel.decrement());
        binding.buttonReset.setOnClickListener(v -> workoutViewModel.reset());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}