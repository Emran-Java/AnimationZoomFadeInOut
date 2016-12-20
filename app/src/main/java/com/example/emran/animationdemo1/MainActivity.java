package com.example.emran.animationdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llAnimObj;
    private Button btnZoomOut, btnZoomIn;

    private Animation zoomOut, zoomIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialView();
        initialListener();
    }

    private void initialView() {
        setContentView(R.layout.activity_main);
        llAnimObj = (LinearLayout) findViewById(R.id.llAnimObj);
        btnZoomOut =   (Button) findViewById(R.id.btnZoomOut);
        btnZoomIn =   (Button) findViewById(R.id.btnZoomIn);
        btnZoomIn.setEnabled(false);

        //Initialize animation
        zoomOut = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoomin);
    }

    private void initialListener() {

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimationsZoomOut();

            }
        });

        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimationsZoomIn();
            }
        });

        zoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //TODO,
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                closeLayout();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //TODO,
            }
        });

        zoomIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                openLayout();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //TODO,
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //TODO,
            }
        });
    }

    private void openLayout() {
        llAnimObj.setVisibility(View.VISIBLE);
        btnZoomOut.setEnabled(true);
        btnZoomIn.setEnabled(false);
    }

    private void closeLayout() {
        llAnimObj.setVisibility(View.GONE);
        btnZoomIn.setEnabled(true);
        btnZoomOut.setEnabled(false);
    }

    /*#################### Animation function ####################*/

    private void startAnimationsZoomOut() {
        llAnimObj.startAnimation(zoomOut);
    }

    private void startAnimationsZoomIn() {
        llAnimObj.startAnimation(zoomIn);
    }
    //-------------------------------------------------------------
}
