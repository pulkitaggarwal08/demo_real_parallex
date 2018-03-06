package pulkit.demo_real_parallex.com.demoimageslider;

import android.graphics.Point;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pulkit.demo_real_parallex.com.demoimageslider.adapter.MyPagerAdapter;
import pulkit.demo_real_parallex.com.demoimageslider.fragments.Fragment1;
import pulkit.demo_real_parallex.com.demoimageslider.fragments.Fragment2;
import pulkit.demo_real_parallex.com.demoimageslider.fragments.Fragment3;
import pulkit.demo_real_parallex.com.demoimageslider.realParallex.RealHorizontalScrollView;
import pulkit.demo_real_parallex.com.demoimageslider.realParallex.RealViewPager;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private RealHorizontalScrollView realHorizontalScrollView;
    private RealViewPager realViewPager;
    private Display display;
    private PagerAdapter realViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();
    }

    private void findIds() {

        realHorizontalScrollView = (RealHorizontalScrollView) findViewById(R.id.main_horizontal_scrollview);
        realViewPager = (RealViewPager) findViewById(R.id.main_view_pager);
    }

    private void init() {

        addFragments();

        display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        setAdapter();
    }

    private void addFragments() {

        fragmentList.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragmentList.add(Fragment.instantiate(this, Fragment2.class.getName()));
        fragmentList.add(Fragment.instantiate(this, Fragment3.class.getName()));
    }

    private void setAdapter() {

        realViewPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        realViewPager.setAdapter(realViewPagerAdapter);

        realViewPager.configureWithMyListener(realHorizontalScrollView);

        //Check the SDk Version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            realViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    realViewPager.manageScrollWithMyListeners(scrollX, 0);
                }
            });
        }
        else {
            realViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    realViewPager.manageScrollWithMyListeners(positionOffsetPixels,position);
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }

}
