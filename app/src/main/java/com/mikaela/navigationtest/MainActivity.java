package com.mikaela.navigationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayDeque;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navCo = navHostFragment.getNavController();
    }

    public void logs(kotlin.collections.ArrayDeque<NavBackStackEntry> backQueue) {
        int index = 0;
        for (NavBackStackEntry n : backQueue) {
            Log.i("element " + index, String.valueOf(n.getDestination().getLabel()));
            index++;
        }
    }
}