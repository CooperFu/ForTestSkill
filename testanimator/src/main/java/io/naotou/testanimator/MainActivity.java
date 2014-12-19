package io.naotou.testanimator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Interpolator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.impl.io.AbstractSessionInputBuffer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private int[] res = {R.id.home,R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6};
    private List<View> imageList = new ArrayList<View>();
    private boolean flag = false;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < res.length; i++) {
            imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageList.add(imageView);
        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.home:
                Toast.makeText(this,"点击了home",Toast.LENGTH_SHORT).show();
                startAnim();
                break;
            default:
                Toast.makeText(this,"点击了"+v.getId(),Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startAnim() {
        if (!flag) {
            for (int i = 1; i < res.length; i++) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", 0F, i * 100);
                animator.setDuration(500);
                animator.setStartDelay(i * 300);
                animator.setInterpolator(new BounceInterpolator());
                animator.start();
            }
            flag = true;

        } else {
            for (int i = 1; i < res.length; i++) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i), "translationY", i * 100,0F);
                animator.setDuration(500);
                animator.setStartDelay(i * 300);
                animator.setInterpolator(new OvershootInterpolator());
                animator.start();
            }
            flag = false;
        }
    }
}
