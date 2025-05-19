package com.example.unit17gymapplication.ui.waterIntake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.unit17gymapplication.databinding.FragmentWaterIntakeBinding;
import com.example.unit17gymapplication.ui.waterIntake.WaterIntakeViewModel;

public class WaterIntakeFragment extends Fragment {

    private FragmentWaterIntakeBinding binding;
    private WaterIntakeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWaterIntakeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Shared ViewModel across Activity
        viewModel = new ViewModelProvider(requireActivity()).get(WaterIntakeViewModel.class);


        // Update UI when LiveData changes
        viewModel.getTotalIntake().observe(getViewLifecycleOwner(), count ->
                binding.textWaterCount.setText(String.valueOf(count)));

        // Increment button
        binding.buttonAddWater.setOnClickListener(v -> viewModel.increment());

        // Decrement button
        binding.buttonRemoveWater.setOnClickListener(v -> viewModel.decrement());

        // Reset button
        binding.buttonResetWater.setOnClickListener(v -> viewModel.reset());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;


    }
}