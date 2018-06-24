package com.app.fran.copanamo.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.app.fran.copanamo.R;
import com.app.fran.copanamo.fragments.FragmentFinal;
import com.app.fran.copanamo.fragments.FragmentOitavas;
import com.app.fran.copanamo.fragments.FragmentQuartas;
import com.app.fran.copanamo.fragments.FragmentSemiFin;
import com.app.fran.copanamo.utils.DepthPageTransformer;

public class FaseFinalTabbed extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fase_final);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_oitavas);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Fases finais");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setVisibility(View.VISIBLE);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //config botão voltar
                if(mViewPager.getCurrentItem() == 0){
                    super.onBackPressed();
                }else{
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                }
                break;
            default:break;
        }
        return true;
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
                    FragmentOitavas fragmentOitavas = new FragmentOitavas();
                    return fragmentOitavas;
                case 1:
                    FragmentQuartas fragmentQuartas = new FragmentQuartas();
                    return fragmentQuartas;
                case 2:
                    FragmentSemiFin fragmentSemiFin = new FragmentSemiFin();
                    return fragmentSemiFin;

                case 3:
                    FragmentFinal fragmentFinal = new FragmentFinal();
                    return fragmentFinal;

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
