package com.mikaela.navigationtest;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class FirstFragment extends Fragment {

    private static FirstFragment instance;
    private NavController nav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> nav.navigate(R.id.action_firstFragment_to_secondFragment));

        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            nav.popBackStack();
        });

        Log.i("size", String.valueOf(nav.getBackQueue().getSize()));
        ((MainActivity)requireActivity()).logs(nav.getBackQueue());

        return view;
    }

    public FirstFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
        nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
    }
}