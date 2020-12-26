package com.example.sits_313_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView console;
    Button[] buttons = new Button[3];
    TextView characterParamK, characterParamA, characterParamR;
    
    public Character manager;
    public Story story;

    String character_param_K, character_param_A, character_param_R;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        console = findViewById(R.id.console);
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        characterParamK = findViewById(R.id.character_param_K);
        characterParamA = findViewById(R.id.character_param_A);
        characterParamR = findViewById(R.id.character_param_R);

        character_param_K = getResources().getString(R.string.character_param_K);
        character_param_A = getResources().getString(R.string.character_param_A);
        character_param_R = getResources().getString(R.string.character_param_R);

        for (Button btn: buttons) {
            btn.setOnClickListener(this);
        }

        game();
    }

    private void game() {
//        console.setText("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n"
//                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
//        initialize character and story
        manager = new Character("player", this);
        story = new Story(this);

//        print character's parameters
        manager.printParams(character_param_K, character_param_A, character_param_R);

//        print current (start) situation subject and text
        console.setText(story.current_situation.text);
    }

    @Override
    public void onClick(View v) {
        int go_num = 0;
        switch (v.getId()) {
            case R.id.button1:
                go_num = 1;
                break;
            case R.id.button2:
                go_num = 2;
                break;
            case R.id.button3:
                go_num = 3;
                break;
        }
        story.go(go_num);
        for (int i = 0; i < 3; i++) {
            if (i < story.current_situation.variantsTexts.length) {
                buttons[i].setVisibility(View.VISIBLE);
                buttons[i].setText(story.current_situation.variantsTexts[i]);
            } else {
                buttons[i].setVisibility(View.INVISIBLE);
            }
        }
        manager.A += story.current_situation.dA;
        manager.K += story.current_situation.dK;
        manager.R += story.current_situation.dR;
        manager.printParams(character_param_K, character_param_A, character_param_R);
        console.setText(story.current_situation.text);
        if (story.isEnd()) {
            console.append("\n\nСыграем ещё раз?");
            manager.resetManager();
            story.resetStory();
            buttons[0].setVisibility(View.VISIBLE);
        }
    }
}