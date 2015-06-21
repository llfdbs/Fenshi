package com.mikepenz.materialdrawer.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.app.R;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.quickdv.activity.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    TextView welcome;
    ImageView root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initAnimation();
    }


    @Override
    public void initView() {
        welcome = findView(R.id.welcome);

    }

    @Override
    public void initActionbar() {

    }

    @Override
    public void initData() {

    }

    private void initAnimation(){
        AnimatorSet set = new AnimatorSet();

        ObjectAnimator unalpha = new ObjectAnimator().ofFloat(welcome,"alpha",0.0f,1.0f);
        unalpha.setDuration(1000);

        ObjectAnimator alpha = new ObjectAnimator().ofFloat(welcome,"alpha",1.0f,0.0f);
        alpha.setDuration(1000);

        set.play(unalpha).before(alpha);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent= new Intent(WelcomeActivity.this,SimpleNonTranslucentDrawerActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
