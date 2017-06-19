package devteam.com.appintro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    public boolean isFirstStart;
    private long SPLASH_TIME_OUT = 2000;//time of delay


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  Intro App Initialize SharedPreferences
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);

                // Make sure the application has already opened before opened
                if (isFirstStart)
                {
                    // Activity Splash
                    startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                    SharedPreferences.Editor e = getSharedPreferences.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                    finish();
                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }


            }//rum
        }, SPLASH_TIME_OUT);
    }//onCreate
}// class SplashActivity
