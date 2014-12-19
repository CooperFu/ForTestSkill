package io.naotou.forfire;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<String> textList = new ArrayList<String>();
    private List<View> pagerList = new ArrayList<View>();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        tv = (TextView) findViewById(R.id.tv);
        pager.setAdapter(new MyAdapter());
        tv.setFocusable(false);
        tv.setClickable(false);


        ImageView iv1 = new ImageView(this);
        iv1.setBackgroundColor(Color.GRAY);
        ImageView iv2 = new ImageView(this);
        iv2.setBackgroundColor(Color.BLUE);
        ImageView iv3 = new ImageView(this);
        iv3.setBackgroundColor(Color.YELLOW);

        pagerList.add(iv1);
        pagerList.add(iv2);
        pagerList.add(iv3);
        tv.setText("第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页");

        pager.setAdapter(new MyAdapter());

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        tv.setText("第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页第一页");
                        break;
                    case 1:
                        tv.setText("第二页第二页第二页第二页第二页第二页第二页第二页第二页第二页第二页第二页");
                        break;
                    case 2:
                        tv.setText("第三页第三页第三页第三页第三页第三页第三页第三页第三页第三页第三页第三页");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });

    }

    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return pagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pagerList.get(position));
            return pagerList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}