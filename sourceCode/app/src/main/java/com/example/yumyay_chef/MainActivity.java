package com.example.yumyay_chef;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Animation myAnimation;
    TextView applicationName;
    private SeekBar seekBar; // Use class variable for SeekBar
    private TextView textViewValue; // Use class variable for TextView
    private boolean animstatus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view first
        setContentView(R.layout.activity_main);

        // Initialize EdgeToEdge and views
        EdgeToEdge.enable(this);
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.startanimation);
        applicationName = findViewById(R.id.textView3);

        if (animstatus) {
            applicationName.startAnimation(myAnimation);
            animstatus = false;
        }

        // Initialize the SeekBar and TextView
        seekBar = findViewById(R.id.slider); // Use class variable for SeekBar
        textViewValue = findViewById(R.id.textViewValue); // Initialize textViewValue

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Set a constant background color for the SeekBar
                //changeSliderBackground(); // Call the updated method

                // Check if the slider has reached its maximum value
                if (progress == seekBar.getMax()) {
                    // Start the next activity
                    Intent outIntent = new Intent(MainActivity.this, AppNavigationActivity.class);
                    startActivity(outIntent);
                    finish();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Handle when the user starts dragging the slider
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Check if the slider has reached its maximum value
            }
        });
    }

    private void changeSliderBackground() {
        // Set a constant color for the SeekBar background
        int constantColor = Color.parseColor("#55AD9B"); // Example: Orange color
        seekBar.setBackgroundColor(constantColor); // Set the background color
    }
}
