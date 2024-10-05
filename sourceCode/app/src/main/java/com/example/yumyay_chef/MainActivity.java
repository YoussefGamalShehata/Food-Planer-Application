package com.example.yumyay_chef;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Animation myAnimation;
    TextView applicationName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        myAnimation= AnimationUtils.loadAnimation(this,R.anim.startanimation);
        applicationName=findViewById(R.id.textView3);
        applicationName.startAnimation(myAnimation);
        applicationName.postOnAnimationDelayed(new Runnable() {
            @Override
            public void run() {
                Intent outIntent = new Intent(MainActivity.this, AppNavigationActivity.class);
                startActivity(outIntent);
                finish();
            }
        },3000);

    }
}