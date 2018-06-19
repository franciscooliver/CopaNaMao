package com.app.fran.copanamao.activitys;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.app.fran.copanamao.R;
import com.app.fran.copanamao.fragments.PartidasFragment;
import com.app.fran.copanamao.fragments.PartidasFragment2;
import com.app.fran.copanamao.fragments.PartidasFragment3;
import com.app.fran.copanamao.utils.DepthPageTransformer;

public class ActivityPartidasTabbed extends AppCompatActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidas_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_tabbed);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Partidas - fase de grupos");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_partidas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.info) {
            Toast.makeText(ActivityPartidasTabbed.this, "Em breve...", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position){
                case 0:
                    PartidasFragment partidasFragment = new PartidasFragment();
                    return partidasFragment;
                case 1:

                    PartidasFragment2 partidasFragment2 = new PartidasFragment2();
                    return partidasFragment2;
                case 2:

                    PartidasFragment3 partidasFragment3 = new PartidasFragment3();
                    return partidasFragment3;

            }

            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
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
        if(mViewPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }

    }

}
