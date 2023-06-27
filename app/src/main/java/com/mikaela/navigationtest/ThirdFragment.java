package com.mikaela.navigationtest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        NavController nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> nav.navigate(R.id.action_thirdFragment_to_firstFragment));

        Button back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            nav.popBackStack();
        });

        Log.i("size", String.valueOf(nav.getBackQueue().getSize()));
        ((MainActivity)requireActivity()).logs(nav.getBackQueue());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}