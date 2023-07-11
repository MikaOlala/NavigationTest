package com.mikaela.navigationtest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public class ButtonsAdapter extends BaseAdapter {

    private Map<String, Integer> buttons;
    private Context context;

    public ButtonsAdapter(Context context, Map<String, Integer> buttons) {
        this.context = context;
        this.buttons = buttons;
    }

    @Override
    public int getCount() {
        return buttons.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView==null)
            button = new Button(context);
        else
            button = (Button) convertView;

        button.setText((String) buttons.keySet().toArray()[position]);
        return button;
    }
}
