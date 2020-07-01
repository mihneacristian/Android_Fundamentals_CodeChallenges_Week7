package com.mihneacristian.codechallenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int currentBatteryLevel = 1;
    private ImageView batteryImageView;
    private View decreaseBatteryLevelButton;
    private View increaseBatteryLevelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryImageView = findViewById(R.id.batteryLevels);
        decreaseBatteryLevelButton = findViewById(R.id.decreaseBatteryLevel);
        increaseBatteryLevelButton = findViewById(R.id.increaseBatteryLevel);

        updateBatteryLevel(currentBatteryLevel);
    }

    public void onClickDecreaseBatteryLevel(View view) {
        if (currentBatteryLevel > 1) {
            updateBatteryLevel(--currentBatteryLevel);
        } else {
            Toast.makeText(this,"Minimum battery level", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickIncreaseBatteryLevel(View view) {
        if (currentBatteryLevel < 7) {
            updateBatteryLevel(++currentBatteryLevel);
        } else {
            Toast.makeText(this,"Full battery", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateBatteryLevel(int batteryLevel) {
        batteryImageView.setImageLevel(batteryLevel);
    }
}
