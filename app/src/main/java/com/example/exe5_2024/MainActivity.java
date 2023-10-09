package com.example.exe5_2024;
/**
 * @author		Yiftah David yd2058@bs.amalnet.k12.il
 * @version	1.1
 * @since		9/10/2023
 * this screen is a mathematical series calculator that utilizes custom alert dialog in order to input its required parameters.
 */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    double[] ser = new double[20];
    double mod, sum, strt;
    String[] vser = new String[20];
    ListView lstv;
    TextView tvx, tvd, tvn, tvsn;
    AlertDialog.Builder adb;
    LinearLayout adlayout;
    EditText adetstrt, adetmod;
    ToggleButton adtgtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstv = (ListView) findViewById(R.id.lstv);
        tvx = findViewById(R.id.tvx);
        tvd = findViewById(R.id.tvd);
        tvn = findViewById(R.id.tvn);
        tvsn = findViewById(R.id.tvsn);


        /*if (gi.getBooleanExtra("type", true)) {
            for (int i = 1; i < 20; i++) {
                ser[i] = ser[i - 1] * mod;
            }
        } else {
            for (int i = 1; i < 20; i++) {
                ser[i] = ser[i - 1] + mod;
            }
        }
        for (int i = 0; i < 20; i++) {
            vser[i] = (ser[i]) + "";
        }*/

        lstv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstv.setOnItemClickListener(this);




        /**
         * uses an adapter for the listview on-screen since it wouldn't work in the listener action.
         * <p>
         *
         */


    }
    public void adp(){
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, vser);
        lstv.setAdapter(adp);
    }

    /**
     * creates a custom alert dialog in reaction to a button.
     * <p>
     *
     * @param	view Description	refers to the current activity.
     */

    public void ret(View view) {
        adlayout = (LinearLayout) getLayoutInflater().inflate(R.layout.alertdialog, null);
        adetstrt = (EditText) adlayout.findViewById(R.id.adetstrt);
        adetmod = (EditText) adlayout.findViewById(R.id.adetmod);
        adtgtp = adlayout.findViewById(R.id.adtgtp);

        adb = new AlertDialog.Builder(this);

        adb.setView(adlayout);
        adb.setTitle("Enter Parameters For Series");
        adb.setMessage("Please select type");
        adb.setPositiveButton("Calc",click);
        adb.setNegativeButton("Cancel",click);
        adb.show();
    }

    /**
     * reacts to data received from alertdialog.
     * <p>
     *
     * @param	dialog Description	refers to alertdialog that was just interacted with.
     * @param   which  Description  refers to which alertdialog button was pressed.
     */

    DialogInterface.OnClickListener click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                ser[0] = Float.parseFloat(adetstrt.getText().toString());
                mod = Float.parseFloat(adetmod.getText().toString());
                if (adtgtp.isActivated()) {
                    for (int i = 1; i < 20; i++) {
                        ser[i] = ser[i - 1] * mod;
                    }
                } else {
                    for (int i = 1; i < 20; i++) {
                        ser[i] = ser[i - 1] + mod;
                    }
                }
                for (int i = 0; i < 20; i++) {
                    vser[i] = (ser[i]) + "";
                }
            adp();
            }
            if (which== DialogInterface.BUTTON_NEGATIVE){
                dialog.cancel();
            }
        }
    };

    /**
     * reacts to clicking on items on the listview on screen.
     * <p>
     *
     * @param	parent Description	refers to adapter used on listview.
     * @param   view   Description  refers to current activity.
     * @param   position Description refers to listview position of clicked item.
     * @param	id     Description  refers to item id.
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvx.setText("X1 = "+ ser[0]);
        tvd.setText("d = "+mod);
        tvn.setText("n = "+ (position+1));
        sum = 0;
        for (int i = 0; i <= position; i++) {sum+=ser[i];}
        tvsn.setText("Sn = "+ sum);
    }
    /**
     * reacts to button and sends to credits screen.
     * <p>
     *
     * @param	view Description	refers to current activity.
     */

    public void credits(View view) {
    Intent si = new Intent(this, credits.class);
    startActivity(si);
    }
}