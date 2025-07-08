package com.example.pawtner.ui.mypets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pawtner.databinding.FragmentMypetsBinding;

public class MyPetsFragment extends Fragment {

    private FragmentMypetsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMypetsBinding.inflate(inflater, container, false);
        binding.textMypets.setText("Ini halaman My Pets");
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
