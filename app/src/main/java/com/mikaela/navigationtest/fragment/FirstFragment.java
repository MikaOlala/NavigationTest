package com.mikaela.navigationtest.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mikaela.navigationtest.MainActivity;
import com.mikaela.navigationtest.R;

public class FirstFragment extends Fragment {

    private static FirstFragment instance;
    private NavController nav;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        nav = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        TextView back = view.findViewById(R.id.back);
        back.setOnClickListener(v -> {
            nav.popBackStack();
        });

        Log.i("size", String.valueOf(nav.getBackQueue().getSize()));
        ((MainActivity)requireActivity()).logs(nav.getBackQueue());

        return view;
    }

    public FirstFragment() {
    }
}