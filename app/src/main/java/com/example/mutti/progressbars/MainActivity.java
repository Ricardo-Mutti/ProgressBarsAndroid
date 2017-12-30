package com.example.mutti.progressbars;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    Context context = this;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }





    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {


        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {

                case 0:

                    return new ProgressBar_standard();//Retorna o fragmento

                case 1:

                    return new ProgressBar_indeterminate();//Retorna o fragmento

                case 2:

                    return new ProgressBar_image();//Retorna o fragmento


               default://Retorn um fragmento que é inflado com layouts diferentes
                   android.support.v4.app.Fragment fragment = new ProgressBarsFragment();
                   Bundle bundle = new Bundle();
                   bundle.putInt("count", position+1);
                   fragment.setArguments(bundle);
                   return fragment;
            }

        }

        @Override
        public int getCount() {
            return 7;//numero de paginas
        }
    }

}//fim activity
