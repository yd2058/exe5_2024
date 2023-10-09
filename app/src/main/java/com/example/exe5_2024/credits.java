package com.example.exe5_2024;
/**
 * @author		Yiftah David yd2058@bs.amalnet.k12.il
 * @version	1.1
 * @since		9/10/2023
 * this screen is a credits screen with the ability to return to the calculator screen..
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    /**
     * Returns the user to calculator screen.
     * <p>
     *
     * @param	view Description	refers to the current activity.
     */

    public void artza(View view) {
        finish();
    }
}