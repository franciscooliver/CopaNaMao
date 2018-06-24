package com.app.fran.copanamo.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.os.ResultReceiver;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.fragments.PartidasFragment;
import com.app.fran.copanamo.fragments.PartidasFragment2;
import com.app.fran.copanamo.fragments.PartidasFragment3;
import com.app.fran.copanamo.fragments.ResultadosFragment;
import com.app.fran.copanamo.fragments.ResultadosFragment2;
import com.app.fran.copanamo.fragments.ResultadosFragment3;
import com.app.fran.copanamo.utils.DepthPageTransformer;
import com.app.fran.copanamo.utils.TimeService;

import java.lang.ref.WeakReference;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ActivityResultadosTabbed extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_tabbed);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabbed);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Resultados - fase de grupos");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container_result);
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
                    ResultadosFragment resultadosFragment = new ResultadosFragment();
                    return resultadosFragment;

                case 1:

                    ResultadosFragment2 resultadosFragment2 = new ResultadosFragment2();
                    return resultadosFragment2;

                case 2:

                    ResultadosFragment3 resultadosFragment3 = new ResultadosFragment3();
                    return resultadosFragment3;

            }

            return null;

        }

        @Override
        public int getCount() {
            // quantidade de paginas
            return 3;
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
