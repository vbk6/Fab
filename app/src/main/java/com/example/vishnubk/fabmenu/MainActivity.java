package com.example.vishnubk.fabmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2,FAB,fab_1,fab_2,fab_3;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward,show_fab_1,hide_fab_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        //fab vertical anim
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);

        //FAB circle anim
//        FAB = (FloatingActionButton)findViewById(R.id.FAB);
//        fab_1 = (FloatingActionButton)findViewById(R.id.fab_1);
//        fab_2 = (FloatingActionButton)findViewById(R.id.fab_2);
//        fab_3 = (FloatingActionButton)findViewById(R.id.fab_3);
//        show_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_show);
//        hide_fab_1 = AnimationUtils.loadAnimation(getApplication(), R.anim.fab1_hide);
//
//        FAB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CircleFab();
//            }
//        });
    }

//    private void CircleFab() {
//        if(isFabOpen){
//            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab_1.getLayoutParams();
//            layoutParams.rightMargin -= (int) (fab_1.getWidth() * 1.7);
//            layoutParams.bottomMargin -= (int) (fab_1.getHeight() * 0.25);
//            fab_1.setLayoutParams(layoutParams);
//            fab_1.startAnimation(hide_fab_1);
//            fab_1.setClickable(false);
//        }else{
//            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fab_1.getLayoutParams();
//            layoutParams.rightMargin += (int) (fab_1.getWidth() * 1.7);
//            layoutParams.bottomMargin += (int) (fab_1.getHeight() * 0.25);
//            fab_1.setLayoutParams(layoutParams);
//            fab_1.startAnimation(show_fab_1);
//            fab_1.setClickable(true);
//        }
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
                animateFAB();
                Log.d("Raj", "Fab 1");
                break;
            case R.id.fab2:
                animateFAB();
                Log.d("Raj", "Fab 2");
                break;
        }
    }
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
