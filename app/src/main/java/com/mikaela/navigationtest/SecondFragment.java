package com.mikaela.navigationtest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        NavController nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button next = view.findViewById(R.id.back);
        next.setOnClickListener(v -> nav.navigate(R.id.action_secondFragment_to_thirdFragment));

        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            nav.popBackStack();
        });

        Log.i("size", String.valueOf(nav.getBackQueue().getSize()));
        ((MainActivity)requireActivity()).logs(nav.getBackQueue());

        return view;
    }
}