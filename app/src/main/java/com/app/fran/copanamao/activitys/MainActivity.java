package com.app.fran.copanamao.activitys;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.app.fran.copanamao.R;
import com.app.fran.copanamao.fragments.GruposFragment;
import com.app.fran.copanamao.fragments.MainFragment;
import com.app.fran.copanamao.fragments.NoticiasFragment;
import com.app.fran.copanamao.utils.Preferencias;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {
    private static final long ID_ND_FOOTER = 500;
    private static final long ID_ND_HOME = 501;
    private static final long ID_ND_RESULTADOS = 502;
    private static final long ID_ND_PARTIDAS = 503;
    private static final long ID_ND_GRUPO = 504;
    private static final long ID_ND_NOTICIAS = 505;
    private static final long ID_ND_FASE_FINAL = 506;
    private static final long ID_ND_VIDEOS = 507;



    FragmentManager fm;

    Toolbar toolbar;
    Drawer drawer;
    AlertDialog alert;
    Preferencias preferencias;
    String nomeUsuario;
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        preferencias = new Preferencias(this);

        if(preferencias.recuperaNomeUsuario() == ""  || preferencias.recuperaNomeUsuario() == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.dialog_nome_user, null);
            final EditText nome = view.findViewById(R.id.edt_nome);
            Button btnOk = view.findViewById(R.id.btnOk);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nomeUsuario = nome.getText().toString();
                    if(validaCampoNome(nome,nomeUsuario)){
                        preferencias.salvaNomeUsuario(nomeUsuario);
                        alert.dismiss();
                        setDrawer();
                    }

                }
            });

            builder.setView(view);
            builder.setCancelable(false);
            alert = builder.create();
            alert.show();
        }

        if(preferencias.recuperaNomeUsuario() != null){
            setDrawer();

        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.sair:
                finish();

        }
        return super.onOptionsItemSelected(item);
    }

    private boolean validaCampoNome(EditText edt_nome, String nome){
         boolean result = true;

        if("".equals(nome) || nome == null){
            edt_nome.setError("Preencha com seu nome");
            result = false;
        }
        return result;
    }
   //cria e configura os itens da barra lateral
    private void setDrawer(){

        final PrimaryDrawerItem itemHome = new PrimaryDrawerItem()
                .withName("Home")
                .withIdentifier(ID_ND_HOME)
                .withIcon(GoogleMaterial.Icon.gmd_home);

        final PrimaryDrawerItem itemPartidas = new PrimaryDrawerItem()
                .withName("Partidas")
                .withIdentifier(ID_ND_PARTIDAS)
                .withIcon(R.drawable.bool_footbal);

        final PrimaryDrawerItem itemGrupos = new PrimaryDrawerItem()
                .withName("Grupos/Classificação")
                .withIdentifier(ID_ND_GRUPO)
                .withIcon(GoogleMaterial.Icon.gmd_view_list);

        final PrimaryDrawerItem itemResultados = new PrimaryDrawerItem()
                .withName("Resultado de jogos")
                .withIdentifier(ID_ND_RESULTADOS)
                .withIcon(R.drawable.results)
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_orange_700));

        final PrimaryDrawerItem itemNoticias = new PrimaryDrawerItem()
                .withName("Últimas notícias da copa")
                .withIdentifier(ID_ND_NOTICIAS)
                .withIcon(GoogleMaterial.Icon.gmd_notifications)
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_orange_700));

        final PrimaryDrawerItem itemVideos = new PrimaryDrawerItem()
                .withName("Vídeos")
                .withIdentifier(ID_ND_VIDEOS)
                .withIcon(GoogleMaterial.Icon.gmd_video_library)
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_orange_700));

        final PrimaryDrawerItem itemFaseFinal = new PrimaryDrawerItem()
                .withName("Fase final")
                .withIdentifier(ID_ND_FASE_FINAL)
                .withIcon(GoogleMaterial.Icon.gmd_event_note)
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_orange_700));

        AccountHeader drawerHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Olá " + preferencias.recuperaNomeUsuario())

                )
                .build();

        drawer = new DrawerBuilder()
                .withAccountHeader(drawerHeader)
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new SectionDrawerItem().withName("Opções do App"),
                        itemHome,
                        itemPartidas,
                        itemGrupos,
                        itemResultados,
                        itemNoticias,
                        itemVideos,
                        itemFaseFinal
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        try {
                            configuraItensDrawer(position, drawerItem);
                        } catch (PackageManager.NameNotFoundException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                })
                .build();


        //footer do drawer
        drawer.addStickyFooterItem(new PrimaryDrawerItem()
                .withName("Sobre o App")
                .withIcon(GoogleMaterial.Icon.gmd_info)
                .withIdentifier(ID_ND_FOOTER));

        // Pega o FragmentManager
        fm = getSupportFragmentManager();

         //Abre uma transação e adiciona fragment
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content, new MainFragment());
        ft.commit();

    }

    private  void configuraItensDrawer(int position , IDrawerItem drawerItem) throws PackageManager.NameNotFoundException {
        // Abre uma transação e adiciona
        FragmentTransaction ft = fm.beginTransaction();
        switch ((int) drawerItem.getIdentifier()){

            case (int) ID_ND_HOME:
                getSupportActionBar().setTitle("Copa na mão");
                ft.replace(R.id.fragment_content, new MainFragment());
                ft.commit();

                break;
            case (int) ID_ND_PARTIDAS :

                /*getSupportActionBar().setTitle("Tabela");
                ft.replace(R.id.fragment_content, new PartidasFragment());
                ft.commit();*/
                Intent intent = new Intent(MainActivity.this, ActivityPartidasTabbed.class);
                startActivity( intent );
                break;
            case (int) ID_ND_RESULTADOS:
                Intent i = new Intent(MainActivity.this, ActivityResultadosTabbed.class);
                startActivity(i);
                break;
            case (int) ID_ND_NOTICIAS:
                getSupportActionBar().setTitle("Últimas notícias da copa");
                ft.replace(R.id.fragment_content, new NoticiasFragment());
                ft.commit();
                break;

            case (int) ID_ND_GRUPO:
                getSupportActionBar().setTitle("GRUPO A-H");
                ft.replace(R.id.fragment_content, new GruposFragment());
                ft.commit();
                break;

            case (int) ID_ND_FASE_FINAL:
                Intent intFaseFinal = new Intent(MainActivity.this, FaseFinalTabbed.class);
                startActivity(intFaseFinal);
                break;

            case (int) ID_ND_VIDEOS:
                Intent intent_videos = new Intent(MainActivity.this, VideosActivity.class);
                startActivity( intent_videos );
                break;

            case (int) ID_ND_FOOTER:

                PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                String version = pInfo.versionName;
                alertDialog = new AlertDialog.Builder(this);
                View view = getLayoutInflater().inflate(R.layout.view_info_app, null);
                TextView v = view.findViewById(R.id.version);
                v.setText("Version: "+version);
                alertDialog.setView(view);
                alertDialog.show();

                //Snackbar.make(drawer.getRecyclerView(), "Versão: "+version, Snackbar.LENGTH_LONG).show();
                break;
        }

        drawer.closeDrawer();

    }


}
