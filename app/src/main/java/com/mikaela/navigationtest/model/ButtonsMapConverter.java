package com.mikaela.navigationtest.model;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonsMapConverter {
    @TypeConverter
    public Map<String, Integer> restoreFromString(String string) {
        int delimiter = string.indexOf("&");
        String keys = string.substring(0, delimiter);
        String values = string.substring(delimiter+1);
        Map<String, Integer> buttons = new HashMap<>();
        List<String> keyList = Arrays.asList(keys.split("\\s*,\\s*"));
        List<String> valueList = Arrays.asList(values.split("\\s*,\\s*"));

        for (int i = 0; i < keyList.size(); i++) {
            buttons.put(keyList.get(i), Integer.valueOf(valueList.get(i)));
        }
        return buttons;
    }

    @TypeConverter
    public String setToString(Map<String, Integer> buttons) {
        String string = "";
        if (buttons==null || buttons.isEmpty())
            return string;

        for (String q : buttons.keySet()) {
            string += q + ",";
        }
        string += "&";
        for (int q : buttons.values()) {
            string += q + ",";
        }

        return string;
    }
}
