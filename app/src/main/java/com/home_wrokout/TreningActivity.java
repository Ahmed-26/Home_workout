package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.Alarm_RecyclerView.Alarm_activity;
import com.home_wrokout.Level.AbsActivity;
import com.home_wrokout.Level.ChestActivity;
import com.home_wrokout.Level.LegsAzctivity;
import com.home_wrokout.Level.BackActivity;
import com.home_wrokout.Level.ArmsActivity;

public class TreningActivity extends AppCompatActivity {
    private Button abs;
    private Button chest;
    private Button arms;
    private Button legs;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treningi);

        abs =findViewById(R.id.button5);
        chest =findViewById(R.id.button4);
        arms =findViewById(R.id.button);
        legs =findViewById(R.id.button2);
        back =findViewById(R.id.button3);
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openBrzuchPozActivity();}
        });

        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openKlataPozActivity();}
        });

        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openRamionaPozActivity();}
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openNogiPozActivity();}
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openPlecyPozActivity();}
        });

    }
    public void openBrzuchPozActivity(){
        Intent intent = new Intent(this, AbsActivity.class);
        startActivity(intent);
    }
    public void openKlataPozActivity(){
        Intent intent = new Intent(this, ChestActivity.class);
        startActivity(intent);
    }
    public void openRamionaPozActivity(){
        Intent intent = new Intent(this, ArmsActivity.class);
        startActivity(intent);
    }

    public void openNogiPozActivity(){
        Intent intent = new Intent(this, LegsAzctivity.class);
        startActivity(intent);
    }

    public void openPlecyPozActivity(){
        Intent intent = new Intent(this, BackActivity.class);
        startActivity(intent);
    }

    public static class MainActivity extends AppCompatActivity {
        private Button button;
        private Button plan;
        private Button report;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);




            Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
            if (isFirstRun) {
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
            }
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

            button=findViewById(R.id.button12);
            plan=findViewById(R.id.button10);
            report =findViewById(R.id.button13);
            plan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openAlarm_activity();
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   openTreningiActivity();
                }
            });

            report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openRaportActivity();
                }
            });
        }
        public void openTreningiActivity(){
            Intent intent = new Intent(this, TreningActivity.class);
            startActivity(intent);
        }
        public void openAlarm_activity(){
            Intent intent = new Intent(this, Alarm_activity.class);
            startActivity(intent);
        }
        public void openRaportActivity(){
            Intent intent = new Intent(this, ReportActivity.class);
            startActivity(intent);
        }

        @Override
        public void onBackPressed()
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }
}