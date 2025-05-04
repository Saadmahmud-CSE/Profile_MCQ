package com.saad.profilemcq;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_no_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ObjectAnimator slideUp = ObjectAnimator.ofFloat(findViewById(R.id.anim), "translationY", 1000f, 0f);
        slideUp.setDuration(1000);
        slideUp.start();
        findViewById(R.id.prev).setOnClickListener(v->{
            Intent i = new Intent(getApplicationContext(), HomePage.class);
            startActivity(i);
        });
    }
}