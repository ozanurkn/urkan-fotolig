package com.ozan.positivemulakat.ui.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ozan.positivemulakat.R;
import com.ozan.positivemulakat.ui.BaseActivity;
import com.ozan.positivemulakat.ui.mainscreen.MainPageActivity;

import butterknife.BindView;

public class SplashScreenActivity extends BaseActivity {

    @BindView(R.id.logo_positive)
    ImageView logo_positive;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void initViews() {

        //Delay for screensplash (3 sec)
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent goMainPage = new Intent(getContext(),MainPageActivity.class);
                startActivity(goMainPage);
                finish();

            }
        }, 1000);

    }

    @Override
    protected Context getContext() {
        return SplashScreenActivity.this;
    }


}
