package com.example.fran.copanamo;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.fran.copanamo.fragments.GruposFragment;
import com.example.fran.copanamo.fragments.NoticiasFragment;
import com.example.fran.copanamo.fragments.ResultadosFragment;
import com.example.fran.copanamo.fragments.TabelaFragment;
import com.example.fran.copanamo.utils.Preferencias;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
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
    private static final long ID_ND_RESULTADOS = 501;
    private static final long ID_ND_TABELA = 502;
    private static final long ID_ND_GRUPO = 503;
    private static final long ID_ND_NOTICIAS = 504;

    FragmentManager fm;

    Toolbar toolbar;
    Drawer drawer;
    AlertDialog alert;
    Preferencias preferencias;
    String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );
        preferencias = new Preferencias(this);

        if(preferencias.recuperaNomeUsuario() ==""  || preferencias.recuperaNomeUsuario() == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.dialog_nome_user, null);
            final EditText nome = view.findViewById(R.id.edt_nome);
            Button btnOk = view.findViewById(R.id.btnOk);
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nomeUsuario = nome.getText().toString();
                    preferencias.salvaNomeUsuario(nomeUsuario);
                    alert.dismiss();
                    setDrawer();
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

    private void setDrawer(){

        final PrimaryDrawerItem itemTabela = new PrimaryDrawerItem()
                .withName("Tabela")
                .withIdentifier(ID_ND_TABELA)
                .withIcon(GoogleMaterial.Icon.gmd_person);

        final PrimaryDrawerItem itemGrupos = new PrimaryDrawerItem()
                .withName("Grupos")
                .withIdentifier(ID_ND_GRUPO)
                .withIcon(GoogleMaterial.Icon.gmd_person);

        final PrimaryDrawerItem itemResultados = new PrimaryDrawerItem()
                .withName("Resultado de jogos")
                .withIdentifier(ID_ND_RESULTADOS)
                .withIcon(FontAwesome.Icon.faw_th_list)
                .withBadgeStyle(new BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_orange_700));

        final PrimaryDrawerItem itemNoticias = new PrimaryDrawerItem()
                .withName("Últimas notícias da copa")
                .withIdentifier(ID_ND_NOTICIAS)
                .withIcon(GoogleMaterial.Icon.gmd_shop_two)
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
                        itemTabela,
                        itemGrupos,
                        itemResultados,
                        itemNoticias
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

        drawer.addStickyFooterItem(new PrimaryDrawerItem()
                .withName("Sobre o App")
                .withIcon(GoogleMaterial.Icon.gmd_info)
                .withIdentifier(ID_ND_FOOTER));

        // Pega o FragmentManager
        fm = getSupportFragmentManager();

        // Abre uma transação e adiciona fragment
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_content, new TabelaFragment());
        ft.commit();

    }

    private  void configuraItensDrawer(int position , IDrawerItem drawerItem) throws PackageManager.NameNotFoundException {
        // Abre uma transação e adiciona
        FragmentTransaction ft = fm.beginTransaction();
        switch ((int) drawerItem.getIdentifier()){
            case (int) ID_ND_TABELA :
                ft.replace(R.id.fragment_content, new TabelaFragment());
                ft.commit();
                break;
            case (int) ID_ND_RESULTADOS:
                ft.replace(R.id.fragment_content, new ResultadosFragment());
                ft.commit();
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

            case (int) ID_ND_FOOTER:

                PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                String version = pInfo.versionName;

                Snackbar.make(drawer.getRecyclerView(), "Versão: "+version, Snackbar.LENGTH_LONG).show();
                break;
        }

        drawer.closeDrawer();

    }
}
