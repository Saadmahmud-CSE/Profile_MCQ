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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    RadioGroup radioMcq;
    RadioButton radioButton;
    EditText mcq1, mcq2, ratingText;
    RatingBar ratingBar;
    CheckBox ch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ObjectAnimator slideUp = ObjectAnimator.ofFloat(findViewById(R.id.anim), "translationY", 1000f, 0f);
        slideUp.setDuration(1000);
        slideUp.start();
        radioMcq = findViewById(R.id.radioMcq);
        ratingText = findViewById(R.id.et);
        ratingBar = findViewById(R.id.ratingBar);
        mcq1 = findViewById(R.id.mcq1);
        mcq2 = findViewById(R.id.mcq2);
        ch1 = findViewById(R.id.checkBox3);
        findViewById(R.id.next).setOnClickListener(v->{
            Intent i = new Intent(getApplicationContext(), HomePage.class);
            startActivity(i);
        });
        findViewById(R.id.prev).setOnClickListener(v->{
            Intent i = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(i);
        });
        findViewById(R.id.submit).setOnClickListener(v->{
            setRadioButton1();
            checkBox();
            animateEditText1();
            animateEditText2();
        });
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            ratingText.setText(String.valueOf(rating));
            ObjectAnimator animator = ObjectAnimator.ofFloat(ratingText, "translationX", -30f, 30f, -20f, 20f, 0f);
            animator.setDuration(1000);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.start();
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
    public void setRadioButton1() {
        int selectedId = radioMcq.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == R.id.radio1) {
            mcq1.setText("Right Answer");
        } else {
            mcq1.setText("Wrong Answer");
        }
    }
    public void checkBox(){
        if(ch1.isChecked()){
            mcq2.setText("Right Answer");
        }
        else {
            mcq2.setText("Wrong Answer");
        }
    }

}