package com.saad.profilemcq;


import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    RadioGroup radioMcq;
    RadioButton radioButton;
    EditText mcq1, mcq2, ratingText;
    RatingBar ratingBar;
    CheckBox ch1, ch2, ch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radioMcq = findViewById(R.id.radioMcq);
        mcq1 = findViewById(R.id.mcq1);
        mcq2 = findViewById(R.id.mcq2);
        ratingText = findViewById(R.id.et);
        ratingBar = findViewById(R.id.ratingBar);
        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);

        ObjectAnimator slideUp = ObjectAnimator.ofFloat(findViewById(R.id.anim), "translationY", 1000f, 0f);
        slideUp.setDuration(1000);
        slideUp.start();

        findViewById(R.id.prev).setOnClickListener(v->{
            Intent i = new Intent(getApplicationContext(), HomePage.class);
            startActivity(i);
        });
        findViewById(R.id.next).setOnClickListener(v->{
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(i);
        });
        findViewById(R.id.button).setOnClickListener(v->{
            int selectedId = radioMcq.getCheckedRadioButtonId();
            radioButton = findViewById(selectedId);

            if (selectedId == R.id.radio2) {
                mcq1.setText("Right Answer");
            } else {
                mcq1.setText("Wrong Answer");
            }

            if(ch1.isChecked() && ch2.isChecked() && ch3.isChecked()){
                mcq2.setText("Right Answer");
            } else {
                mcq2.setText("Wrong Answer");
            }
        });
        ratingBar.setOnRatingBarChangeListener((RatingBar ratingBar, float rating, boolean fromUser) -> {
            ratingText.setText(String.valueOf(rating));
        });
    }
    public void animateEditText1() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mcq1, "translationX", -30f, 30f, -20f, 20f, 0f);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }
    public void animateEditText2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mcq2, "translationX", -30f, 30f, -20f, 20f, 0f);
        animator.setDuration(4000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }
}