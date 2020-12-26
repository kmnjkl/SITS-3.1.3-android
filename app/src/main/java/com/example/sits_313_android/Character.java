package com.example.sits_313_android;

import android.content.Context;

public class Character {
    public int K;
    public int A;
    public int R;
    public String name;

    MainActivity activity;

    public Character(String name, MainActivity activity) {
        this.activity = activity;
        K = 1;
        A = 100;
        R = 50;
        this.name = name;
    }

    public void printParams(String character_param_K, String character_param_A, String character_param_R) {
        activity.characterParamK.setText(character_param_K + "\n" + K);
        activity.characterParamA.setText(character_param_A + "\n" + A);
        activity.characterParamR.setText(character_param_R + "\n" + R);
    }

    public void resetManager() {
        K = 1;
        A = 100;
        R = 50;
    }
}
