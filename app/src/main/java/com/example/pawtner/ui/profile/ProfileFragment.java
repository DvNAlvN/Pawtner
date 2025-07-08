package com.example.pawtner.ui.profile;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pawtner.R;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Konstruktor kosong diperlukan
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout fragment_profile
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
