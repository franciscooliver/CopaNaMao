package com.app.fran.copanamo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.fran.copanamo.utils.DepthPageTransformer;

public class FaseFinalTabbed extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fase_final);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabbed);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Fase final");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //retorna os tabs fragments
            switch (position){
                case 0:


                case 1:



                case 2:




            }

            return null;

        }

        @Override
        public int getCount() {
            // quantidade de paginas
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //titulo das tabs->não aplicável no contexto desse app
            switch (position){
                case 0:
                    return  "RODADA 1-3";
                case 1:
                    return  "RODADA 2-3";
                case 2:
                    return  "SECTION 1";

            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        //config botão voltar
        if(mViewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }

    }


}
